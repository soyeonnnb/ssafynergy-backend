package com.ssafy.model.dto.board;

public class BoardCategory {
	private int id;
	private String name;
	private boolean isAuthorized;
	private boolean writerType;
	private boolean reviewerType;
	private boolean likeType;
	private boolean isChallenge;
	private int challengeId;
	private int postNum;
	public BoardCategory() {
	}

	public BoardCategory(int id, String name, boolean isAuthorized, boolean writerType, boolean reviewerType,
			boolean likeType, boolean isChallenge, int challengeId) {
		super();
		this.id = id;
		this.name = name;
		this.isAuthorized = isAuthorized;
		this.writerType = writerType;
		this.reviewerType = reviewerType;
		this.likeType = likeType;
		this.isChallenge = isChallenge;
		this.challengeId = challengeId;
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

	public boolean getIsAuthorized() {
		return isAuthorized;
	}

	public void setIsAuthorized(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	public boolean getWriterType() {
		return writerType;
	}

	public void setWriterType(boolean writerType) {
		this.writerType = writerType;
	}

	public boolean getReviewerType() {
		return reviewerType;
	}

	public void setReviewerType(boolean reviewerType) {
		this.reviewerType = reviewerType;
	}

	public boolean getLikeType() {
		return likeType;
	}

	public void setLikeType(boolean likeType) {
		this.likeType = likeType;
	}

	public boolean getIsChallenge() {
		return isChallenge;
	}

	public void setIsChallenge(boolean isChallenge) {
		this.isChallenge = isChallenge;
	}

	public int getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	@Override
	public String toString() {
		return "BoardCategory [id=" + id + ", name=" + name + ", isAuthorized=" + isAuthorized + ", writerType="
				+ writerType + ", reviewerType=" + reviewerType + ", likeType=" + likeType + ", isChallenge="
				+ isChallenge + ", challengeId=" + challengeId + "]";
	}
	
}
