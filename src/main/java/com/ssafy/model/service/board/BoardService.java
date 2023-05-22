package com.ssafy.model.service.board;

import java.util.List;

import com.ssafy.model.dto.board.Board;
import com.ssafy.model.dto.board.BoardSearchCondition;

public interface BoardService {
	int insert(Board board);
	
	int update(Board board);
	
	int viewCntUp(int id);
	
	int delete(int id);
	
	List<Board> search(BoardSearchCondition condition);
	
	List<Board> select(String userId);
	
	Board detail(int id);
}
