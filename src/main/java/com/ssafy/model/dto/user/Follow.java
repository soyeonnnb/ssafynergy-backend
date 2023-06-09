package com.ssafy.model.dto.user;

public class Follow {
	private String userId;
	private String followUserId;
	private String createdAt;
	public Follow() {
		// TODO Auto-generated constructor stub
	}
	public Follow(String userId, String followUserId, String createdAt) {
		super();
		this.userId = userId;
		this.followUserId = followUserId;
		this.createdAt = createdAt;
	}
	public Follow(String userId, String followUserId) {
		super();
		this.userId = userId;
		this.followUserId = followUserId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFollowUserId() {
		return followUserId;
	}
	public void setFollowUserId(String followUserId) {
		this.followUserId = followUserId;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Follow [userId=" + userId + ", followUserId=" + followUserId + ", createdAt=" + createdAt + "]";
	}
	
}
