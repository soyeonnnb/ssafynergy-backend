package com.ssafy.model.dao.user;

import java.util.List;

import com.ssafy.model.dto.user.Follow;
import com.ssafy.model.dto.user.User;

public interface FollowDao {
	List<User> selectByFollowerId(String id);

	List<User> selectByFollowingId(String id);
	
	Follow selectOne(Follow follow);

	int insertFollow(Follow follow);

	int deleteFollow(Follow follow);
}
