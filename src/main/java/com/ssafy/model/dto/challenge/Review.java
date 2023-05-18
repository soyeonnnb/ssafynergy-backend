package com.ssafy.model.dto.challenge;

import java.sql.Date;

public class Review {
	private int id;
	private String title;
	private String content;
	private Date createdAt;
	private int challengeId;
	private String userId;
	private int rating;
	
	public Review() {
	}

	public Review(int id, String title, String content, Date createdAt, int challengeId, String userId, int rating) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.challengeId = challengeId;
		this.userId = userId;
		this.rating = rating;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt
				+ ", challengeId=" + challengeId + ", userId=" + userId + ", rating=" + rating + "]";
	}
	
}
