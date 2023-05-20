package com.ssafy.model.service.challenge;

import com.ssafy.model.dto.challenge.ChallengeDifficulty;

public interface ChallengeDifficultyService {
	int insert(ChallengeDifficulty challengeDifficulty);
	
	int update(ChallengeDifficulty challengeDiffuculty);
	
	int delete(int id);
}
