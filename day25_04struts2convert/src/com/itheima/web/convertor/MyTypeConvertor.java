
package com.itheima.web.convertor;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * 
 * ���󣺰ѱ���MM/dd/yyyy���͵����� ת������������
 *       �����ݿ��еı������ڸ�ʽ��ת����MM/dd/yyyy��ʽ�����
 * �Զ�������ת������
 * ��һ������дһ���࣬�̳���StrutsTypeConvertor,ʵ��convertFromString��convertToString���󷽷���
 * 
 * @author hermi
 *
 */
public class MyTypeConvertor extends StrutsTypeConverter {
	//����һ������ת����
	private DateFormat format=new SimpleDateFormat("MM/dd/yyyy");
	//SimpleDateFormat.format()��ʽ���Ƿ��ص���string����
	//��SimpleDateFormat.parse() ����Date��ʽ

	/**
	 * ���ַ��������е�����ת������������
	 * 
	 * ����������⣺
	 * Map context����OGNL�������Ķ���������ʱ��֪����������ʱҲ����
	 * String[] values��Ҫת��������
	 * Class toClass��Ŀ������
	 */
	public Object convertFromString(Map context, String[] values, Class toClass) {
		//1.�ȿ�����û������
		if(values == null|| values.length == 0) {
			return null;
		}
		//2.ȡ�������еĵ�һ��Ԫ��
		String date=values[0];
		//3.�ж�Ŀ�����͵��ֽ����ǲ�����������
		if(toClass == java.util.Date.class) {
			//4.ʹ��DateFormate����ת�������ҷ���ת����Ľ����
			try {
				return format.parse(date);
				///SimpleDateFormat�е�parse�������� ��String�͵��ַ���ת�����ض���ʽ��date����  
			} catch (ParseException e) {
				return null;
			}
		}
		return null;
			
	}

	/**
	 * ���������͵�����ת�����ַ���
	 * 
	 * ����������⣺
	 * Map context����OGNL�������Ķ���������ʱ��֪����������ʱҲ����
	 * Object o:Ҫת��������
	 */
	public String convertToString(Map context, Object o) {
		//1.�ж�object�ǲ�����������
		if(o instanceof Date) {
		//2.���������ͣ�ʹ��ת����ת����ָ����ʽ���ַ����������ء�
			Date date=(Date)o;
			return format.format(date);
			}
		return null;
	}

}
