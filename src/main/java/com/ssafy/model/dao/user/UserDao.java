package com.ssafy.model.dao.user;

import com.ssafy.model.dto.user.User;

public interface UserDao {
	int insert(User user);

	User selectById(String id);
	
	User selectByNickname(String nickname);

	int update(User user);

	int delete(String id);
}
