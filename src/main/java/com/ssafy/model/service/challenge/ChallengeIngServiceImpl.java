package com.ssafy.model.service.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.challenge.ChallengeIngDao;
import com.ssafy.model.dto.challenge.ChallengeIng;

@Service
public class ChallengeIngServiceImpl implements ChallengeIngService{

	@Autowired
	private ChallengeIngDao cd;
	
	@Override
	public int insert(ChallengeIng challengeIng) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ChallengeIng challengeIng) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ChallengeIng> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ChallengeIng> search(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
