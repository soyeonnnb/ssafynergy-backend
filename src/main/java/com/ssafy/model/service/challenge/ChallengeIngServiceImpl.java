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
		return cd.insert(challengeIng);
	}

	@Override
	public int update(ChallengeIng challengeIng) {
		return cd.update(challengeIng);
	}

	@Override
	public List<ChallengeIng> selectAll() {
		return cd.selectAll();
	}

	@Override
	public int delete(int id) {
		return cd.delete(id);
	}

	@Override
	public List<ChallengeIng> search(String userId) {
		return cd.search(userId);
	}

	@Override
	public List<ChallengeIng> selectByChallengeParticipateId(int id) {
		return cd.selectByChallengeParticipateId(id);
	}

}
