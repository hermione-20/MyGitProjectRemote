package com.itheima.web.action;

import com.itheima.web.domain.User;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ��̬������װ,�ڶ��������
 * ����ģ�ͺͶ�����ֿ�д
 * @author hermi
 *
 */
public class Demo3Action extends ActionSupport {
	//��������ģ�Ͷ���
	private User user;
	
	public String addUser() {
		System.out.println(user.getUsername()+","+user.getAge());
		return null;//�������κϽ����ͼ��NONE����
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
