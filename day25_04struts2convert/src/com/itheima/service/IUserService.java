package com.itheima.service;

import com.itheima.domain.User;

/**
 * �û���ز�����ҵ���ӿ�
 * @author hermi
 *
 */
public interface IUserService {
	/**
	 * �����û����ж��û��Ƿ����
	 */
	User findUserByUsername(String username);
	/**
	 * �û�ע��
	 * @param user
	 */
	int register(User user);

}
