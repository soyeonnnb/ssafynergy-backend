package com.ssafy.model.dto.challenge;

public class ChallengeParticipate {
	private int id;
	private String userId;
	private int challengeId;
	private String participatedDate;
	
	public ChallengeParticipate() {
	}

	public ChallengeParticipate(int id, String userId, int challengeId, String participatedDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.challengeId = challengeId;
		this.participatedDate = participatedDate;
	}

	public ChallengeParticipate(String userId, int challengeId) {
		this.userId = userId;
		this.challengeId = challengeId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getParticipatedDate() {
		return participatedDate;
	}

	public void setParticipatedDate(String participatedDate) {
		this.participatedDate = participatedDate;
	}

	@Override
	public String toString() {
		return "ChallengeParticipate [id=" + id + ", userId=" + userId + ", challengeId=" + challengeId
				+ ", participatedDate=" + participatedDate + "]";
	}
	
}
