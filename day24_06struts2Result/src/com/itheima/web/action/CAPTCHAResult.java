package com.itheima.web.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

import cn.dsna.util.images.ValidateCode;
/**
 * �Զ���������
 *   ��һ������дһ����ͨ�࣬�̳�StrutsResultSupport���࣬������дdoExecute()�ķ���
 * @author hermi
 *
 */
public class CAPTCHAResult extends StrutsResultSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * CAPTCHA��Ŀ�� Completely Automated Public Turing Test to Tell Computers and
	 * Humans Apart (ȫ�Զ����ּ�����������ͼ�����)�ļ�ƣ���֤��
	 */
	
	//ͨ�������ļ�����������ͼƬ�Ĵ�С
	private int width;
	private int height;
	
	//servlet��ԭ������д�����ڻ���ôд
	protected void doExecute(String arg0, ActionInvocation arg1) throws Exception {
		/*
		 * ʹ�õ�������֤���jar��
		 *   1.����ValidateCode.jar������libĿ¼��
		 *   2.����ValidateCode����
		 *   3.��ȡ��Ӧ�����������
		 *   4.������������
		 */
         //����ValidateCode����
		//������⣺1.ͼ���� 2.ͼ��߶� 3.���ָ��� 4.����������
		ValidateCode code=new ValidateCode(width,height,4,10);
		//��ȡ��Ӧ����
		HttpServletResponse response=ServletActionContext.getResponse();
		//����������
		code.write(response.getOutputStream());
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
