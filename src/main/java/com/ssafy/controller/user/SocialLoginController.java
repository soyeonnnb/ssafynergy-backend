package com.ssafy.controller.user;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.user.User;
import com.ssafy.model.service.user.SocialLoginService;
import com.ssafy.model.service.user.UserService;
import com.ssafy.util.JwtUtil;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class SocialLoginController {
	
	private String FAIL = "fail";
	
	@Autowired
	private SocialLoginService sls;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/kakao/oauth")
	public ResponseEntity<?> kakaoLogin(@RequestParam(required = false) String code ){
		// 만약 사용자가 로그인 취소를 눌렀다면
		if (code == null) {
			return new ResponseEntity<String>("codeError",HttpStatus.BAD_REQUEST);
		}
		String accessToken = sls.kakaoGetToken(code);
		User user = sls.kakaoGetUserInfo(accessToken);
		System.out.println(user);
		// 사용자 검증
		User dbUser = us.selectById(user.getId());
		// 만약 처음 로그인한거면
		if(dbUser == null) {
			us.regist(user);
		} else {
			if (!dbUser.getSocialLogin().equals("K")) {
				return new ResponseEntity<String>("otherLogin", HttpStatus.BAD_REQUEST);
			}
		}
		dbUser.setPassword("");
		// 로그인
		Map<String, Object> result = new HashMap<String, Object>();
		HttpStatus status = null;
		try {
				result.put("access-token", jwtUtil.createToken("id", user.getId()));
				result.put("message", "success");
				dbUser.setPassword("");
				result.put("loginUser", dbUser);
				status = HttpStatus.ACCEPTED;
		} catch (UnsupportedEncodingException e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(result, status);
		
		
//		return new ResponseEntity<User>(dbUser, HttpStatus.ACCEPTED);
		
	}
}
