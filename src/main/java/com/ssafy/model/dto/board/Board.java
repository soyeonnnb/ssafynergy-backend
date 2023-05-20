package com.ssafy.model.dto.board;

import java.sql.Date;

public class Board {
	private int id;
	private String title;
	private String content;
	private Date created_at;
	private String userId;
	private int boardCategoryId;
	private int viewCnt;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int id, String title, String content, Date created_at, String userId, int boardCategoryId,
			int viewCnt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.created_at = created_at;
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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
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
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", created_at=" + created_at
				+ ", userId=" + userId + ", boardCategoryId=" + boardCategoryId + ", viewCnt=" + viewCnt + "]";

	}
	
}
