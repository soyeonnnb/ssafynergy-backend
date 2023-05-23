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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.challenge.Challenge;
import com.ssafy.model.dto.challenge.ChallengeParticipate;
import com.ssafy.model.service.challenge.ChallengeParticipateService;
import com.ssafy.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/challenge-participate")
public class ChallengeParticipateController {
	@Autowired
	private ChallengeParticipateService cs;
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("")
	@ApiOperation(value = "챌린지 신청을 한다")
	public ResponseEntity<?> insert(@RequestHeader("access-token") String token,
			@RequestBody ChallengeParticipate challengeParticipate) {
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			challengeParticipate.setUserId(userId);
			if (cs.isParticipate(challengeParticipate)) {
				return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
			}
			cs.insert(challengeParticipate);
			return new ResponseEntity<ChallengeParticipate>(challengeParticipate, HttpStatus.OK);
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_GATEWAY);
		}
	}

	@GetMapping("/challenge/{id}")
	@ApiOperation(value = "챌린지를 신청했는지 확인한다.")
	public ResponseEntity<String> isParticipate(@RequestHeader("access-token") String token, @PathVariable int id) {
		ChallengeParticipate cp = new ChallengeParticipate();
		cp.setChallengeId(id);
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			cp.setUserId(userId);
			if (cs.isParticipate(cp)) {
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
	@ApiOperation(value = "챌린지 신청을 취소한다.")
	public ResponseEntity<String> delete(@RequestHeader("access-token") String token, @PathVariable int id) {
		ChallengeParticipate cp = new ChallengeParticipate();
		cp.setChallengeId(id);
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			cp.setUserId(userId);
			cs.delete(cp);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_GATEWAY);
		}

	}

	@PutMapping("")
	@ApiOperation(value = "챌린지를 중도 포기한다.")
	public ResponseEntity<String> update(@RequestHeader("access-token") String token, @RequestBody int id) {
		ChallengeParticipate cp = new ChallengeParticipate();
		cp.setChallengeId(id);
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			cp.setUserId(userId);
			cs.update(cp);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_GATEWAY);
		}

	}

	// 아마도 여길 바꿔야할듯
	@GetMapping("/list/{id}")
	@ApiOperation(value = "나의 챌린지 목록을 조회한다.")
	public ResponseEntity<?> selectId(@PathVariable String id) {
		List<Challenge> list = cs.search(id);
		return new ResponseEntity<List<Challenge>>(list, HttpStatus.OK);

	}
}
