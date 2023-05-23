package com.ssafy.controller.challenge;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.challenge.Review;
import com.ssafy.model.service.challenge.ReviewService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
public class ReviewController {

	@Autowired
	private ReviewService rs;

	@PostMapping("/challenge/review")
	@ApiOperation(value = "리뷰를 작성한다.")
	public ResponseEntity<?> insert(@RequestBody Review review) {
		rs.insert(review);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}

	@PutMapping("/challenge/review")
	@ApiOperation(value = "리뷰를 수정한다.")
	public ResponseEntity<?> update(@RequestBody Review review) {
		rs.update(review);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}

	@DeleteMapping("/challenge/review/{id}")
	@ApiOperation(value = "리뷰를 삭제한다.")
	public ResponseEntity<String> delete(@PathVariable int id) {
		rs.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@GetMapping("/challenge/review/{id}")
	@ApiOperation(value = "챌린지{id}별 리뷰 목록을 조회한다.")
	public ResponseEntity<List<Review>> searchChallengeReview(@PathVariable int id) {
		List<Review> list = rs.searchChallengeReview(id);
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/channel/challenge/{challengeId}")
	@ApiOperation(value = "유저{userId}가 챌린지{challengeId}에 작성한 리뷰를 조회한다.")
	public ResponseEntity<List<Review>> searchUserReview(@PathVariable int challengeId) {
		List<Review> list = rs.searchChallengeReview(challengeId);
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
		}
	}

}
