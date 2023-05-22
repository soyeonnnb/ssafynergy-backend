package com.ssafy.controller.board;

import java.io.UnsupportedEncodingException;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.board.Board;
import com.ssafy.model.dto.board.BoardLike;
import com.ssafy.model.dto.board.BoardSearchCondition;
import com.ssafy.model.service.board.BoardLikeService;
import com.ssafy.model.service.board.BoardService;
import com.ssafy.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/board")
public class BoardController {
	@Autowired
	private BoardService bs;

	private String FAIL = "FAIL";

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private BoardLikeService boardLikeService;

	@PostMapping("/post") // 여기서 post는 http methods의 post가 아니라 게시글의 post이다
	@ApiOperation(value = "게시글을 등록한다.")
	public ResponseEntity<?> insert(@RequestHeader("access-token") String token, @RequestBody Board board) {
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			board.setUserId(userId);
			bs.insert(board);
			return new ResponseEntity<Board>(board, HttpStatus.OK);
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_GATEWAY);
		}
	}

	@PutMapping("/post")
	@ApiOperation(value = "게시글을 수정한다.")
	public ResponseEntity<String> update(@RequestHeader("access-token") String token, @RequestBody Board board) {

		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			Board b = bs.detail(board.getId());
			if (!userId.equals(b.getUserId())) {
				return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
			}
			bs.update(board);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_GATEWAY);
		}
	}

	@DeleteMapping("/post/{id}")
	@ApiOperation(value = "게시글을 삭제한다.")
	public ResponseEntity<String> delete(@RequestHeader("access-token") String token, @PathVariable int id) {
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			Board b = bs.detail(id);
			if (!userId.equals(b.getUserId())) {
				return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
			}
			bs.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_GATEWAY);
		}

	}

	@PutMapping("/post/{id}")
	@ApiOperation(value = "게시글의 조회수를 증가시킨다.")
	public ResponseEntity<Void> viewCntUp(@PathVariable int id) {
		bs.viewCntUp(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/search")
	@ApiOperation(value = "게시글에서 옵션을 선택하여 검색한다.")
	public ResponseEntity<?> search(BoardSearchCondition searchCondition) {
		System.out.println(searchCondition);
		List<Board> list = bs.search(searchCondition);
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/post/user/{userId}")
	@ApiOperation(value = "유저{userId}가 작성한 글을 조회한다.")
	public ResponseEntity<?> select(@PathVariable String userId) {
		List<Board> list = bs.select(userId);
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/post/{id}")
	@ApiOperation(value = "게시글의 상세정보를 조회한다.")
	public ResponseEntity<Board> detail(HttpSession session, @PathVariable int id) {
		Board board = bs.detail(id);
		if (board == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			if (boardLikeService.isLike(new BoardLike("admin", id))) {
				board.setIsLike(true);
			} else {
				board.setIsLike(false);
			}
			return new ResponseEntity<Board>(board, HttpStatus.OK);
		}
	}

}
