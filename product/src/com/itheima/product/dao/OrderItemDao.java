package com.itheima.product.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.product.domain.Order;
import com.itheima.product.domain.OrderItem;
import com.itheima.product.util.C3P0Util;
import com.itheima.product.util.ManagerThreadLocal;

public class OrderItemDao {
	
	//添加订单项
	public void addOrderItem(Order order) throws SQLException {
		List<OrderItem> orderItems=order.getOrderItems();//得到所有订单项的集合
		QueryRunner qr=new QueryRunner();
		Object[][] params=new Object[orderItems.size()][];//高维代表循环次数，低维代表每次循环问号的值
		for (int i = 0; i < params.length; i++) {
			//i代表循环次数，{}里面的是？的值
			//数组中的第一个参数：主单ID；第二个参数：商品id；第三个参数：商品的购买数量
			
			params[i]=new Object[] {order.getId(),orderItems.get(i).getP().getId(),orderItems.get(i).getBuynum()};
		}
		qr.batch( ManagerThreadLocal.getConnection(),"insert into orderitem values(?,?,?)", params);
		
	}

}
