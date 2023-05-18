package com.ssafy.model.dao.challenge;

import java.util.List;

import com.ssafy.model.dto.challenge.ChallengeIng;

public interface ChallengeIngDao {
	int insert(ChallengeIng challengeIng);
	int update(ChallengeIng challengeIng);
	List<ChallengeIng> selectAll();
	int delete(int id);
	List<ChallengeIng> search(String userId);	
}	
