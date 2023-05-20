package com.ssafy.model.dao.board;

import java.util.List;

import com.ssafy.model.dto.board.Board;
import com.ssafy.model.dto.board.BoardSearchCondition;

public interface BoardDao {
	int insert(Board board);
	int update(Board board);
	int delete(int id);
	List<Board> search(BoardSearchCondition condition);
	List<Board> select(String userId); // 이거 세션에서 로그인 정보 가져와야할듯. 일단 userid줬음
	Board detail(int id);
}
