package com.yyf.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.yyf.model.User;

public interface UserDao extends PagingAndSortingRepository<User,Long>{
	
}
