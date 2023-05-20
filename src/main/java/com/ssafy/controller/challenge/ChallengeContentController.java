package com.ssafy.controller.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.challenge.ChallengeContent;
import com.ssafy.model.service.challenge.ChallengeContentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/challenge/content")
public class ChallengeContentController {
	@Autowired
	private ChallengeContentService cs;
	
	@PostMapping("")
	@ApiOperation(value = "챌린지의 내용을 작성한다.")
	public ResponseEntity<?> insert (ChallengeContent challengeContent){
		cs.insert(challengeContent);
		return new ResponseEntity<ChallengeContent>(challengeContent, HttpStatus.OK);
	}
	
	@PutMapping("")
	@ApiOperation(value = "챌린지의 내용을 수정한다.")
	public ResponseEntity<?> update (ChallengeContent challengeContent){
		cs.update(challengeContent);
		return new ResponseEntity<ChallengeContent>(challengeContent, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "챌린지의 내용을 삭제한다.")
	public ResponseEntity<String> delete(@PathVariable int id){
		cs.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}

