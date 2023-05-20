package com.ssafy.controller.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.challenge.ChallengeDifficulty;
import com.ssafy.model.service.challenge.ChallengeDifficultyService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/challenge-difficulty")
public class ChallengeDifficultyController {
	
	@Autowired
	private ChallengeDifficultyService cs;
	
	@PostMapping("")
	@ApiOperation(value = "챌린지 난이도를 추가한다.")
	public ResponseEntity<?> insert(@RequestBody ChallengeDifficulty challengeDifficulty){
		cs.insert(challengeDifficulty);
		return new ResponseEntity<ChallengeDifficulty>(challengeDifficulty, HttpStatus.OK);
	}
	
	@PutMapping("")
	@ApiOperation(value = "챌린지 난이도를 수정한다.")
	public ResponseEntity<?> update(@RequestBody ChallengeDifficulty challengeDifficulty){
		cs.update(challengeDifficulty);
		return new ResponseEntity<ChallengeDifficulty>(challengeDifficulty, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "챌린지 난이도를 삭제한다.")
	public ResponseEntity<String> delete(@PathVariable int id){
		cs.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
