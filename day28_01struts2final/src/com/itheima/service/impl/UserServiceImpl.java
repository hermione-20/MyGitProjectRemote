package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao dao=new UserDaoImpl();


	public User login(String logonName, String logonPwd) {	
		return dao.selectUserByInfo(logonName,logonPwd);
	}

	
	public int saveUser(User user) {
		
		return dao.addUser(user);
	}

	public int modifyUser(User user) {
		return dao.updateUser(user);
	}

	@Override
	public int removeUser(Integer userID) {
		return dao.deleteUser(userID);
	}

	@Override
	public User findUserById(Integer userID) {
		return dao.selectUserById(userID);
	}

	@Override
	public List<User> findAllUser() {
		return dao.selectAllUser();
	}

	@Override
	public List<User> findUserByCondition(String userName, String gender, String education, String isUpload) {
		return dao.selectUserByCondition(userName,gender,education,isUpload);
	}

}
