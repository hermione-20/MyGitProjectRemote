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
 * ʹ��ValueStack������
 * @author hermi
 *
 */
public class Demo2Action extends ActionSupport {
	private String name="test2";
	
	public String execute() {
		//��ȡValueStack���������
//		//��һ�ַ�ʽ����ȡHttpServletRequest����ͨ�������getAttribute������������ȡ��
//		//1.��ȡrequest����
//		HttpServletRequest request=ServletActionContext.getRequest();
//		//2.����key��ȡvalueStack���������
//		ValueStack vs1=(ValueStack) request.getAttribute("struts.valueStack");
//		System.out.println(vs1.hashCode());
//		
//		//�ڶ��ַ�ʽ���Ȼ�ȡActionContext������ȡ��requestMap,Ȼ��ͨ��request��map������ȡ��
//		//1.��ȡActionContext����
//		ActionContext context=ActionContext.getContext();
//		//2.��ȡrequestMap
//		Map<String,Object> requestAttribute=(Map<String, Object>) context.get("request");
//		//3.����key��ȡ���������
//		ValueStack vs2= (ValueStack) requestAttribute.get("struts.valueStack");
//		System.out.println(vs2.hashCode());
//		
//		//�����ַ�ʽ��ʹ��ActionContext����ķ�����ֱ�ӻ�ȡValueStack��������ã�
//		ValueStack vs3=context.getValueStack();
//		System.out.println(vs3.hashCode());
		
		//ջ�Ĳ���
		ActionContext context=ActionContext.getContext();
		ValueStack vs=context.getValueStack();
		
		//ѹջ
		vs.push(new Student("test",21));
		
		/**
		 * ValueStack����������
		 * setValue(String expr,Object value);
		 * String expr:����һ��OGNL���ʽ��
		 * Object value������Ҫ���������ݣ�
		 * 
		 * �����ݴ浽����ȥ��
		 *   ��expr�Ƿ�ʹ����#��
		 *     ���ʹ����#�������ľ���ContextMap�У�
		 *     ���û��ʹ��#�������ľ���ValueStack�У�
		 */
		vs.setValue("#name", "����");//�����ݷŵ�contextMap�У�key��name,value��������
		vs.setValue("name", "����");//��ValueStack�еĵ�һ��name���Ի������ģ����û��һ��name���Զ�Ӧ��setName�������ᱨ��
		
		/**
		 * set����
		 * set(String key,object o)
		 * String key:map��key
		 * object o��map��value
		 * ���ջ����һ��mapԪ�أ�ֱ�Ӱ�key��Ϊmap��key����value��Ϊmap��value���룬�������ջ����
		 * ���ջ������һ��mapԪ�أ�����һ��map���󣬰�key��Ϊmap��key��value��Ϊmap��value��ѹ��ջ����
		 */
		vs.set("s1",new Student("����",18));
		vs.push(new Student("̩˹��",29));
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
