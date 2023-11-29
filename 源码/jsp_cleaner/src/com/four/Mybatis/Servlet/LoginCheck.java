package com.four.Mybatis.Servlet;

import com.four.Mybatis.Bean.Admin;
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

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession session = GetSession.getSession();
		String name = (String) request.getParameter("name");
		String password = (String)request.getParameter("pwd");
		String Character = (String)request.getParameter("char");
		String msg="账号或密码错误";
		System.out.println(Character);
		if(Character.equals("Manager")||Character.equals("Starff")) {
			try {  
				Admin a = new Admin();
				a.setUserName(name);
				a.setPassword(password);
				SqlSession sqlsession = GetSession.getSession();
				UserMapper up = sqlsession.getMapper(UserMapper.class);
				Admin admin = up.getAdmin(a);
				ServletContext context = getServletContext();
				if(admin != null) {
					request.getSession().setAttribute("Admin", admin);
					RequestDispatcher dispatcher = context.getRequestDispatcher("/AdminLoginSucessed.jsp");
					dispatcher.forward(request, response);
					System.out.println(admin);
				}
				else {
					request.setAttribute("msg",msg);
					RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}
			}
			finally{
				session.close(); 
			}		
		}
		else {
			try {  
				User a = new User();
				a.setName(name);
				a.setPassword(password);
				SqlSession sqlsession = GetSession.getSession();
				UserMapper up = sqlsession.getMapper(UserMapper.class);
				User user = up.getUser(a);
				request.getSession().setAttribute("User", user);
				ServletContext context = getServletContext();				
				if(user != null) {
					if(user.getIsMember()==1){
						double balance=up.getUserBalance(user.getUserID());
						request.getSession().setAttribute("UserBalance",balance);
					}
					RequestDispatcher dispatcher = context.getRequestDispatcher("/UserLoginSucessed.jsp");
					dispatcher.forward(request, response);
					System.out.println(user);
				}
				else {
					request.setAttribute("msg",msg);
					RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}
			}
			finally{
				session.close(); 
			}		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
