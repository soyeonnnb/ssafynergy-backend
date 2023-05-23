package com.ssafy.model.dto.challenge;

public class ChallengeLike{
	private String userId;
	private int challengeId;
	private String createdAt;
	
	
	public ChallengeLike() {
	}


	public ChallengeLike(String userId, int challengeId, String createdAt) {
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


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "ChallengeLike [userId=" + userId + ", challengeId=" + challengeId + ", createdAt=" + createdAt + "]";
	}
	
}
