package com.ssafy.model.dao.board;

import com.ssafy.model.dto.board.BoardLike;

public interface BoardLikeDao {
	int insert(BoardLike boardLike);
	int delete(BoardLike boardLike);
}
