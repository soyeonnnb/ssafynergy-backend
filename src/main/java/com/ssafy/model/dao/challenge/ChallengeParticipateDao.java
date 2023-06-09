package com.ssafy.model.dao.challenge;

import java.util.List;

import com.ssafy.model.dto.challenge.Challenge;
import com.ssafy.model.dto.challenge.ChallengeParticipate;

public interface ChallengeParticipateDao {
	int insert(ChallengeParticipate challengeParticipate);
	int delete(ChallengeParticipate challengeParticipate);
	int update(ChallengeParticipate challengeParticipate);
	List<Challenge> search(String userId);
	List<ChallengeParticipate> getParticipatedPersonNum(int challengeId);
	ChallengeParticipate isParticipated(ChallengeParticipate challengeParticipate);
}
