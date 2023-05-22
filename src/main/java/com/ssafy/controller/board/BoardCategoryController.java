package com.ssafy.controller.board;

import java.util.List;

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

import com.ssafy.model.dto.board.BoardCategory;
import com.ssafy.model.service.board.BoardCategoryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/board/category")
public class BoardCategoryController {

	@Autowired
	private BoardCategoryService bs;

	@GetMapping("/{id}")
	public ResponseEntity<?> getBoardCategory(@PathVariable int id) {
		BoardCategory boardCategory = bs.selectById(id);
		if (boardCategory == null) {
			return new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<BoardCategory>(boardCategory, HttpStatus.OK);
		}
	}

	@PostMapping("")
	@ApiOperation(value = "카테고리를 생성한다.")
	public ResponseEntity<?> insert(@RequestBody BoardCategory boardCategory) {
		System.out.println(boardCategory);
		bs.insert(boardCategory);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
	}

	@PutMapping("")
	@ApiOperation(value = "카테고리를 수정한다.")
	public ResponseEntity<String> update(@RequestBody BoardCategory boardCategory) {
		bs.update(boardCategory);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("")
	@ApiOperation(value = "전체 카테고리 목록을 조회한다.")
	public ResponseEntity<?> selectAll() {
		List<BoardCategory> list = bs.selectAll();
		return new ResponseEntity<List<BoardCategory>>(list, HttpStatus.OK);
	}

	@GetMapping("/foruser")
	@ApiOperation(value = "일반 유저가 작성 가능한 카테고리 목록을 조회한다.")
	public ResponseEntity<?> selectForUser() {
		List<BoardCategory> list = bs.selectForUser();
		return new ResponseEntity<List<BoardCategory>>(list, HttpStatus.OK);
	}

}
