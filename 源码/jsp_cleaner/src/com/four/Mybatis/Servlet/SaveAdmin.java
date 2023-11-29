package com.four.Mybatis.Servlet;

import com.four.Mybatis.Bean.Admin;
import com.four.Mybatis.Mapper.UserMapper;
import com.four.Mybatis.Util.GetSession;
import org.apache.ibatis.session.SqlSession;
import sun.nio.cs.US_ASCII;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SaveAdmin")
public class SaveAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String AdminId = request.getParameter("AdminID");
		SqlSession sqlsession = GetSession.getSession();
		try {  
			UserMapper up = sqlsession.getMapper(UserMapper.class);
			String UserName=request.getParameter("UserName");
			String password=request.getParameter("password");
			String state=request.getParameter("state");
			String realName=request.getParameter("realName");
			if(AdminId!=null&&AdminId!=""){
				Admin admin=up.getOneAdmin(Integer.parseInt(AdminId));
				if(UserName!=null&&UserName!=""){
					admin.setUserName(UserName);
				}
				if(password!=null&&password!=""){
					admin.setPassword(password);
				}
				if(state!=null&&state!=""){
					admin.setState(state);
				}
				if(realName!=null&&realName!=""){
					admin.setRealName(realName);
				}
				boolean flag=up.updateAdmin(admin);
				System.out.println(flag);
			}else {
				Admin admin=new Admin();
				admin.setUserName(UserName);
				admin.setPassword(password);
				admin.setRealName(realName);
				admin.setState(state);
				boolean flag=up.addAdmin(admin);
				System.out.println(flag);
			}
			sqlsession.commit();
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/Starff.jsp");
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
