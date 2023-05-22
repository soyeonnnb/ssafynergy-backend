package com.ssafy.model.dao.board;

import java.util.List;

import com.ssafy.model.dto.board.BoardCategory;

public interface BoardCategoryDao {
	int insert(BoardCategory boardCategory);
	int update(BoardCategory boardCategory);
	List<BoardCategory> selectAll();
	BoardCategory selectById(int id);
}
