package com.ssafy.model.dto.board;

import java.sql.Date;

public class BoardLike {
	private String userId;
	private int boardId;
	private String createdAt;
	
	public BoardLike() {
	}

	public BoardLike(String userId, int boardId, String createdAt) {
		super();
		this.userId = userId;
		this.boardId = boardId;
		this.createdAt = createdAt;
	}

	public BoardLike(String userId, int boardId) {
		super();
		this.userId = userId;
		this.boardId = boardId;
	} 
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "BoardLike [userId=" + userId + ", boardId=" + boardId + ", createdAt=" + createdAt + "]";
	}
	
}
