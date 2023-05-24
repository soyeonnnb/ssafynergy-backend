package com.ssafy.model.service.challenge;

import com.ssafy.model.dto.challenge.ChallengeContent;

public interface ChallengeContentService {
	int insert(ChallengeContent challengeContent);
	
	int update(ChallengeContent challengeContent);
	
	int delete(int id);
}
