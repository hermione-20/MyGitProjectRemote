
package com.itheima.web.convertor;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * 
 * 需求：把表单中MM/dd/yyyy类型的数据 转换成日期类型
 *       把数据库中的本地日期格式，转换成MM/dd/yyyy形式输出；
 * 自定义子类转换器：
 * 第一步：编写一个类，继承自StrutsTypeConvertor,实现convertFromString和convertToString抽象方法；
 * 
 * @author hermi
 *
 */
public class MyTypeConvertor extends StrutsTypeConverter {
	//定义一个类型转换器
	private DateFormat format=new SimpleDateFormat("MM/dd/yyyy");
	//SimpleDateFormat.format()格式化是返回的是string类型
	//而SimpleDateFormat.parse() 返回Date格式

	/**
	 * 把字符串数组中的数据转换成日期类型
	 * 
	 * 方法参数详解：
	 * Map context：是OGNL的上下文对象，我们暂时不知道，所以暂时也不用
	 * String[] values：要转换的数据
	 * Class toClass：目标类型
	 */
	public Object convertFromString(Map context, String[] values, Class toClass) {
		//1.先看看有没有数据
		if(values == null|| values.length == 0) {
			return null;
		}
		//2.取出数组中的第一个元素
		String date=values[0];
		//3.判断目标类型的字节码是不是日期类型
		if(toClass == java.util.Date.class) {
			//4.使用DateFormate进行转换，并且返回转换后的结果；
			try {
				return format.parse(date);
				///SimpleDateFormat中的parse方法可以 把String型的字符串转换成特定格式的date类型  
			} catch (ParseException e) {
				return null;
			}
		}
		return null;
			
	}

	/**
	 * 把日期类型的数据转换成字符串
	 * 
	 * 方法参数详解：
	 * Map context：是OGNL的上下文对象，我们暂时不知道，所以暂时也不用
	 * Object o:要转换的数据
	 */
	public String convertToString(Map context, Object o) {
		//1.判断object是不是日期类型
		if(o instanceof Date) {
		//2.是日期类型，使用转换器转换成指定格式的字符串，并返回。
			Date date=(Date)o;
			return format.format(date);
			}
		return null;
	}

}
