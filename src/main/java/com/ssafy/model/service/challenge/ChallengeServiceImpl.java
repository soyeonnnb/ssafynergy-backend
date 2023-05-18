package com.ssafy.model.service.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.challenge.ChallengeDao;
import com.ssafy.model.dto.challenge.Challenge;
import com.ssafy.model.dto.challenge.SearchCondition;

@Service
public class ChallengeServiceImpl implements ChallengeService{

	@Autowired
	private ChallengeDao cd;
	
	@Override
	public int insert(Challenge challenge) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Challenge challenge) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Challenge> search(SearchCondition condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Challenge select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
