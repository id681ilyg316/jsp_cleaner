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

import com.four.Mybatis.Bean.User;
import com.four.Mybatis.Mapper.UserMapper;
import com.four.Mybatis.Util.GetSession;

@WebServlet("/Recharge")
public class Recharge extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("User");
		Double Balance = Double.parseDouble(request.getParameter("Balance"));
		SqlSession sqlsession = GetSession.getSession();
		try {  
			UserMapper up = sqlsession.getMapper(UserMapper.class);
			Double userBalance = up.getUserBalance(user.getUserID());
			request.getSession().setAttribute("UserBalance", userBalance+Balance);
			boolean addUserBalance = up.AddUserBalance(userBalance+Balance, user.getUserID());
			if(addUserBalance){
				request.setAttribute("rechargeFlag","true");
			}
			System.out.println(addUserBalance);
			sqlsession.commit();
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/Recharge.jsp");
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
