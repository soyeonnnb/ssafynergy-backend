package com.ssafy.model.service.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.challenge.ChallengeDao;
import com.ssafy.model.dao.challenge.ChallengeLikeDao;
import com.ssafy.model.dao.challenge.ChallengeParticipateDao;
import com.ssafy.model.dto.challenge.Challenge;
import com.ssafy.model.dto.challenge.ChallengeLike;
import com.ssafy.model.dto.challenge.ChallengeParticipate;
import com.ssafy.model.dto.challenge.SearchCondition;

@Service
public class ChallengeServiceImpl implements ChallengeService{

	@Autowired
	private ChallengeDao cd;
	
	@Autowired
	private ChallengeParticipateDao cpd;
	
	@Autowired
	private ChallengeLikeDao cld;
	
	@Override
	public int insert(Challenge challenge) {
		return cd.insert(challenge);
	}

	@Override
	public int update(Challenge challenge) {
		return cd.update(challenge);
	}

	@Override
	public List<Challenge> search(SearchCondition condition) {
		return cd.search(condition);
	}

	@Override
	public Challenge select(int id) {
		return cd.select(id);
	}

	@Override
	public int getParticipatedCnt(int id) {
		int participatedCnt = 0;
		List<ChallengeParticipate> list = cpd.getParticipatedPersonNum(id);
		
		for(ChallengeParticipate c : list) {
			participatedCnt++;
		}
		
		return participatedCnt;
	}

	@Override
	public int getLikeCnt(int id) {
		int LikeCnt = 0;
		List<ChallengeLike> list = cld.getLikePersonNum(id);
		
		for (ChallengeLike c : list) {
			LikeCnt++;
		}
		
		return LikeCnt;
	}
	
}
