package com.ssafy.model.service.challenge;

import java.util.List;

import com.ssafy.model.dto.challenge.Review;

public interface ReviewService {
	int insert(Review review);
	
	int update(Review review);
	
	int delete(int id);
	
	List<Review> searchChallengeReview(String challengeId);
	
	List<Review> searchUserReview(String userId);
}
