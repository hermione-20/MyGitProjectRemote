package com.itheima.web.action;

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
 * 使用ValueStack存数据
 * @author hermi
 *
 */
public class Demo2Action extends ActionSupport {
	private String name="test2";
	
	public String execute() {
		//获取ValueStack对象的引用
//		//第一种方式：获取HttpServletRequest对象，通过对象的getAttribute方法，从域中取；
//		//1.获取request对象
//		HttpServletRequest request=ServletActionContext.getRequest();
//		//2.根据key获取valueStack对象的引用
//		ValueStack vs1=(ValueStack) request.getAttribute("struts.valueStack");
//		System.out.println(vs1.hashCode());
//		
//		//第二种方式：先获取ActionContext对象，再取出requestMap,然后通过request的map方法获取；
//		//1.获取ActionContext对象
//		ActionContext context=ActionContext.getContext();
//		//2.获取requestMap
//		Map<String,Object> requestAttribute=(Map<String, Object>) context.get("request");
//		//3.根据key获取对象的引用
//		ValueStack vs2= (ValueStack) requestAttribute.get("struts.valueStack");
//		System.out.println(vs2.hashCode());
//		
//		//第三种方式：使用ActionContext对象的方法，直接获取ValueStack对象的引用；
//		ValueStack vs3=context.getValueStack();
//		System.out.println(vs3.hashCode());
		
		//栈的操作
		ActionContext context=ActionContext.getContext();
		ValueStack vs=context.getValueStack();
		
		//压栈
		vs.push(new Student("test",21));
		
		/**
		 * ValueStack的其他方法
		 * setValue(String expr,Object value);
		 * String expr:它是一个OGNL表达式；
		 * Object value：我们要操作的数据；
		 * 
		 * 把数据存到哪里去？
		 *   看expr是否使用了#；
		 *     如果使用了#，操作的就是ContextMap中；
		 *     如果没有使用#，操作的就是ValueStack中；
		 */
		vs.setValue("#name", "张三");//把数据放到contextMap中，key是name,value是张三；
		vs.setValue("name", "李四");//把ValueStack中的第一个name属性换成李四；如果没有一个name属性对应的setName方法，会报错
		
		/**
		 * set方法
		 * set(String key,object o)
		 * String key:map的key
		 * object o：map的value
		 * 如果栈顶是一个map元素，直接把key作为map的key，把value作为map的value存入，存入的是栈顶；
		 * 如果栈顶不是一个map元素，创建一个map对象，把key作为map的key，value作为map的value，压入栈顶；
		 */
		vs.set("s1",new Student("王五",18));
		vs.push(new Student("泰斯特",29));
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
