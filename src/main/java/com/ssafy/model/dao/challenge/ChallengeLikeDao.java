package com.ssafy.model.dao.challenge;

import java.util.List;

import com.ssafy.model.dto.challenge.Challenge;
import com.ssafy.model.dto.challenge.ChallengeLike;

public interface ChallengeLikeDao {
	int insert(ChallengeLike challengeLike);
	int delete(ChallengeLike challengeLike);
	int selectOne(ChallengeLike challengeLike);
	List<Challenge> selectByUserId(String userId);
	List<ChallengeLike> getLikePersonNum(int challengeId);
}	
