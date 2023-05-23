package com.ssafy.model.dao.challenge;

import java.util.List;

import com.ssafy.model.dto.challenge.ChallengeIng;
import com.ssafy.model.dto.challenge.ChallengeParticipate;

public interface ChallengeIngDao {
	int insert(ChallengeIng challengeIng);
	int update(ChallengeIng challengeIng);
	List<ChallengeIng> selectAll();
	List<ChallengeIng> selectByChallengeParticipateId(int id);
	int delete(int id);
	List<ChallengeIng> search(String userId);	
	int selectByChallengeIdAndUserId(ChallengeParticipate cp);
}	
