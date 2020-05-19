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
		//��session��ȡ��user����
		User user=(User) request.getSession().getAttribute("user");
		
		//�ж�user�Ƿ�Ϊnull
		if (user==null) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else {
			System.out.println(user.getId());
			//Ĭ����ͨ�û�ҳ��
			String path="/myAccount.jsp";
			if("admin".equals(user.getRole())) {
				//����Աҳ��
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
