package com.ssafy.controller.user;

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

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class SocialLoginController {
	
	private String FAIL = "fail";
	
	@Autowired
	private SocialLoginService sls;
	
	@Autowired
	private UserService us;
	
	@GetMapping("/kakao/oauth")
	public ResponseEntity<?> kakaoLogin(HttpSession session, @RequestParam(required = false) String code ){
		// 만약 사용자가 로그인 취소를 눌렀다면
		if (code == null) {
			System.out.println("null");
			return new ResponseEntity<String>("codeError",HttpStatus.BAD_REQUEST);
//			return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
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
		// 로그인까지 시켜줌
		session.setAttribute("loginUser", dbUser);
		return new ResponseEntity<User>(dbUser, HttpStatus.ACCEPTED);
		
	}
}
