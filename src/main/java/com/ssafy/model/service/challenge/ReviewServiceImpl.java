package com.ssafy.model.service.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.challenge.ReviewDao;
import com.ssafy.model.dto.challenge.Review;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewDao rd;
	
	@Override
	public int insert(Review review) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Review review) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Review> searchChallengeReview(String challengeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> searchUserReview(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
