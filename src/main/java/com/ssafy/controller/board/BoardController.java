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

import com.ssafy.model.dto.board.Board;
import com.ssafy.model.dto.challenge.SearchCondition;
import com.ssafy.model.service.board.BoardService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/board")
public class BoardController {
	@Autowired
	private BoardService bs;
	
	@PostMapping("/post")
	@ApiOperation(value = "게시글을 등록한다.")
	public ResponseEntity<?> insert(@RequestBody Board board){
		bs.insert(board);
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	@PutMapping("/post")
	@ApiOperation(value = "게시글을 수정한다.")
	public ResponseEntity<String> update(@RequestBody Board board){
		bs.update(board);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/post/{id}")
	@ApiOperation(value = "게시글을 삭제한다.")
	public ResponseEntity<String> delete(@PathVariable int id){
		bs.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping("/{boardCategoryId}")
	@ApiOperation(value = "카테고리{boardCategoryId} 에서 옵션을 선택하여 검색한다.")
	public ResponseEntity<?> search(SearchCondition searchcondition, @PathVariable String boardCategoryId){
		List<Board> list = bs.search(searchcondition);
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/post/{userId}")
	@ApiOperation(value = "유저{userId}가 작성한 글을 조회한다.")
	public ResponseEntity<?> select(@PathVariable String userId){
		List<Board> list = bs.select(userId);
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Board>>(list,HttpStatus.OK);
		}
	}
	
	@GetMapping("/post/{id}")
	@ApiOperation(value = "게시글의 상세정보를 조회한다.")
	public ResponseEntity<Board> detail(@PathVariable int id){
		Board board = bs.detail(id);
		if (board == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Board>(board, HttpStatus.OK);
		}
	}
	
	
	
	
	
	
	
}
