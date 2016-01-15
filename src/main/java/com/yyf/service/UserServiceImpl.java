package com.yyf.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyf.dao.UserDao;
import com.yyf.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public List<User> getUsers() {
		List<User> list = (List<User>) userDao.findAll();
		return list;
	}

	@Override
	public User add(User u) {
		return userDao.save(u);
	}

	@Override
	public User getUser(Long id) {
		return userDao.findOne(id);
	}

}
