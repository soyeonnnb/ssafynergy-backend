package com.ssafy.model.service.user;

import com.ssafy.model.dto.user.User;

public interface SocialLoginService {
	String kakaoGetToken(String code);
	User kakaoGetUserInfo(String accessToken);
}
