package com.ssafy.model.service.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.challenge.ChallengeContentDao;
import com.ssafy.model.dto.challenge.ChallengeContent;

@Service
public class ChallengeContentServiceImpl implements ChallengeContentService{

	@Autowired
	private ChallengeContentDao cd;
	
	@Override
	public int insert(ChallengeContent challengeContent) {
		return cd.insert(challengeContent);
	}

	@Override
	public int update(ChallengeContent challengeContent) {
		return cd.update(challengeContent);
	}

	@Override
	public int delete(int id) {
		return cd.delete(id);
	}

}
