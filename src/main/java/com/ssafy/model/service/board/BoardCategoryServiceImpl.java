package com.ssafy.model.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.board.BoardCategoryDao;
import com.ssafy.model.dto.board.BoardCategory;

@Service
public class BoardCategoryServiceImpl implements BoardCategoryService{

	@Autowired
	private BoardCategoryDao bd;
	
	@Override
	public int insert(BoardCategory boardCategory) {
		return bd.insert(boardCategory);
	}

	@Override
	public int update(BoardCategory boardCategory) {
		return bd.update(boardCategory);
	}

	@Override
	public List<BoardCategory> selectAll() {
		return bd.selectAll();
	}

	@Override
	public BoardCategory selectById(int id) {
		return bd.selectById(id);
	}

}
