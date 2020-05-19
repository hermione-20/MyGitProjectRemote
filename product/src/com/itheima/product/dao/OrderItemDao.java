package com.itheima.product.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.product.domain.Order;
import com.itheima.product.domain.OrderItem;
import com.itheima.product.util.C3P0Util;
import com.itheima.product.util.ManagerThreadLocal;

public class OrderItemDao {
	
	//���Ӷ�����
	public void addOrderItem(Order order) throws SQLException {
		List<OrderItem> orderItems=order.getOrderItems();//�õ����ж�����ļ���
		QueryRunner qr=new QueryRunner();
		Object[][] params=new Object[orderItems.size()][];//��ά����ѭ����������ά����ÿ��ѭ���ʺŵ�ֵ
		for (int i = 0; i < params.length; i++) {
			//i����ѭ��������{}������ǣ���ֵ
			//�����еĵ�һ������������ID���ڶ�����������Ʒid����������������Ʒ�Ĺ�������
			
			params[i]=new Object[] {order.getId(),orderItems.get(i).getP().getId(),orderItems.get(i).getBuynum()};
		}
		qr.batch( ManagerThreadLocal.getConnection(),"insert into orderitem values(?,?,?)", params);
		
	}

}