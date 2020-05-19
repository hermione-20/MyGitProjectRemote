package com.itheima.product.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.product.domain.User;

public class RoleFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//ǿת
		
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		//����ҵ��
		  //1.��session�а��û�����ȡ��
		  User user=(User) request.getSession().getAttribute("user");
		  //2.�жϵ�ǰ�û�Ȩ��
		  if(user!=null){
			  if(!"admin".equals(user.getRole())) {
				  response.getWriter().write("Ȩ�޲��㣬�޷�����");
				  response.setHeader("refresh", "2;url="+request.getContextPath()+"/index.jsp");
				  return;//������벻��Ҫִ�еĻ���Ҫд��return  
			  }
			//����
			  chain.doFilter(request, response);
		  }
		
		  response.sendRedirect(request.getContextPath()+"/login.jsp");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
