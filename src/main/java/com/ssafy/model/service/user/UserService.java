package com.ssafy.model.service.user;

import com.ssafy.model.dto.user.User;

public interface UserService {
	int regist(User user);
	User selectById(String id);
	User selectByNickname(String username);
	User selectByIdAndPassword(User user);
	User selectByEmail(String email);
	int update(User user);
	int withdrawal(String id);
}
