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
<title>Insert title here</title>
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
   .handle{
   	height:600px;
   	width:600px;
   	margin: 80px auto;
   	font-size: 2em;
   }
   .handle div{
   	margin: 10px;
   }
   
   input[type="text"]{
   	width:300px;
   	height:40px;
   	font-size: 80%;
   }
   
   input[type="submit"]{
   	width:550px;
   	height:40px;
   	margin: 0 auto;
   	font-size: 1.0em;
   }
}
</style>
</head>
<body>
	 <div class ="Header">
	 	<div class="login">干洗店</div>
	 </div>
	 <div class="handle">
	 	<form action="Recharge" method="post">
	 		<div>
	 			充值金额:<input type="text" name="Balance" >
	 		</div>
	 		<div>
	 			用户余额:<input type="text" value="<%=session.getAttribute("UserBalance") %>" disabled="disabled">
	 		</div>
	 		<div style="text-align: center;">
	 			<input type="submit" value="充值" style="width: 125px;">
				<input type="button" value="返回" style="width: 125px;height: 40px;margin: 0 auto;font-size: 1.0em;" onclick="history.go(-1);">
	 		</div>
	 	</form>
	 </div>
	 <%--<div class="footer">

	 </div>--%>
</body>

<%
	PrintWriter out1=response.getWriter();
	String rechargeFlag= (String) request.getAttribute("rechargeFlag");
	if(rechargeFlag=="true"){
		out1.println("<script type='text/javascript'>alert('充值成功');</script>");
	}
%>
</html>