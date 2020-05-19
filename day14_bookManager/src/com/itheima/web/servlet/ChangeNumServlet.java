package com.itheima.web.servlet;

import java.io.IOException;
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
 * Servlet implementation class ChangeNumServlet
 */
@WebServlet("/changeNumServlet")
public class ChangeNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeNumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String num=request.getParameter("num");
		Book b=new Book();
		b.setId(id);
		
		HttpSession session=request.getSession();
		Map<Book,String> cart=(Map<Book, String>) session.getAttribute("cart");
		
		if("0".equals(num)) {
			cart.remove(b);
		}
		
		//判断如果找到与id相同的书，
		if(cart.containsKey(b)) {
			cart.put(b,num);
		}
		
		response.sendRedirect(request.getContextPath()+"/cart.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
