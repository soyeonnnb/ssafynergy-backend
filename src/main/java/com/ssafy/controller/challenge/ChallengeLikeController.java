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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.challenge.ChallengeLike;
import com.ssafy.model.service.challenge.ChallengeLikeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/challenge/like")
public class ChallengeLikeController {
	
	@Autowired
	private ChallengeLikeService cs;
	
	@PostMapping("")
	@ApiOperation(value = "챌린지 찜하기")
	public ResponseEntity<?> insert(@RequestBody ChallengeLike challengeLike, HttpSession session){
		cs.insert(challengeLike);
		return new ResponseEntity<ChallengeLike>(challengeLike, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "챌린지 찜취소하기")
	public ResponseEntity<String> delete(HttpSession session, @PathVariable int id){
		cs.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping("")
	@ApiOperation(value = "찜한 챌린지 목록 조회하기")
	public ResponseEntity<List<ChallengeLike>> search(String userId){
		List<ChallengeLike> list = cs.search(userId);
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<ChallengeLike>>(list, HttpStatus.OK);
		}
	}
	
	
}
