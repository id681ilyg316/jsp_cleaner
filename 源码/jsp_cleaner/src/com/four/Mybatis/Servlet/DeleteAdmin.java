package com.four.Mybatis.Servlet;

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

@WebServlet("/DeleteAdmin")
public class DeleteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String AdminId = request.getParameter("AdminID");
		SqlSession sqlsession = GetSession.getSession();
		try {  
			UserMapper up = sqlsession.getMapper(UserMapper.class);
			boolean deleteAdmin = up.deleteAdmin(Integer.parseInt(AdminId));
			System.out.println(deleteAdmin);
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
