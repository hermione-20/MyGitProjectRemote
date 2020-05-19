package com.itheima.impl;

import com.itheima.DaoImpl.UserDaoImpl;
import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.itheima.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	private IUserDao dao=new UserDaoImpl();

	
	public User findUserByUsername(String username) {
		return dao.selectUserByUsername(username);
	}

	
	public int register(User user) {
		return dao.addUser(user);
	}

}
