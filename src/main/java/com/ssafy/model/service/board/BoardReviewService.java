package com.ssafy.model.service.board;

import java.util.List;

import com.ssafy.model.dto.board.BoardReview;

public interface BoardReviewService {
	int insert(BoardReview boardReview);
	
	int update(BoardReview boardReview);
	
	int delete(int id);
	
	List<BoardReview> selectBoard(int boardId);
	
	List<BoardReview> selectUser(String userId);
}
