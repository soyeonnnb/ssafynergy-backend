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

import com.ssafy.model.dto.challenge.ChallengeIng;
import com.ssafy.model.service.challenge.ChallengeIngService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/challenge-participate/ing")
public class ChallengeIngController {
	
	@Autowired
	private ChallengeIngService cs;
	
	@PostMapping("/{id}")
	@ApiOperation(value = "당일의 챌린지 현황을 등록한다.")
	public ResponseEntity<?> insert(@RequestBody ChallengeIng challengeIng, @PathVariable int id){
		cs.insert(challengeIng);
		return new ResponseEntity<ChallengeIng>(challengeIng, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "당일의 챌린지 현황을 수정한다.")
	public ResponseEntity<?> update(@RequestBody ChallengeIng challengeIng, @PathVariable int id){
		cs.update(challengeIng);
		return new ResponseEntity<ChallengeIng>(challengeIng, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "전체회원에 대한 현황 목록을 조회한다.")
	public ResponseEntity<List<ChallengeIng>> seleteAll(@PathVariable int id){
		List<ChallengeIng> list = cs.selectAll();
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<ChallengeIng>>(list, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}/{index}")
	@ApiOperation(value = "{index}날짜의 챌린지 현황을 삭제한다.")
	public ResponseEntity<String> delete(@PathVariable(value = "id") int id, @PathVariable(value = "index") int index){
		cs.delete(index);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
