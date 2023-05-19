package com.ssafy.util;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

@Component
public class JwtUtil {

	private static final String SALT = "SSAFYNERGY";
	
	 private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	// 토큰생성
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
		return Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT").claim(claimId, data)
				.signWith(key).compact();
	}

	// 유효성 검사
	public void valid(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(SALT.getBytes("UTF-8")).build().parseClaimsJws(token);
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExpiredJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
