package com.ssafy.model.service.challenge;

import java.util.List;

import com.ssafy.model.dto.challenge.ChallengeLike;

public interface ChallengeLikeService {
	int insert(ChallengeLike challengeLike);
	
	int delete(int challengeId);
	
	List<ChallengeLike> search(String userId);

}
