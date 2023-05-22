package com.ssafy.model.dto.board;

public class BoardSearchCondition {
	private String key = "none";
	private String content;
	private boolean hasUserId = false;
	private String userId;
	private boolean hasBoardCategoryId = false;
	private int boardCategoryId;
	private String orderBy = "none";
	private String orderByDir;

	public BoardSearchCondition() {
		// TODO Auto-generated constructor stub
	}
	

	public BoardSearchCondition(String key, String content, boolean hasUserId, String userId,
			boolean hasBoardCategoryId, int boardCategoryId, String orderBy, String orderByDir) {
		super();
		this.key = key;
		this.content = content;
		this.hasUserId = hasUserId;
		this.userId = userId;
		this.hasBoardCategoryId = hasBoardCategoryId;
		this.boardCategoryId = boardCategoryId;
		this.orderBy = orderBy;
		this.orderByDir = orderByDir;
	}


	public boolean getHasUserId() {
		return hasUserId;
	}

	public void setHasUserId(boolean hasUserId) {
		this.hasUserId = hasUserId;
	}

	public boolean getHasBoardCategoryId() {
		return hasBoardCategoryId;
	}

	public void setHasBoardCategoryId(boolean hasBoardCategoryId) {
		this.hasBoardCategoryId = hasBoardCategoryId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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


	@Override
	public String toString() {
		return "BoardSearchCondition [key=" + key + ", content=" + content + ", hasUserId=" + hasUserId + ", userId="
				+ userId + ", hasBoardCategoryId=" + hasBoardCategoryId + ", boardCategoryId=" + boardCategoryId
				+ ", orderBy=" + orderBy + ", orderByDir=" + orderByDir + "]";
	}

}
