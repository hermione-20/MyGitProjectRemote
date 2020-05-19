package com.itheima.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.Customer;
import com.itheima.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 表单的一个小例子
 * @author hermi
 *
 */
public class Demo7Action extends ActionSupport implements ModelDriven<Customer>{
	//定义一个模型，注意：必须自己实例化
	private Customer customer=new Customer();
	public Customer getModel() {
		return customer;
	}

	public String save() {
		System.out.println(customer);
		return null;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	

	
}
