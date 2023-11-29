package com.four.Mybatis.Servlet;

import com.four.Mybatis.Bean.User;
import com.four.Mybatis.Mapper.UserMapper;
import com.four.Mybatis.Util.GetSession;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdatePwd")
public class UpdatePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		User user = (User)request.getSession().getAttribute("User");
		SqlSession sqlsession = GetSession.getSession();
		try {  
			UserMapper up = sqlsession.getMapper(UserMapper.class);
			String pwd=request.getParameter("pwd");
			String Phone=request.getParameter("Phone");
			String Address=request.getParameter("Address");
			boolean flag=up.UpdatePwd(pwd,Phone,Address,user.getUserID());
			if(flag){
				request.setAttribute("pwdFlag","true");
			}
			sqlsession.commit();
			ServletContext context = getServletContext();
			User a = new User();
			a.setName(user.getName());
			a.setPassword(pwd);
			User user1 = up.getUser(a);
			request.getSession().removeAttribute("User");
			request.getSession().setAttribute("User", user1);
			RequestDispatcher dispatcher = context.getRequestDispatcher("/UserLoginSucessed.jsp");
			dispatcher.forward(request, response);
		} 
		finally {  
			sqlsession.close(); 
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
