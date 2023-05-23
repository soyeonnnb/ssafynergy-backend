package com.ssafy.model.service.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.challenge.ChallengeLikeDao;
import com.ssafy.model.dto.challenge.Challenge;
import com.ssafy.model.dto.challenge.ChallengeLike;

@Service
public class ChallengeLikeServiceImpl implements ChallengeLikeService{

	@Autowired
	private ChallengeLikeDao cd;

	@Override
	public int insert(ChallengeLike challengeLike) {
		return cd.insert(challengeLike);
	}

	@Override
	public boolean isAlreadyLike(ChallengeLike challengeLike) {
		return cd.selectOne(challengeLike) == 1;
	}

	@Override
	public int delete(ChallengeLike challengeLike) {
		return cd.delete(challengeLike);
	}

	@Override
	public List<Challenge> search(String userId) {
		return cd.selectByUserId(userId);
	}

	@Override
	public List<ChallengeLike> getLikePersonNum(int challengeId) {
		return cd.getLikePersonNum(challengeId);
	}
	

}
