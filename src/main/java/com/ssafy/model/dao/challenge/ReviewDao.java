package com.ssafy.model.dao.challenge;

import java.util.List;

import com.ssafy.model.dto.challenge.Review;

public interface ReviewDao {
	int insert(Review review);
	int update(Review review);
	int delete(int id);
	List<Review> searchChallengeReview(int id);
	List<Review> searchUserReview(String userId);
}
