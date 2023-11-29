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

@WebServlet("/DeleteMember")
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UserID = request.getParameter("UserID");
		SqlSession sqlsession = GetSession.getSession();
		try {  
			UserMapper up = sqlsession.getMapper(UserMapper.class);
			boolean deleteMember = up.deleteMember(Integer.parseInt(UserID));
			request.getSession().setAttribute("Balance", up.getUserBalance(Integer.parseInt(UserID)));
			System.out.println(deleteMember);
			sqlsession.commit();
			ServletContext context = getServletContext();
			if(deleteMember){
				request.setAttribute("msg","注销成功");
			}
			RequestDispatcher dispatcher = context.getRequestDispatcher("/deleteUserCard.jsp");
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
