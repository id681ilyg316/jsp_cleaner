package com.four.Mybatis.Servlet;

import com.four.Mybatis.Bean.Cloth;
import com.four.Mybatis.Bean.Order;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/SubmitOrder")
public class SubmitOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		User user = (User)request.getSession().getAttribute("User");
		double sum = 0;
		String[] cloths = request.getParameterValues("cloth");
		String[] prices = request.getParameterValues("price");
		String[] types = request.getParameterValues("type");
		List<Cloth> cloths2 = new ArrayList<Cloth>();
		StringBuffer details=new StringBuffer("");
		for(int i =0; i < cloths.length;i++) {
			sum += Double.parseDouble(cloths[i])*Double.parseDouble(prices[i]);
			System.out.println(cloths.length+":"+sum);
			if(0 != Double.parseDouble(cloths[i])*Double.parseDouble(prices[i])) {
				Cloth cloth = new Cloth(user.getUserID(),types[i],
						Double.parseDouble(prices[i]), Integer.parseInt(cloths[i]));
				cloths2.add(cloth);
				details.append("[类型："+types[i]+"/单价："+prices[i]+"/数量："+cloths[i]+"]<br/>");
			}			
		}	
		System.out.println(cloths2.size());
		SqlSession sqlsession = GetSession.getSession();
		try {			
			UserMapper up = sqlsession.getMapper(UserMapper.class);
			//判断是否为会员
			if(up.determineUserMember(user.getUserID()) == 0) {
				//检查余额
				if(sum < up.getUserBalance(user.getUserID())) {
					Order order = new Order();
					order.setUserID(user.getUserID());//设置UserID
					order.setCost(sum);//设置总花费
					order.setIsDetermined(1);//设置未洗涤
					order.setDetails(details.toString());//设置详情
					
					Date now = new Date(); 
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");  //可以方便地修改日期格式
					String time = dateFormat.format( now ); 
					System.out.println(time);
					order.setDataTime(time);//设置当前时间
					System.out.println(order);	
					//修改余额
					up.updateUserBalance(up.getUserBalance(user.getUserID())-sum, user.getUserID());
					//提交订单
					boolean flag = up.addOrder(order);					
					sqlsession.commit();
					System.out.println(flag);
					ServletContext context = getServletContext();
					RequestDispatcher dispatcher = context.getRequestDispatcher("/MyOrders.jsp");
					dispatcher.forward(request, response);
				}
				else {
					ServletContext context = getServletContext();
					RequestDispatcher dispatcher = context.getRequestDispatcher("/UserLoginSucessed.jsp");
					dispatcher.forward(request, response);
				}
			
			}
			else {
				sum = sum * 0.8;
				//检查余额
				if(sum < up.getUserBalance(user.getUserID())) {
					Order order = new Order();
					order.setUserID(user.getUserID());//设置UserID
					order.setCost(sum);//设置总花费
					order.setIsDetermined(1);//设置未洗涤
					Date now = new Date(); 
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");//可以方便地修改日期格式
					String time = dateFormat.format( now ); 
					order.setDetails(details.toString());//设置详情
					order.setDataTime(time);//设置当前时间
					System.out.println(order);	
					//修改余额
					up.updateUserBalance(up.getUserBalance(user.getUserID())-sum, user.getUserID());
					//提交订单
					boolean flag = up.addOrder(order);
					sqlsession.commit();
					System.out.println(flag);
					ServletContext context = getServletContext();
					RequestDispatcher dispatcher = context.getRequestDispatcher("/MyOrders.jsp");
					dispatcher.forward(request, response);
				}
				else {
					ServletContext context = getServletContext();
					RequestDispatcher dispatcher = context.getRequestDispatcher("/UserLoginSucessed.jsp");
					dispatcher.forward(request, response);
				}
			}
			
		} finally {
			sqlsession.close();
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
