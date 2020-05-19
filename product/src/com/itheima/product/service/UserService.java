package com.itheima.product.service;


import java.sql.SQLException;

import com.itheima.product.dao.UserDao;
import com.itheima.product.domain.User;
import com.itheima.product.exception.UserException;
import com.itheima.product.util.SendJMail;

public class UserService {
	UserDao ud=new UserDao();

	public void regist(User user) throws UserException {
		try {
			ud.addUser(user);
			String emailMsg="ע��ɹ�����<a href='http://www.product.com/activeServlet?activeCode="+user.getActiveCode()+"'>����</a>���¼";
			SendJMail.sendMail(user.getEmail(), emailMsg);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("ע��ʧ��!");
		}
	}

	public void activeUser(String activeCode) throws UserException {
	//���ݼ���������û�
		try {
			User user = ud.FindUserByActiveCode(activeCode);
		if (user!=null) {
			//�����û�
				ud.activeCode(activeCode);
				return;
		}
		throw new UserException("����ʧ��");
			} catch (SQLException e) {
				e.printStackTrace();
		throw new UserException("����ʧ��");
			}
			
		
	}

	public User login(String username, String password) throws UserException {
		User user=null;
		try {
			 user= ud.findUserByUserNameAndPassword(username,password);
			if (user==null) {
				throw new UserException("�û������������");
			}
			if(user.getState()==0) {
				throw new UserException("�û�δ����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("��¼ʧ��");

		}
		return user;
	}

	public User findUserById(String id) throws UserException {
		
		try {
			return ud.findUserById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("�û�����ʧ�ܣ�");
		}
	}

	public void modifyUser(User user) throws UserException {
		try {
			ud.modifyUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("�޸��û���Ϣʧ��");
		}
		
	}

}
	