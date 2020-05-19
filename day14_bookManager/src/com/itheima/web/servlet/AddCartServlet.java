package com.itheima.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.Book;
import com.itheima.service.BookServiceImpl;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet(name = "addCartServlet", urlPatterns = {"/addCartServlet"})
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();//response.getWriter()返回的是PrintWriter，这是一个打印输出流
		
		String id=request.getParameter("id");
		
		BookServiceImpl bs=new BookServiceImpl();
		Book b=bs.findBookById(id);
		
		//从session中把购物车取出来
		HttpSession session=request.getSession();
		Map<Book,String> cart=(Map<Book, String>) session.getAttribute("cart");//
		int num=1;
		//如果是第一次访问，没有购物车对象，我们就创建一个购物车对象
		if(cart==null) {
			cart=new HashMap<Book, String>();
		}
		//查看当前集合是否存在b这本书，如果有，就把数量取出来+1
		if(cart.containsKey(b)) {
			num=Integer.parseInt(cart.get(b))+1;//Integer.parseInt(String)的作用就是将String字符类型数据转换为Integer整型数据。
		}
		
		//把图书放入购物车
		cart.put(b, num+"");
		//把cart对象放回到session作用域中
		session.setAttribute("cart", cart);
		
		out.print("<a href='"+request.getContextPath()+"/pageServlet'>继续购物</a>，<a href='"+request.getContextPath()+"/cart.jsp'>查看购物车</a>");//断断加加（"++"）
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
