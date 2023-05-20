package com.ssafy.controller.board;

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

import com.ssafy.model.dto.board.BoardReview;
import com.ssafy.model.service.board.BoardReviewService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/board/review")
public class BoardReviewController {
	
	@Autowired
	private BoardReviewService bs;
	
	@PostMapping("")
	@ApiOperation(value = "댓글을 등록한다.")
	public ResponseEntity<?> insert(@RequestBody BoardReview boardReview){
		bs.insert(boardReview);
		return new ResponseEntity<BoardReview>(boardReview, HttpStatus.OK);
	}
	
	@PutMapping("")
	@ApiOperation(value = "댓글을 수정한다.")
	public ResponseEntity<String> update(@RequestBody BoardReview boardReview){
		bs.update(boardReview);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "댓글을 삭제한다")
	public ResponseEntity<String> delete(@PathVariable int id){
		bs.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{boardId}")
	@ApiOperation(value = "게시글{boardId}에 대한 댓글을 조회한다.")
	public ResponseEntity<?> selectBoard(@RequestBody BoardReview boardReviewm, @PathVariable int boardId){
		List<BoardReview> list = bs.selectBoard(boardId);
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<BoardReview>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/user/{userId}")
	@ApiOperation(value = "유저{userId}가 작성한 댓글을 조회한다.")
	public ResponseEntity<?> selectUser(@RequestBody BoardReview boardReviewm, @PathVariable String userId){
		List<BoardReview> list = bs.selectUser(userId);
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<BoardReview>>(list, HttpStatus.OK);
		}
	}
	
	
}
