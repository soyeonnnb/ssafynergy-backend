package com.ssafy.model.dao.board;

import java.util.List;

import com.ssafy.model.dto.board.BoardReview;

public interface BoardReviewDao {
	int insert(BoardReview boardreview);
	int update(BoardReview boardreview);
	int delete(int id);
	List<BoardReview> selectBoard(int boardId);
	List<BoardReview> selectUser(String userId);
}
