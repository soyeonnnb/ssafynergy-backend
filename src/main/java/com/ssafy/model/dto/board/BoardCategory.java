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
	public BoardCategory() {
		// TODO Auto-generated constructor stub
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
	public boolean isAuthorized() {
		return isAuthorized;
	}
	public void setAuthorized(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	public boolean isWriterType() {
		return writerType;
	}
	public void setWriterType(boolean writerType) {
		this.writerType = writerType;
	}
	public boolean isReviewerType() {
		return reviewerType;
	}
	public void setReviewerType(boolean reviewerType) {
		this.reviewerType = reviewerType;
	}
	public boolean isLikeType() {
		return likeType;
	}
	public void setLikeType(boolean likeType) {
		this.likeType = likeType;
	}
	public boolean isChallenge() {
		return isChallenge;
	}
	public void setChallenge(boolean isChallenge) {
		this.isChallenge = isChallenge;
	}
	public int getChallengeId() {
		return challengeId;
	}
	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}
	@Override
	public String toString() {
		return "BoardCategory [id=" + id + ", name=" + name + ", isAuthorized=" + isAuthorized + ", writerType="
				+ writerType + ", reviewerType=" + reviewerType + ", likeType=" + likeType + ", isChallenge="
				+ isChallenge + ", challengeId=" + challengeId + "]";
	}
	
}
