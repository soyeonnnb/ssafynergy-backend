package com.ssafy.model.service.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.challenge.ChallengeParticipateDao;
import com.ssafy.model.dto.challenge.Challenge;
import com.ssafy.model.dto.challenge.ChallengeParticipate;

@Service
public class ChallengeParticipateServiceImpl implements ChallengeParticipateService{

	@Autowired
	private ChallengeParticipateDao cd;
	
	@Override
	public int insert(ChallengeParticipate challengeParticipate) {
		return cd.insert(challengeParticipate);
	}

	@Override
	public int delete(ChallengeParticipate challengeParticipate) {
		return cd.delete(challengeParticipate);
	}

	@Override
	public int update(ChallengeParticipate challengeParticipate) {
		return cd.update(challengeParticipate);
	}

	@Override
	public List<Challenge> search(String userId) {
		return cd.search(userId);
	}

	@Override
	public List<ChallengeParticipate> getParticipatedPersonNum(int challengeId) {
		return cd.getParticipatedPersonNum(challengeId);
	}

	@Override
	public boolean isParticipate(ChallengeParticipate challengeParticipate) {
		if (cd.isParticipated(challengeParticipate)!= null) return true;
		else return false;
	}

}
