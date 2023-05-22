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
		return rd.insert(review);
	}

	@Override
	public int update(Review review) {
		return rd.update(review);
	}

	@Override
	public int delete(int id) {
		return rd.delete(id);
	}

	@Override
	public List<Review> searchChallengeReview(int id) {
		return rd.searchChallengeReview(id);
	}

	@Override
	public List<Review> searchUserReview(String userId) {
		return rd.searchUserReview(userId);
	}

}
