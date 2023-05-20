package com.ssafy.model.dto.board;

import java.sql.Date;

public class BoardLike {
	private String userId;
	private int boardId;
	private Date createdAt;
	
	public BoardLike() {
	}

	public BoardLike(String userId, int boardId, Date createdAt) {
		super();
		this.userId = userId;
		this.boardId = boardId;
		this.createdAt = createdAt;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "BoardLike [userId=" + userId + ", boardId=" + boardId + ", createdAt=" + createdAt + "]";
	}
	
}
