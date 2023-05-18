package com.ssafy.model.dto.challenge;

import java.sql.Date;

public class ChallengeParticipate extends Challenge {
	private int id;
	private String userId;
	private int challengeId;
	private Date participatedDate;
	
	public ChallengeParticipate() {
	}

	public ChallengeParticipate(int id, String userId, int challengeId, Date participatedDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.challengeId = challengeId;
		this.participatedDate = participatedDate;
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

	public Date getParticipatedDate() {
		return participatedDate;
	}

	public void setParticipatedDate(Date participatedDate) {
		this.participatedDate = participatedDate;
	}

	@Override
	public String toString() {
		return "ChallengeParticipate [id=" + id + ", userId=" + userId + ", challengeId=" + challengeId
				+ ", participatedDate=" + participatedDate + "]";
	}
	
}
