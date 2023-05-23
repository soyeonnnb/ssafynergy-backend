package com.ssafy.model.service.challenge;

import java.util.List;

import com.ssafy.model.dto.challenge.Challenge;
import com.ssafy.model.dto.challenge.ChallengeLike;

public interface ChallengeLikeService {
	int insert(ChallengeLike challengeLike);
	
	boolean isAlreadyLike(ChallengeLike challengeLike);
	
	int delete(ChallengeLike challengeLike);
	
	List<Challenge> search(String userId);

	List<ChallengeLike> getLikePersonNum(int challengeId);
}
