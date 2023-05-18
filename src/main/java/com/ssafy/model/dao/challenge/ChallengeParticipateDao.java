package com.ssafy.model.dao.challenge;

import java.util.List;

import com.ssafy.model.dto.challenge.ChallengeParticipate;

public interface ChallengeParticipateDao {
	int insert(ChallengeParticipate challengeParticipate);
	int delete(int id);
	int update(ChallengeParticipate challengeParticipate);
	List<ChallengeParticipate> search(String userId);
}
