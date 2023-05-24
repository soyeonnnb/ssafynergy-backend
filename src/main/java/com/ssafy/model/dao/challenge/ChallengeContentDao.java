package com.ssafy.model.dao.challenge;

import com.ssafy.model.dto.challenge.ChallengeContent;

public interface ChallengeContentDao {
	int insert(ChallengeContent challengeContent);
	int update(ChallengeContent challengeContent);
	int delete(int id);
}
