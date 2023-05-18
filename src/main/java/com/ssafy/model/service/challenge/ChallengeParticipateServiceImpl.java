package com.ssafy.model.service.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.challenge.ChallengeParticipateDao;
import com.ssafy.model.dto.challenge.ChallengeParticipate;

@Service
public class ChallengeParticipateServiceImpl implements ChallengeParticipateService{

	@Autowired
	private ChallengeParticipateDao cd;
	
	@Override
	public int insert(ChallengeParticipate challengeParticipate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ChallengeParticipate challengeParticipate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ChallengeParticipate> search(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
