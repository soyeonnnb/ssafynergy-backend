package com.ssafy.model.service.user;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.model.dao.user.UserDao;
import com.ssafy.model.dto.user.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao ud;

	@Autowired
	private ResourceLoader resLoader;

	@Override
	@Transactional
	public int regist(User user) {
		fileHandling(user);
		return ud.insert(user);
	}

	private void fileHandling(User user) {
		Resource res = resLoader.getResource("resources/user/profile/" + user.getId());
		try {
			if (!res.getFile().exists())
				res.getFile().mkdir();
			MultipartFile file = user.getFile();
			if (file != null && file.getSize() > 0) {
				user.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
				file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + user.getImg()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User selectById(String id) {
		return ud.selectById(id);
	}

	@Override
	@Transactional
	public int update(User user) {
		return ud.update(user);
	}

	@Override
	@Transactional
	public int withdrawal(String id) {
		return ud.delete(id);
	}

	@Override
	public User selectByNickname(String nickname) {
		return ud.selectByNickname(nickname);
	}

}
