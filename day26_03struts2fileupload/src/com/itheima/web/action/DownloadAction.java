package com.itheima.web.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * �ļ�����
 * @author hermi
 *
 */
public class DownloadAction extends ActionSupport {
	//����һ���ļ�������
	private String filename;
	//ע���ڸ�InputStreamָ������ʱ������ʹ��in��
	private InputStream inputStream;
	public String download() throws Exception {
		//1.�ҵ��ļ��Ĵ洢·��
		String filePath=ServletActionContext.getServletContext().getRealPath("/WEB-INF/files/1.JPG");
		//2.���ļ�����һ��InputStream��
		inputStream=new FileInputStream(filePath);
		
		//�ڴ���֮ǰ����filename��ֵ
		filename="��Ƭ.jpg";
		//3.���سɹ�
		return SUCCESS;
		//4.��һ����stream�Ľ����ͼΪ���ǰ�ʣ�µ��������ꣻ
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
