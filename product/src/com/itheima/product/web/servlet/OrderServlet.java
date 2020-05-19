package com.itheima.product.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.product.domain.Order;
import com.itheima.product.domain.OrderItem;
import com.itheima.product.domain.Product;
import com.itheima.product.domain.User;
import com.itheima.product.service.OrderService;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       

	protected void createOrder(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1.封装Order对象
				Order order=new Order();
				try {
					BeanUtils.populate(order, request.getParameterMap());
					order.setId(UUID.randomUUID().toString());
					order.setUser((User) request.getSession().getAttribute("user"));//把session对象中的用户信息保存到order对象中
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//2.获取Session对象中的购物车数据
				Map<Product,String> cart=(Map<Product, String>) request.getSession().getAttribute("cart");
				
				//3.遍历购物车中的对象，添加到OrderItem对象中，同时把多个OrderItem对象添加到list集合中
				List<OrderItem> list=new ArrayList<OrderItem>();
				for (Product p : cart.keySet()) {
					OrderItem oi=new OrderItem();
					oi.setOrder(order);//把order对象添加到OrderItem中
					oi.setP(p);//把购物车中的商品对象添加到OrderItem中
					oi.setBuynum(Integer.parseInt(cart.get(p)));//把购物车中的商品数量添加到OrderItem中
					
					list.add(oi);//把每个订单项添加到集合中
				}
				
				//4.把集合放入到Order对象中
				order.setOrderItems(list);
				
				//调用业务逻辑
				OrderService os=new OrderService();
				os.addOrder(order);
				
				//把订单中的订单号和订单金额取出
				request.setAttribute("orderid", order.getId());
				request.setAttribute("money", order.getMoney());
				
				//分发转向
				request.getRequestDispatcher("/pay.jsp").forward(request, response);
				
	}
	
	protected void findOrderByUserId(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		OrderService os=new OrderService();
		List<Order>orders=os.findOrderByUserId(user.getId());
		
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/orderlist.jsp").forward(request, response);
		
	}
	
	protected void findOrderItemsByOrderId(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
        String orderid=request.getParameter("orderid");
		
		OrderService os=new OrderService();
		Order order=os.findOrdersByOrderId(orderid);
		
		request.setAttribute("order", order);
		request.getRequestDispatcher("/orderInfo.jsp").forward(request, response);
		
	}
	
	

	
}
