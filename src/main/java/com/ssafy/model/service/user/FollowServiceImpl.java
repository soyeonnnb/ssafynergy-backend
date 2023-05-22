package com.ssafy.model.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.user.FollowDao;
import com.ssafy.model.dto.user.Follow;
import com.ssafy.model.dto.user.User;

@Service
public class FollowServiceImpl implements FollowService{

	@Autowired
	private FollowDao fd;
	
	@Override
	public List<User> selectByFollowerId(String id) {
		return fd.selectByFollowerId(id);
	}

	@Override
	public List<User> selectByFollowingId(String id) {
		return fd.selectByFollowingId(id);
	}

	@Override
	public boolean isFollow(Follow follow) {
		if (fd.selectOne(follow) == null) return false;
		else return true;
	}

	@Override
	public int insertFollow(Follow follow) {
		return fd.insertFollow(follow);
	}

	@Override
	public int deleteFollow(Follow follow) {
		return fd.deleteFollow(follow);
	}

}
