package com.ssafy.controller.user;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.user.Follow;
import com.ssafy.model.dto.user.User;
import com.ssafy.model.service.user.FollowService;
import com.ssafy.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;

@RestController
@RequestMapping("/api/v1/follow")
public class FollowController {

	@Autowired
	private FollowService fs;

	@Autowired
	private JwtUtil jwtUtil;

	
	@GetMapping("/{id}")
	public ResponseEntity<?> getFollower(@PathVariable String id) {
		List<User> list = fs.selectByFollowerId(id);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/following/{id}")
	public ResponseEntity<?> getFollowing(@PathVariable String id) {
		List<User> list = fs.selectByFollowingId(id);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("/{id}/{followUserId}")
	public ResponseEntity<?> getIsFollow(@PathVariable String id, @PathVariable String followUserId) {
		if (fs.isFollow(new Follow(id, followUserId))) {
			return new ResponseEntity<>("yes",HttpStatus.OK);			
		} else {
			return new ResponseEntity<>("no",HttpStatus.OK);
		}
	}
	
	@PostMapping()
	public ResponseEntity<?> doFollow(@RequestHeader("access-token") String token, @RequestBody Follow follow) {
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			follow.setUserId(userId);
			int result = fs.insertFollow(follow);
			if (result == 1) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFollow(@RequestHeader("access-token") String token, @PathVariable String id) {
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			Follow follow = new Follow();
			follow.setFollowUserId(id);
			follow.setUserId(userId);
			int result = fs.deleteFollow(follow);
			if (result == 1) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}

	}
}
