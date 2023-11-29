<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.four.Mybatis.Util.GetSession,
				org.apache.ibatis.session.SqlSession,
				com.four.Mybatis.Mapper.UserMapper,
				java.util.*,
				com.four.Mybatis.Bean.User,
				com.four.Mybatis.Bean.Order" %>
<%@ page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<style type="text/css">
	body{
		background-color: #dddeed;
		background: #DAE2F8;  /* fallback for old browsers */ background: -webkit-linear-gradient(to right, #D6A4A4, #DAE2F8);  /* Chrome 10-25, Safari 5.1-6 */ background: linear-gradient(to right, #D6A4A4, #DAE2F8); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
		background-size:100%  100%;
	}
	*{
		
		text-decoration: none;
		list-style: none;
		font-family:隶书;
	}
	.Header{		
		height: 50px;
		width: 100%;	
	}
	.login{
		text-align: center;
		font-size: 2.5em;
		border-bottom: 5px solid black;
		border-radius: 5px;		
	}
	.main{
		height:60px;
		width: 100%;
		margin-bottom: 20px;
	}
	.main ul li{
		width: 12%;
		height: 50px;
		line-height: 50px;
		font-size: 1.3em;
		float: left;
		border: 2px solid gray;
		border-radius: 2px;
		text-align: center;
		margin-right: 10px;
		color: black;
	}
	.main ul li:hover{
		background-color: #7b8b8c;
	}
	.footer{
	  	position:absolute;
	  	right:0px;
	  	top:550px;
	  	width:100%;
	  	height:100px;
	  	background-color: gray;rders
	  	border-radius:5px; 
	  	text-align: center;
	  	line-height: 100px;
   }
   .table{
   		font-size: 1.5em;
   		text-align: center;
   		margin: 0 auto;
   }
   .Handle a{
   	border: 1px solid gray;
   	border-radius: 5px;
   	font-size: 0.8em;
   	background-color: gray;
   	color: black;
   }
</style>
</head>
<body>
	 <div class ="Header">
	 	<div class="login">干洗店&nbsp;&nbsp;
			<a href="javascript:void(0);" onclick="history.go(-1);">返回</a>
		</div>
	 </div>
	 <div class="main">
	 </div>
	 <div class="Handle">
	 	 <table class="table" >
			<tr>
			  <th></th>
			  <th>用户名</th>
			  <th></th>
			  <th>手机号码</th>
			  <th></th>
			  <th>下单日期</th>	
			  <th></th>
			  <th>总费用</th>
			  <th></th>
			  <th>详情</th>
			  <td>状态</td>
			</tr>
			 <%
				PrintWriter out1=response.getWriter();
			 	SqlSession sqlsession = GetSession.getSession();
				try {
					User user1= (User) request.getSession().getAttribute("User");
					UserMapper up = sqlsession.getMapper(UserMapper.class);
					List<User> userOrder = up.getMyOrder(user1.getUserID());
					for(User user:userOrder){
						List<Order> orders = user.getOrders();
					  	for(Order order: orders){
			 %>			 
				<tr>
				<td></td>
				<td><%=user1.getName() %></td>
				<td></td>
				<td><%=user1.getPhone() %></td>
				<td></td>	  	
			  	<td><%=order.getDataTime() %></td>
			  	<td></td>
				<td><%=order.getCost() %></td>
				<td></td>
				<td style="text-align: left;"><%=order.getDetails() %></td>
			  	<td>
				  	<%--<a href="CleaningSuccessed?OrderID=<%=order.getOrederID()%>">Success</a>--%>
					<%
						if(order.getIsDetermined()==0){%>

							<span>已洗涤</span>
						<%}
							else {%>
							<span>未洗涤</span>
						<%}
					%>
				 </td>		  		
			</tr>	
			 <%
						}
					}
				} 
				finally {  
					sqlsession.close(); 
				}
			 %>
			
		</table>
	</div>
	 <%--<div class="footer">

	 </div>--%>
</body>
</html>