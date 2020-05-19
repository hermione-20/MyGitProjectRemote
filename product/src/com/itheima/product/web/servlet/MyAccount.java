package com.itheima.product.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.product.domain.User;

/**
 * Servlet implementation class MyAccount
 */
public class MyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//从session中取出user对象
		User user=(User) request.getSession().getAttribute("user");
		
		//判断user是否为null
		if (user==null) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else {
			System.out.println(user.getId());
			//默认普通用户页面
			String path="/myAccount.jsp";
			if("admin".equals(user.getRole())) {
				//管理员页面
				path="admin/login/home.jsp";
				
			}
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
