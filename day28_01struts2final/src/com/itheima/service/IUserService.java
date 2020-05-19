package com.itheima.service;

import java.util.List;

import com.itheima.domain.User;

/**
 * �û�ҵ������
 * @author hermi
 *
 */
public interface IUserService {
	/**
	 * �û���¼
	 */
	User login(String logonName,String logonPwd);
	
	
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	
	
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	int modifyUser(User user);
	
	/**
	 * �����û�IDɾ���û�
	 */
	
	int removeUser(Integer userID);
	
	/**
	 * �����û�id����ȡ�û���Ϣ
	 * @param userId
	 * @return
	 */
	User findUserById(Integer userID);
	
	
	
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	List<User> findAllUser();
	
	/**
	 * ����������ѯ�û���Ϣ
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	List<User> findUserByCondition(String userName,String gender,String education,String isUpload);

}
