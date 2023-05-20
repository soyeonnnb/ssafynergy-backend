package com.ssafy.model.dto.challenge;

import java.sql.Date;

public class Challenge {
	private int id;
	private String name;
	private Date createdAt;
	private Date startedAt;
	private Date finishAt;
	private String description;
	private int limitPersonNum;
	private boolean publicType;
	private int challengeDifficultyId;
	private int opportunity;
	private boolean isGiveup;
	
	public Challenge() {
	}

	public Challenge(int id, String name, Date createdAt, Date startedAt, Date finishAt, String description,
			int limitPersonNum, boolean publicType, int challengeDifficultyId, int opportunity, boolean isGiveup) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.startedAt = startedAt;
		this.finishAt = finishAt;
		this.description = description;
		this.limitPersonNum = limitPersonNum;
		this.publicType = publicType;
		this.challengeDifficultyId = challengeDifficultyId;
		this.opportunity = opportunity;
		this.isGiveup = isGiveup;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public Date getFinishAt() {
		return finishAt;
	}

	public void setFinishAt(Date finishAt) {
		this.finishAt = finishAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLimitPersonNum() {
		return limitPersonNum;
	}

	public void setLimitPersonNum(int limitPersonNum) {
		this.limitPersonNum = limitPersonNum;
	}

	public boolean isPublicType() {
		return publicType;
	}

	public void setPublicType(boolean publicType) {
		this.publicType = publicType;
	}

	public int getChallengeDifficultyId() {
		return challengeDifficultyId;
	}

	public void setChallengeDifficultyId(int challengeDifficultyId) {
		this.challengeDifficultyId = challengeDifficultyId;
	}

	public int getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(int opportunity) {
		this.opportunity = opportunity;
	}

	public boolean isGiveup() {
		return isGiveup;
	}

	public void setGiveup(boolean isGiveup) {
		this.isGiveup = isGiveup;
	}

	@Override
	public String toString() {
		return "Challenge [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", startedAt=" + startedAt
				+ ", finishAt=" + finishAt + ", description=" + description + ", limitPersonNum=" + limitPersonNum
				+ ", publicType=" + publicType + ", challengeDifficultyId=" + challengeDifficultyId + ", opportunity="
				+ opportunity + ", isGiveup=" + isGiveup + "]";
	}

	
	
}
