package com.ssafy.controller.board;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.board.Board;
import com.ssafy.model.dto.board.BoardLike;
import com.ssafy.model.service.board.BoardLikeService;
import com.ssafy.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/board/like")
public class BoardLikeController {

	private String FAIL = "FAIL";

	@Autowired
	private BoardLikeService bs;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("")
	@ApiOperation(value = "게시글에 좋아요를 누른다.")
	public ResponseEntity<?> insert(@RequestHeader("access-token") String token, @RequestBody BoardLike boardLike) {
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			boardLike.setUserId(userId);
			System.out.println(boardLike);
			bs.insert(boardLike);
			return new ResponseEntity<BoardLike>(boardLike, HttpStatus.CREATED);
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_GATEWAY);
		}

	}

	@DeleteMapping("/{boardId}")
	@ApiOperation(value = "게시글의 좋아요를 취소한다.")
	public ResponseEntity<?> delete(@RequestHeader("access-token") String token, @PathVariable int boardId) {
		try {
			String userId = (String) jwtUtil.parseToken(token).get("id");
			bs.delete(new BoardLike(userId, boardId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | UnsupportedEncodingException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_GATEWAY);
		}

	}

}
