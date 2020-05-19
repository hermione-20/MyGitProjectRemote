package com.itheima.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Book;
import com.itheima.service.BookServiceImpl;

/**
 * Servlet implementation class SearchBooksServlet
 */
@WebServlet("/searchBooksServlet")
public class SearchBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//��ȡ������
		String id=request.getParameter("id");
		String category=request.getParameter("category");
		String name=request.getParameter("name");
		String minprice=request.getParameter("minprice");
		String maxprice=request.getParameter("maxprice");
		
		//����ҵ���߼�
		BookServiceImpl bs=new BookServiceImpl();
		List<Book> list= bs.searchBooks(id,category,name,minprice,maxprice);
		
		 //�ַ�ת��
		request.setAttribute("books", list);//��list����request������
		request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
