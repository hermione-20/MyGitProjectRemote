package com.itheima.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * Iterrator��ǩ��ʹ��
 * @author hermi
 *
 */
public class Demo4Action extends ActionSupport {
	//Action����������ã�Ĭ������¾���ValueStack��ջ��
	private List<Student> students;
	
	public String findAll() {
		//����service��ķ�����List findAllStudent()
		students=new ArrayList<Student>();
		students.add(new Student("����",18));
		students.add(new Student("����",19));
		students.add(new Student("����",20));

		return SUCCESS;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
