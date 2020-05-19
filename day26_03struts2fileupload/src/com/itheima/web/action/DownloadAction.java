package com.itheima.web.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 文件下载
 * @author hermi
 *
 */
public class DownloadAction extends ActionSupport {
	//创建一个文件名属性
	private String filename;
	//注：在给InputStream指定名称时，不能使用in；
	private InputStream inputStream;
	public String download() throws Exception {
		//1.找到文件的存储路径
		String filePath=ServletActionContext.getServletContext().getRealPath("/WEB-INF/files/1.JPG");
		//2.把文件读到一个InputStream中
		inputStream=new FileInputStream(filePath);
		
		//在创建之前，给filename赋值
		filename="照片.jpg";
		//3.返回成功
		return SUCCESS;
		//4.由一个叫stream的结果视图为我们把剩下的事情做完；
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
