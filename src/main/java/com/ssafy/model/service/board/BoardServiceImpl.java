package com.ssafy.model.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.board.BoardDao;
import com.ssafy.model.dto.board.Board;
import com.ssafy.model.dto.board.BoardSearchCondition;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao bd;

	@Override
	public int insert(Board board) {
		return bd.insert(board);
	}

	@Override
	public int update(Board board) {
		return bd.update(board);
	}

	@Override
	public int delete(int id) {
		return bd.delete(id);
	}

	@Override
	public List<Board> search(BoardSearchCondition condition) {
		return bd.search(condition);
	}

	@Override
	public List<Board> select(String userId) {
		return bd.select(userId);
	}

	@Override
	public Board detail(int id) {
		return bd.detail(id);
	}

}
