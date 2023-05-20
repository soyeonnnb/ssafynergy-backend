package com.ssafy.model.service.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.challenge.ChallengeDifficultyDao;
import com.ssafy.model.dto.challenge.ChallengeDifficulty;

@Service
public class ChallengeDifficultyServiceImpl implements ChallengeDifficultyService{

	@Autowired
	private ChallengeDifficultyDao cd;
	
	@Override
	public int insert(ChallengeDifficulty challengeDifficulty) {
		return cd.insert(challengeDifficulty);
	}

	@Override
	public int update(ChallengeDifficulty challengeDiffuculty) {
		return cd.update(challengeDiffuculty);
	}

	@Override
	public int delete(int id) {
		return cd.delete(id);
	}

}
