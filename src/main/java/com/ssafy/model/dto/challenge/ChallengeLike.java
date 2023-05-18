package com.ssafy.model.dto.challenge;

import java.sql.Date;

public class ChallengeLike extends Challenge{
	private String userId;
	private int challengeId;
	private Date createdAt;
	
	
	public ChallengeLike() {
	}


	public ChallengeLike(String userId, int challengeId, Date createdAt) {
		super();
		this.userId = userId;
		this.challengeId = challengeId;
		this.createdAt = createdAt;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getChallengeId() {
		return challengeId;
	}


	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "ChallengeLike [userId=" + userId + ", challengeId=" + challengeId + ", createdAt=" + createdAt + "]";
	}
	
}
