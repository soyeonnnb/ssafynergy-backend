package com.ssafy.controller.user;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.board.Board;
import com.ssafy.model.dto.user.User;
import com.ssafy.model.service.user.UserService;
import com.ssafy.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class UserController {

	@Autowired
	private UserService us;

	@Autowired
	private JwtUtil jwtUtil;

	private String SUCCESS = "success";
	private String FAIL = "fail";

	@ApiOperation(value = "회원가입") // , response = List.class)
	@PostMapping
	public ResponseEntity<String> regist(@RequestBody User user) {
		// 이미 존재하는 아이디이면 회원가입 불가
		if (us.selectById(user.getId()) != null) {
			return new ResponseEntity<String>("existsUserId", HttpStatus.CONFLICT);
		}
		// 이미 존재하는 닉네임이면 회원가입 불가
		if (us.selectByNickname(user.getNickname()) != null) {
			return new ResponseEntity<String>("existsNickname", HttpStatus.CONFLICT);
		}
		// 소셜로그인이 아님을 확인
		user.setSocialLogin("F"); // false

		int result = us.regist(user);
		if (result == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "로그인")
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(HttpSession session, @RequestBody User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		HttpStatus status = null;
		try {
			User dbUser = us.selectByIdAndPassword(user);
//			System.out.println(dbUser);
			if (dbUser != null) {
				result.put("access-token", jwtUtil.createToken("id", user.getId()));
				result.put("message", SUCCESS);
				dbUser.setPassword("");
				System.out.println((User) session.getAttribute("loginUser"));
				session.setAttribute("loginUser", dbUser);
				result.put("loginUser", dbUser);
				status = HttpStatus.ACCEPTED;
			} else {
				result.put("message", FAIL);
				status = HttpStatus.BAD_REQUEST;
			}
		} catch (UnsupportedEncodingException e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(result, status);

	}

//	@ApiOperation(value = "비밀번호 재설정")
//	@PostMapping("/password")
//	public ResponseEntity<?> changePassword(@RequestBody User user) {
//		
//	}

	@ApiOperation(value = "로그아웃")
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		System.out.println((User) session.getAttribute("loginUser"));
		session.removeAttribute("loginUser");
		return new ResponseEntity<String>(SUCCESS, HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "회원정보 열람")
	@GetMapping("/{id}")
	public ResponseEntity<?> viewUserInfo(@PathVariable String id) {
		User user = us.selectById(id);
		if (user == null) {
			return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "회원정보 수정")
	@PutMapping
	public ResponseEntity<?> updateUserInfo(@RequestHeader("access-token") String token, @RequestBody User user) {
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			user.setId(userId);
			int result = us.update(user);
			if (result == 1) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
			}
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_GATEWAY);
		}
		
	}

	@ApiOperation(value = "회원탈퇴")
	@DeleteMapping
	public ResponseEntity<?> withdrawal(@RequestHeader("access-token") String token) {
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			int result = us.withdrawal(userId);
			if (result == 1) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
			}
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_GATEWAY);
		}	
	}
}
