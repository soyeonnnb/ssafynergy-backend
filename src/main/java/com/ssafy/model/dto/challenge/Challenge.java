package com.ssafy.model.dto.challenge;

public class Challenge {
	private int id;
	private String name;
	private String createdAt;
	private String startAt;
	private String finishAt;
	private String description;
	private int limitPersonNum;
	private boolean publicType;         // 공개여부
	private int challengeDifficultyId;  // 인트로 줬네.... 일단 쉬움1 보통2 어려움3 
	private int opportunity;
	private int participateCnt;
	private int likeCnt;
	private String img;
	private int reviewCnt;
	private int totalDay;
	private int challengeParticipateId;

	public Challenge() {
	}

	public boolean isPublicType() {
		return publicType;
	}

	public void setPublicType(boolean publicType) {
		this.publicType = publicType;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Challenge(int id, String name, String createdAt, String startAt, String finishAt, String description,
			int limitPersonNum, boolean publicType, int challengeDifficultyId, int opportunity, boolean isGiveup,
			int participateCnt, int likeCnt, int reviewCnt, int totalDay) {
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
		this.participateCnt = participateCnt;
		this.likeCnt = likeCnt;
		this.reviewCnt = reviewCnt;
		this.totalDay = totalDay;
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getStartAt() {
		return startAt;
	}

	public void setStartAt(String startAt) {
		this.startAt = startAt;
	}

	public String getFinishAt() {
		return finishAt;
	}

	public void setFinishAt(String finishAt) {
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

	public boolean getIsPublicType() {
		return publicType;
	}

	public void setIsPublicType(boolean publicType) {
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

	public int getTotalDay() {
		return totalDay;
	}

	public void setTotalDay(int totalDay) {
		this.totalDay = totalDay;
	}

	
	public int getChallengeParticipateId() {
		return challengeParticipateId;
	}

	public void setChallengeParticipateId(int challengeParticipateId) {
		this.challengeParticipateId = challengeParticipateId;
	}

	@Override
	public String toString() {
		return "Challenge [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", startAt=" + startAt
				+ ", finishAt=" + finishAt + ", description=" + description + ", limitPersonNum=" + limitPersonNum
				+ ", publicType=" + publicType + ", challengeDifficultyId=" + challengeDifficultyId + ", opportunity="
				+ opportunity + ", participateCnt=" + participateCnt + ", likeCnt=" + likeCnt + ", reviewCnt="
				+ reviewCnt + ", totalDay=" + totalDay + ", challengeParticipateId=" + challengeParticipateId + "]";
	}


}
