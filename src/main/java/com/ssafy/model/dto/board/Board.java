package com.ssafy.model.dto.board;

public class Board {
	private int id;
	private String title;
	private String content;
	private String userId;
	private String boardCategoryId;
	private int viewCnt;
	
	public Board() {
	}

	public Board(int id, String title, String content, String userId, String boardCategoryId, int viewCnt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.boardCategoryId = boardCategoryId;
		this.viewCnt = viewCnt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBoardCategoryId() {
		return boardCategoryId;
	}

	public void setBoardCategoryId(String boardCategoryId) {
		this.boardCategoryId = boardCategoryId;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", userId=" + userId
				+ ", boardCategoryId=" + boardCategoryId + ", viewCnt=" + viewCnt + "]";
	}
	
}
