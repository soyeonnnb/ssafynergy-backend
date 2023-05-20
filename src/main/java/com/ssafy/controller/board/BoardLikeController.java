package com.ssafy.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.board.BoardLike;
import com.ssafy.model.service.board.BoardLikeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/board")
public class BoardLikeController {
	
	@Autowired
	private BoardLikeService bs;
	
	@PostMapping("")
	@ApiOperation(value = "게시글에 좋아요를 누른다.")
	public ResponseEntity<?> insert(@RequestBody BoardLike boardLike){
		bs.insert(boardLike);
		return new ResponseEntity<BoardLike>(boardLike, HttpStatus.OK);
	}
	
	@DeleteMapping("")
	@ApiOperation(value = "게시글의 좋아요를 취소한다.")
	public ResponseEntity<?> delete(@RequestBody BoardLike boardLike){
		bs.delete(boardLike);
		return new ResponseEntity<BoardLike>(boardLike, HttpStatus.OK);
	}
	
}
