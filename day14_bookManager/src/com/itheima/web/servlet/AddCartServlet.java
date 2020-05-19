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
		PrintWriter out=response.getWriter();//response.getWriter()���ص���PrintWriter������һ����ӡ�����
		
		String id=request.getParameter("id");
		
		BookServiceImpl bs=new BookServiceImpl();
		Book b=bs.findBookById(id);
		
		//��session�аѹ��ﳵȡ����
		HttpSession session=request.getSession();
		Map<Book,String> cart=(Map<Book, String>) session.getAttribute("cart");//
		int num=1;
		//����ǵ�һ�η��ʣ�û�й��ﳵ�������Ǿʹ���һ�����ﳵ����
		if(cart==null) {
			cart=new HashMap<Book, String>();
		}
		//�鿴��ǰ�����Ƿ����b�Ȿ�飬����У��Ͱ�����ȡ����+1
		if(cart.containsKey(b)) {
			num=Integer.parseInt(cart.get(b))+1;//Integer.parseInt(String)�����þ��ǽ�String�ַ���������ת��ΪInteger�������ݡ�
		}
		
		//��ͼ����빺�ﳵ
		cart.put(b, num+"");
		//��cart����Żص�session��������
		session.setAttribute("cart", cart);
		
		out.print("<a href='"+request.getContextPath()+"/pageServlet'>��������</a>��<a href='"+request.getContextPath()+"/cart.jsp'>�鿴���ﳵ</a>");//�϶ϼӼӣ�"++"��
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
