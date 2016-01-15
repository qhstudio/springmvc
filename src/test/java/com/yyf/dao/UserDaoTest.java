package com.yyf.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyf.model.User;

public class UserDaoTest {
	ApplicationContext ac = null;
	UserDao userDao = null;

	@Before
	public void testBefore() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao) ac.getBean("userDao");
	}
	
	@Test
	public void testAdd() {
		for(int i=0;i<22;i++){
			User user = new User();
			user.setUserName("用户名"+i);
			userDao.save(user);
		}
	}
	@Test
	public void testFindAll() {
		List<User> list = (List<User>) userDao.findAll();
		System.out.println(list);
	}
	@Test
	public void test() {

	}

}
