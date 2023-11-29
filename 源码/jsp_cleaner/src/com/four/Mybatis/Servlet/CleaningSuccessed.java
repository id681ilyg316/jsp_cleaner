package com.four.Mybatis.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.four.Mybatis.Mapper.UserMapper;
import com.four.Mybatis.Util.GetSession;


@WebServlet("/CleaningSuccessed")
public class CleaningSuccessed extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String OrderID = request.getParameter("OrderID");
		System.out.println(OrderID);
		SqlSession sqlsession = GetSession.getSession();
		try {			
			UserMapper up = sqlsession.getMapper(UserMapper.class);
			boolean flag = up.setDetermined(Integer.parseInt(OrderID));
			sqlsession.commit();
			System.out.println(flag);
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/UnWashedRecords.jsp");
			dispatcher.forward(request, response);
		} finally {
			sqlsession.close();
		}				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
