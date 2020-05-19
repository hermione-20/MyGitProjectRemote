package com.itheima.dao;

import java.util.List;

import com.itheima.domain.User;

/**
 * �û�������س־ò�ӿ�
 * @author hermi
 *
 */
public interface IUserDao {

	User selectUserByInfo(String logonName, String logonPwd);

	int updateUser(User user);

	int addUser(User user);

	int deleteUser(Integer userID);

	User selectUserById(Integer userID);

	List<User> selectAllUser();

	List<User> selectUserByCondition(String userName, String gender, String education, String isUpload);

	

}
