package com.ssafy.model.service.board;

import java.util.List;

import com.ssafy.model.dto.board.BoardCategory;

public interface BoardCategoryService  {
	int insert(BoardCategory boardCategory);
	
	int update(BoardCategory boardCategory);
	
	List<BoardCategory> selectAll();
}
