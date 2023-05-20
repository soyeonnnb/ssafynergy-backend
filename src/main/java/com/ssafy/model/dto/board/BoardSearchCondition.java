package com.ssafy.model.dto.board;

public class BoardSearchCondition {
	private String title;
	private String userId;
	private int boardCategoryId;
	private String orderBy;
	private String orderByDir;
	public BoardSearchCondition() {
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBoardCategoryId() {
		return boardCategoryId;
	}
	public void setBoardCategoryId(int boardCategoryId) {
		this.boardCategoryId = boardCategoryId;
	}

	
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getOrderByDir() {
		return orderByDir;
	}
	public void setOrderByDir(String orderByDir) {
		this.orderByDir = orderByDir;
	}

}
