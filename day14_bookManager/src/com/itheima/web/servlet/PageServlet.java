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
		//初始化每页显示的数据
		int pageSize=4;
		
		int currentPage=1;//当前页
		
		String currPage=request.getParameter("currentPage");//从上一页或者下一页得到的数据
		if(currPage!=null){//第一次访问资源时，currPage可能是null
			currentPage=Integer.parseInt(currPage);//Integer.parseInt(String)就是将String字符类型数据转换为Integer整型数据
		}
		
		BookServiceImpl bs=new BookServiceImpl();
		
		//分页查询，并返回PageBean对象
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
