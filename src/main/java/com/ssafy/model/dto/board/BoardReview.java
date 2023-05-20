package com.ssafy.model.dto.board;

import java.sql.Date;

public class BoardReview {
	private int id;
	private int boardId;
	private String userId;
	private String content;
	private Date createAt;
	
	public BoardReview() {
	}

	public BoardReview(int id, int boardId, String userId, String content, Date createAt) {
		super();
		this.id = id;
		this.boardId = boardId;
		this.userId = userId;
		this.content = content;
		this.createAt = createAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "BoardReview [id=" + id + ", boardId=" + boardId + ", userId=" + userId + ", content=" + content
				+ ", createAt=" + createAt + "]";
	}
	
}
