package com.ssafy.model.service.user;

import java.util.List;

import com.ssafy.model.dto.user.Follow;
import com.ssafy.model.dto.user.User;

public interface FollowService {
	List<User> selectByFollowerId(String id);

	List<User> selectByFollowingId(String id);
	
	boolean isFollow(Follow follow);

	int insertFollow(Follow follow);

	int deleteFollow(Follow follow);
}
