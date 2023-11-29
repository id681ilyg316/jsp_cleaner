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


@WebServlet("/ShowAllCostByTome")
public class ShowAllCostByTome extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Datetime = request.getParameter("DateTime");
		SqlSession sqlsession = GetSession.getSession();
		try {  
			UserMapper up = sqlsession.getMapper(UserMapper.class);
			Double ordersByDatetime = up.getOrdersByDatetime(Datetime);
			request.getSession().setAttribute("AllIncome", ordersByDatetime);
			System.out.println(ordersByDatetime);
			sqlsession.commit();
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/BenefitManagement.jsp");
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
