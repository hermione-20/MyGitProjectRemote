package com.itheima.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.BookServiceImpl;
import com.itheima.web.domain.PageBean;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//��ʼ��ÿҳ��ʾ������
		int pageSize=4;
		
		int currentPage=1;//��ǰҳ
		
		String currPage=request.getParameter("currentPage");//����һҳ������һҳ�õ�������
		if(currPage!=null){//��һ�η�����Դʱ��currPage������null
			currentPage=Integer.parseInt(currPage);//Integer.parseInt(String)���ǽ�String�ַ���������ת��ΪInteger��������
		}
		
		BookServiceImpl bs=new BookServiceImpl();
		
		//��ҳ��ѯ��������PageBean����
		PageBean pb=bs.findBooksPage(currentPage,pageSize);
		
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
