package com.ssafy.model.service.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.user.User;

@Service
@PropertySource("classpath:env.properties")
public class SocialLoginServiceImpl implements SocialLoginService {

	@Autowired
	private Environment env;

	@Override
	public String kakaoGetToken(String code) {
		String host = "https://kauth.kakao.com/oauth/token";
		URL url;
		String token = "";
		try {
			url = new URL(host);

			HttpURLConnection urlConnection;

			urlConnection = (HttpURLConnection) url.openConnection();

			urlConnection.setRequestMethod("POST");

			urlConnection.setDoOutput(true); // 데이터 기록 알려주는 거

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=" + env.getProperty("KAKAO_REST_API"));
			sb.append("&redirect_uri=" + env.getProperty("KAKAO_REDIRECT_URI"));
			sb.append("&code=" + code);
			bw.write(sb.toString());
			bw.flush();

			int responseCode = urlConnection.getResponseCode();
			if (responseCode == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				String line = "";
				String result = "";
				while ((line = br.readLine()) != null) {
					result += line;
				}

				// json parse
				JSONParser parser = new JSONParser();
				JSONObject elem;

				elem = (JSONObject) parser.parse(result);

				String accessToken = elem.get("access_token").toString();

				token = accessToken;
				br.close();
			}
			bw.close();

		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}

	@Override
	public User kakaoGetUserInfo(String accessToken) {
		String host = "https://kapi.kakao.com/v2/user/me";
		URL url;
		try {
			url = new URL(host);

			HttpURLConnection urlConnection;

			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestProperty("Authorization", "Bearer " + accessToken);
			urlConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			urlConnection.setRequestMethod("GET");

			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line = "";
			String res = "";
			while ((line = br.readLine()) != null) {
				res += line;
			}

			JSONParser parser = new JSONParser();
			JSONObject obj;

			obj = (JSONObject) parser.parse(res);

			JSONObject kakao_account = (JSONObject) obj.get("kakao_account");
			JSONObject profile = (JSONObject) kakao_account.get("profile");

			String id = obj.get("id").toString();
			String name = profile.get("nickname").toString();
			String password = "a123456789!";
			String nickname = profile.get("nickname").toString();
			String email = kakao_account.get("email").toString();
			String socialLogin = "K";
			String type="N";

			return new User(id, password, name, nickname, email, socialLogin, type);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
