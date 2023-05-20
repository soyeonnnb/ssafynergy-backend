package com.ssafy.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.user.User;
import com.ssafy.model.service.user.SocialLoginService;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class SocialLoginController {
	
	private String FAIL = "fail";
	
	@Autowired
	private SocialLoginService sls;
	
	@GetMapping("/kakao/oauth")
	public void kakaoLogin(@RequestParam(required = false) String code){
		// 만약 사용자가 로그인 취소를 눌렀다면
		if (code == null) {
			System.out.println("null");
			return;
//			return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
		}
		
		String accessToken = sls.kakaoGetToken(code);
		User user = sls.kakaoGetUserInfo(accessToken);
		System.out.println(user);
		// 사용자 검증
		
		// 로그인까지 시켜줌
		
	}
}
