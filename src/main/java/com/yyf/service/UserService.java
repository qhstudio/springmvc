package com.yyf.service;

import java.util.List;

import com.yyf.model.User;

public interface UserService {
	/**
	 * 查看所有用户
	 * 
	 * @return
	 */
	List<User> getUsers();

	/**
	 * 增加用户
	 * 
	 * @param u
	 * @return
	 */
	User add(User u);

	/**
	 * 根据id查找一个用户
	 * @param id
	 * @return
	 */
	User getUser(Long id);

}
