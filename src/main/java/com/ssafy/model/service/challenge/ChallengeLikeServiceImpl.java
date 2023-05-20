package com.ssafy.model.service.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.challenge.ChallengeLikeDao;
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
	public int delete(int challengeId) {
		return cd.delete(challengeId);
	}

	@Override
	public List<ChallengeLike> search(String userId) {
		return cd.search(userId);
	}

	@Override
	public List<ChallengeLike> getLikePersonNum(int challengeId) {
		return cd.getLikePersonNum(challengeId);
	}

}
