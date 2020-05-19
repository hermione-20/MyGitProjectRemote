package com.itheima.web.action;

import com.itheima.web.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ��̬������װ,�����������ģ������
 * Ҫ��ʹ��ģ����������������ģ�ͺͶ�����ֿ�д
 * 
 * ģ���������裺
 * 1.ʵ��һ��ModelDriven�Ľӿڣ�
 * 2.ʵ�ֽӿ��еĳ��󷽷�getModel();
 * 3.��ʹ������ģ��������ʱ�򣬱����������Լ�ʵ����
 * 
 * ����ModelDriven������Ϊ��������
 * 
 * ʵ�ʿ����в��õķ�ʽ
 * 
 * @author hermi
 *
 */
public class Demo4Action extends ActionSupport implements ModelDriven<User> {
	//��������ģ�Ͷ���
	private User user=new User();//ʹ��ģ�������������Լ�ʵ����ģ�Ͷ���
	
	//�÷������ص�������ģ��
	public User getModel() {
		return user;
	}
	
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
