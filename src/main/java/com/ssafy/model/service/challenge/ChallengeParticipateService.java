package com.ssafy.model.service.challenge;

import java.util.List;

import com.ssafy.model.dto.challenge.Challenge;
import com.ssafy.model.dto.challenge.ChallengeParticipate;

public interface ChallengeParticipateService {
	int insert(ChallengeParticipate challengeParticipate);
	
	int delete(ChallengeParticipate challengeParticipate);
	
	int update(ChallengeParticipate challengeParticipate);
	
	List<Challenge> search(String userId);
	
	boolean isParticipate(ChallengeParticipate challengeParticipate);
	
	List<ChallengeParticipate> getParticipatedPersonNum(int challengeId);
}
