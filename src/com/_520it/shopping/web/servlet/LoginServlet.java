package com._520it.shopping.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.shopping.dao.IUserDAO;
import com._520it.shopping.dao.impl.UserDAOImpl;
import com._520it.shopping.domain.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IUserDAO dao;
	public void init() throws ServletException {
		dao = new UserDAOImpl();
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = dao.getUserByUsername(username);
		//检查用户是否存在
		if(user==null || user.getId()==null){
			req.setAttribute("errorMsg","亲，"+username+"该账户不存在");
			req.getRequestDispatcher("/login.jsp").forward(req,resp);
			return;
		}
		if(!user.getPassword().equals(password)){
			req.setAttribute("errorMsg","亲，"+"用户名密码输入错误");
			req.getRequestDispatcher("/login.jsp").forward(req,resp);
			return;
		}
		//把当前登录用户存储到Session中
		req.getSession().setAttribute("USER_IN_SESSION",user);
		resp.sendRedirect("/product");
	}
	
}
















