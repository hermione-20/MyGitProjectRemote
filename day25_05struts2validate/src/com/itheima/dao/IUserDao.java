package com.itheima.dao;

import com.itheima.domain.User;

/**
 * �û���ز����ĳ־ò�ӿ�
 * @author hermi
 *
 */
public interface IUserDao {
	/**
	 * �����û����Ʋ�ѯ�û�
	 * @param username
	 * @return
	 */

	User selectUserByUsername(String username);
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */

	int addUser(User user);

}
