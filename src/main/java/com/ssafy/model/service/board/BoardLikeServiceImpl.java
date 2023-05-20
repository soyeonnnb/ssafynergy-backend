package com.ssafy.model.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.board.BoardLikeDao;
import com.ssafy.model.dto.board.BoardLike;

@Service
public class BoardLikeServiceImpl implements BoardLikeService{

	@Autowired
	private BoardLikeDao bd;
	
	@Override
	public int insert(BoardLike boardLike) {
		return bd.insert(boardLike);
	}

	@Override
	public int delete(BoardLike boardLike) {
		return bd.delete(boardLike);
	}

}
