package com.ssafy.model.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.board.BoardReviewDao;
import com.ssafy.model.dto.board.BoardReview;

@Service
public class BoardReviewServiceImpl implements BoardReviewService{

	@Autowired
	private BoardReviewDao bd;
	
	@Override
	public int insert(BoardReview boardreview) {
		return bd.insert(boardreview);
	}

	@Override
	public int update(BoardReview boardreview) {
		return bd.update(boardreview);
	}

	@Override
	public int delete(int id) {
		return bd.delete(id);
	}

	@Override
	public List<BoardReview> selectBoard(int boardId) {
		return bd.selectBoard(boardId);
	}

	@Override
	public List<BoardReview> selectUser(String userId) {
		return bd.selectUser(userId);
	}

}
