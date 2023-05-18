package com.ssafy.model.dao.challenge;

import java.util.List;

import com.ssafy.model.dto.challenge.ChallengeLike;

public interface ChallengeLikeDao {
	int insert(ChallengeLike challengeLike);
	int delete(int challengeId);
	List<ChallengeLike> search(String userId);
}
