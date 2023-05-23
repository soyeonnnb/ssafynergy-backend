package com.ssafy.model.service.challenge;

import java.util.List;

import com.ssafy.model.dto.challenge.ChallengeIng;
import com.ssafy.model.dto.challenge.ChallengeParticipate;

public interface ChallengeIngService {
	int insert(ChallengeIng challengeIng);

	int update(ChallengeIng challengeIng);
	
	int selectByChallengeIdAndUserId(ChallengeParticipate cp);

	List<ChallengeIng> selectAll();

	List<ChallengeIng> selectByChallengeParticipateId(int id);

	int delete(int id);

	List<ChallengeIng> search(String userId);
}
