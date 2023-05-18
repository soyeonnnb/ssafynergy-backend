package com.ssafy.model.dto.challenge;

import java.sql.Date;

public class ChallengeContent {
	private int id;
	private int challengeId;
	private Date createdAt;
	private int index;
	private String content;
	
	public ChallengeContent() {
	}

	public ChallengeContent(int id, int challengeId, Date createdAt, int index, String content) {
		super();
		this.id = id;
		this.challengeId = challengeId;
		this.createdAt = createdAt;
		this.index = index;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ChallengeContent [id=" + id + ", challengeId=" + challengeId + ", createdAt=" + createdAt + ", index="
				+ index + ", content=" + content + "]";
	}

}
