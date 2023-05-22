package com.ssafy.model.service.board;

import com.ssafy.model.dto.board.BoardLike;

public interface BoardLikeService  {
	int insert(BoardLike boardLike);
	
	int delete(BoardLike boardLike);
	
	boolean isLike(BoardLike boardLike);
}
