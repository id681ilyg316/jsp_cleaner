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

import com.four.Mybatis.Bean.Cloth;
import com.four.Mybatis.Mapper.UserMapper;
import com.four.Mybatis.Util.GetSession;

@WebServlet("/ChanggePrice")
public class ChanggePrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlsession = GetSession.getSession();
		String[] prices = request.getParameterValues("price");
		try {
			for(int i = 0; i < prices.length;i++) {
				Cloth cloth = new Cloth();
				cloth.setClothID(i+1);
				cloth.setPrice(Double.parseDouble(prices[i]));		
				UserMapper up = sqlsession.getMapper(UserMapper.class);
				boolean setClothPrice = up.setClothPrice(cloth);
				System.out.println(setClothPrice);
				sqlsession.commit();								
			}
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/ChangeClothPrice.jsp");
			dispatcher.forward(request, response);		
		} finally {
			sqlsession.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
