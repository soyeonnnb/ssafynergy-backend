package com.ssafy.model.dao.challenge;

import java.util.List;

import com.ssafy.model.dto.challenge.Challenge;
import com.ssafy.model.dto.challenge.SearchCondition;

public interface ChallengeDao {
	int insert(Challenge challenge);
	int update(Challenge challenge);
	List<Challenge> search(SearchCondition condition);
	Challenge select(int id);
	int getParticipatedCnt(int id);
	int getLikeCnt(int id);
}
