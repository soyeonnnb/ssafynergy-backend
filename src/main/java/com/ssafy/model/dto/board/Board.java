package com.ssafy.model.dto.board;

import java.sql.Date;

public class Board {
	private int id;
	private String title;
	private String content;
	private String createdAt;
	private String userId;
	private int boardCategoryId;
	private String boardCategoryName;
	private int viewCnt;
	private int likeCnt;
	private int reviewCnt;
	private String userNickname;
	private boolean isLike;

	public boolean getIsLike() {
		return isLike;
	}

	public void setIsLike(boolean isLike) {
		this.isLike = isLike;
	}

	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int id, String title, String content, String createdAt, String userId, int boardCategoryId,
			int viewCnt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.userId = userId;
		this.boardCategoryId = boardCategoryId;
		this.viewCnt = viewCnt;
	}

	public String getBoardCategoryName() {
		return boardCategoryName;
	}

	public void setBoardCategoryName(String boardCategoryName) {
		this.boardCategoryName = boardCategoryName;
	}

	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
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

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt
				+ ", userId=" + userId + ", boardCategoryId=" + boardCategoryId + ", boardCategoryName="
				+ boardCategoryName + ", viewCnt=" + viewCnt + ", likeCnt=" + likeCnt + ", reviewCnt=" + reviewCnt
				+ ", userNickname=" + userNickname + "]";
	}

}
