package com.ssafy.controller.challenge;

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

import com.ssafy.model.dto.challenge.Challenge;
import com.ssafy.model.dto.challenge.ChallengeLike;
import com.ssafy.model.service.challenge.ChallengeLikeService;
import com.ssafy.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/challenge/like")
public class ChallengeLikeController {

	@Autowired
	private ChallengeLikeService cs;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("")
	@ApiOperation(value = "챌린지 찜하기")
	public ResponseEntity<?> insert(@RequestHeader("access-token") String token,@RequestBody ChallengeLike challengeLike) {
		
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			challengeLike.setUserId(userId);
			if (cs.isAlreadyLike(challengeLike)) {
				return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
			}
			cs.insert(challengeLike);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_GATEWAY);
		}
	}
	@GetMapping("/{id}")
	@ApiOperation(value = "챌린지를 이미 찜했는지 확인한다.")
	public ResponseEntity<String> isParticipate(@RequestHeader("access-token") String token, @PathVariable int id) {
		ChallengeLike cl = new ChallengeLike();
		cl.setChallengeId(id);
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			cl.setUserId(userId);
			if (cs.isAlreadyLike(cl)) {
				return new ResponseEntity<>("yes", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("no", HttpStatus.NO_CONTENT);
			}
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_GATEWAY);
		}

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "챌린지 찜취소하기")
	public ResponseEntity<String> delete(@RequestHeader("access-token") String token, @PathVariable int id) {
		ChallengeLike cl = new ChallengeLike();
		cl.setChallengeId(id);
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			cl.setUserId(userId);
			cs.delete(cl);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_GATEWAY);
		}
	}

	@GetMapping("/user/{userId}")
	@ApiOperation(value = "찜한 챌린지 목록 조회하기")
	public ResponseEntity<List<Challenge>> search(@PathVariable String userId) {
		List<Challenge> list = cs.search(userId);
		return new ResponseEntity<List<Challenge>>(list, HttpStatus.OK);
	}

}
