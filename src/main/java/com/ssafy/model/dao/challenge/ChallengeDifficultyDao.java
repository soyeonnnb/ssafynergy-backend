package com.ssafy.model.dao.challenge;

import com.ssafy.model.dto.challenge.ChallengeDifficulty;

public interface ChallengeDifficultyDao {
	int insert(ChallengeDifficulty challengeDifficulty);
	int update(ChallengeDifficulty challengeDiffuculty);
	int delete(int id);
}
