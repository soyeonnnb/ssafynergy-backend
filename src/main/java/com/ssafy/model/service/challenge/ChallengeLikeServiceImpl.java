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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int challengeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ChallengeLike> search(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
