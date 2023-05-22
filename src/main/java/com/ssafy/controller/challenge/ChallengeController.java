package com.ssafy.controller.challenge;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.challenge.Challenge;
import com.ssafy.model.dto.challenge.SearchCondition;
import com.ssafy.model.service.challenge.ChallengeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/challenge")
public class ChallengeController {
	@Autowired
	private ChallengeService cs;

	@PostMapping("")
	@ApiOperation(value = "챌린지를 추가한다.")
	public ResponseEntity<?> insert(@RequestBody Challenge challenge) {
		cs.insert(challenge);
		return new ResponseEntity<Challenge>(challenge, HttpStatus.OK);
	}

	@PutMapping("")
	@ApiOperation(value = "챌린지를 수정한다.")
	public ResponseEntity<String> update(@RequestBody Challenge challenge) {
		cs.update(challenge);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/search")
	@ApiOperation(value = "옵션을 선택하여 챌린지를 검색한다.")
	public ResponseEntity<?> search(SearchCondition searchcondition) {
		List<Challenge> list = cs.search(searchcondition);
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Challenge>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "챌린지{id}의 정보를 반환한다.")
	public ResponseEntity<?> detail(@PathVariable int id) {
		Challenge challenge = cs.select(id);
		if (challenge == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Challenge>(challenge, HttpStatus.OK);
		}
	}

}
