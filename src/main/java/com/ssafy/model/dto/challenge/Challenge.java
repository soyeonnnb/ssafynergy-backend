package com.ssafy.model.dto.challenge;

import java.sql.Date;

public class Challenge {
	private int id;
	private String name;
	private Date createdAt;
	private Date startAt;
	private Date finishAt;
	private String description;
	private int limitPersonNum;
	private boolean publicType;
	private int challengeDifficultyId;
	private int opportunity;
	private boolean isGiveup;
	private int participateCnt;
	private int likeCnt;
	private int reviewCnt;
	
	public Challenge() {
	}

	public Challenge(int id, String name, Date createdAt, Date startAt, Date finishAt, String description,
			int limitPersonNum, boolean publicType, int challengeDifficultyId, int opportunity, boolean isGiveup,
			int participateCnt, int likeCnt, int reviewCnt) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.startAt = startAt;
		this.finishAt = finishAt;
		this.description = description;
		this.limitPersonNum = limitPersonNum;
		this.publicType = publicType;
		this.challengeDifficultyId = challengeDifficultyId;
		this.opportunity = opportunity;
		this.isGiveup = isGiveup;
		this.participateCnt = participateCnt;
		this.likeCnt = likeCnt;
		this.reviewCnt = reviewCnt;
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

	public Date getStartAt() {
		return startAt;
	}

	public void setStartAt(Date startAt) {
		this.startAt = startAt;
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

	
	
	public int getParticipateCnt() {
		return participateCnt;
	}

	public void setParticipateCnt(int participateCnt) {
		this.participateCnt = participateCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	@Override
	public String toString() {
		return "Challenge [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", startAt=" + startAt
				+ ", finishAt=" + finishAt + ", description=" + description + ", limitPersonNum=" + limitPersonNum
				+ ", publicType=" + publicType + ", challengeDifficultyId=" + challengeDifficultyId + ", opportunity="
				+ opportunity + ", isGiveup=" + isGiveup + ", participateCnt=" + participateCnt + ", likeCnt=" + likeCnt
				+ ", reviewCnt=" + reviewCnt + ", getId()=" + getId() + ", getName()=" + getName() + ", getCreatedAt()="
				+ getCreatedAt() + ", getStartAt()=" + getStartAt() + ", getFinishAt()=" + getFinishAt()
				+ ", getDescription()=" + getDescription() + ", getLimitPersonNum()=" + getLimitPersonNum()
				+ ", isPublicType()=" + isPublicType() + ", getChallengeDifficultyId()=" + getChallengeDifficultyId()
				+ ", getOpportunity()=" + getOpportunity() + ", isGiveup()=" + isGiveup() + ", getParticipateCnt()="
				+ getParticipateCnt() + ", getLikeCnt()=" + getLikeCnt() + ", getReviewCnt()=" + getReviewCnt()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
}
