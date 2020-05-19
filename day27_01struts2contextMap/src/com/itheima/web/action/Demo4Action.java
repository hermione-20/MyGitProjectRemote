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
 * Iterrator标签的使用
 * @author hermi
 *
 */
public class Demo4Action extends ActionSupport {
	//Action动作类的引用，默认情况下就在ValueStack的栈顶
	private List<Student> students;
	
	public String findAll() {
		//调用service层的方法，List findAllStudent()
		students=new ArrayList<Student>();
		students.add(new Student("张三",18));
		students.add(new Student("李四",19));
		students.add(new Student("王五",20));

		return SUCCESS;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
