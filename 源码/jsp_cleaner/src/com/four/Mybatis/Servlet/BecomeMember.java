package com.four.Mybatis.Servlet;

import com.four.Mybatis.Bean.Card;
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

@WebServlet("/BecomeMember")
public class BecomeMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("User");
		SqlSession sqlsession = GetSession.getSession();
		try {  
			UserMapper up = sqlsession.getMapper(UserMapper.class);
			Card card=new Card();
			card.setBalance(200.0);
			card.setUserID(user.getUserID());
			card.setIsUsed(0);
			up.addUserCard(card);
			sqlsession.commit();
			Double userBalance = up.getUserBalance(user.getUserID());
			boolean registerMember = up.RegisterMember(user.getUserID());
			if(registerMember){
				request.getSession().setAttribute("UserBalance",200.0);
				request.getSession().removeAttribute("User");
				User u=new User();
				u.setName(user.getName());
				u.setPassword(user.getPassword());
				User user1=up.getUser(u);
				request.getSession().setAttribute("User", user1);
			}
			/*boolean registerMember = up.RegisterMember(user.getUserID(),userBalance+200);*/
			System.out.println(registerMember);
			sqlsession.commit();
			ServletContext context = getServletContext();
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
