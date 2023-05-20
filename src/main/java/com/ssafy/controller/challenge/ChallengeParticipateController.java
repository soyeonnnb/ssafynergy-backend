package com.ssafy.controller.challenge;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.challenge.ChallengeParticipate;
import com.ssafy.model.service.challenge.ChallengeParticipateService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/challenge-participate")
public class ChallengeParticipateController {
	@Autowired
	private ChallengeParticipateService cs;
	
	@PostMapping("")
	@ApiOperation(value = "챌린지 신청을 한다")
	public ResponseEntity<?> insert(@RequestBody ChallengeParticipate challengeParticipate){
		cs.insert(challengeParticipate);
		return new ResponseEntity<ChallengeParticipate>(challengeParticipate, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "챌린지 신청을 취소한다.")
	public ResponseEntity<String> delete(@RequestBody ChallengeParticipate challengeParticipate, @PathVariable int id){
		cs.delete(challengeParticipate);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("")
	@ApiOperation(value = "챌린지를 중도 포기한다.")
	public ResponseEntity<String> update(@RequestBody ChallengeParticipate challengeParticipate){
		cs.update(challengeParticipate);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("")
	@ApiOperation(value = "나의 챌린지 목록을 조회한다.")
	public ResponseEntity<?> selectId(String userId){
		List<ChallengeParticipate> list = cs.search(userId);
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<ChallengeParticipate>>(list, HttpStatus.OK);
		}
	}
}
