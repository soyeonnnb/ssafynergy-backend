package com.ssafy.model.dto.challenge;

import java.sql.Date;

public class ChallengeIng extends ChallengeParticipate {
	private int id;
	private int challengeParticipateId;
	private int index;
	private String content;
	private boolean check;
	private Date createdAt;
	private String img;
	
	public ChallengeIng() {
	}

	public ChallengeIng(int id, int challengeParticipateId, int index, String content, boolean check, Date createdAt,
			String img) {
		super();
		this.id = id;
		this.challengeParticipateId = challengeParticipateId;
		this.index = index;
		this.content = content;
		this.check = check;
		this.createdAt = createdAt;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChallengeParticipateId() {
		return challengeParticipateId;
	}

	public void setChallengeParticipateId(int challengeParticipateId) {
		this.challengeParticipateId = challengeParticipateId;
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

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "ChallengeIng [id=" + id + ", challengeParticipateId=" + challengeParticipateId + ", index=" + index
				+ ", content=" + content + ", check=" + check + ", createdAt=" + createdAt + ", img=" + img + "]";
	}

}
