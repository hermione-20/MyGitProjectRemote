package com.itheima.web.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.itheima.domain.User;
import com.itheima.impl.UserServiceImpl;
import com.itheima.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * �û�������صĶ�����
 * @author hermi
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private IUserService service=new UserServiceImpl();
	
	//����һ���û�������ģ�͡�ע������ʹ����ģ�����������Ǳ����Լ�ʵ��������
	private User user=new User();

	
	public User getModel() {
		return user;
	}
	
	/**
	 * ��struts2����У���Ҳ�ṩ��һ��Map<�����ֶ�����������ʾ>
	 * ����Ҫ���ģ�
	 *     ��map���Ŵ�����Ϣ
	 * 
	 * ���ʽ��֤��
	 * 1.���������̳�ActionSupport
	 * 2.��дvalidate����
	 *
	 *validate�������ڶ�������ִ��֮ǰ������֤
	 *����д��validate����������Զ������е����ж�������������֤
	 *
	 *�����֤���ж������������⣺
	 *1.ʹ��@skipValidation��ע��
	 *2.������֤���������ƣ�validate+�������ƣ�������������ĸ��д
	 */
	
	/*
	 * public void validateRegister() { if(StringUtils.isEmpty(user.getUsername()))
	 * { //���������Ϣ��ֱ�ӵ��ø����addFieldError�����������Ϣ����һ�������Ǳ�name���Ե�ֵ���ڶ��������Ǵ�����ʾ��
	 * addFieldError("username", "�������û���"); } }
	 */
	/*
	 * public void validate() { if(StringUtils.isEmpty(user.getUsername())) {
	 * //���������Ϣ��ֱ�ӵ��ø����addFieldError�����������Ϣ����һ�������Ǳ�name���Ե�ֵ���ڶ��������Ǵ�����ʾ��
	 * addFieldError("username", "�������û���"); } }
	 */
	

	public String findAll() {
		return SUCCESS;
	}
	
	
	public String regist() {
		//1.�����û�����ȡ���ݿ���û�����
		User dbUser=service.findUserByUsername(user.getUsername());
		//2.�ж϶����Ƿ����
		if(dbUser!=null) {
			//2.1 ������ڣ�������û����ˣ�����exists�Ľ����ͼ��
			return "exists";
		}
		   //2.2 ��������ڣ������û���Ϣ��
		int res=service.register(user);
		//���ִ�н������0���ɹ���
		if(res>0) {
			return SUCCESS;
		}
		  //���ִ�н��������0������null��
		return null;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
