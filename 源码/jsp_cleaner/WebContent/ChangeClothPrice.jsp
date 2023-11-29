<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.four.Mybatis.Bean.Cloth" %>
<%@page import="com.four.Mybatis.Util.GetSession,
				org.apache.ibatis.session.SqlSession,
				com.four.Mybatis.Mapper.UserMapper,
				java.util.*,
				com.four.Mybatis.Bean.User,
				com.four.Mybatis.Bean.Order" %>
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
	.main{
		height:60px;
		width: 100%;
		margin-bottom: 20px;
	}
	.main ul{
		margin-left: 10px;
		margin-right: 10px;
	}
	.main ul li{
		width: 12%;
		height: 50px;
		line-height: 50px;
		font-size: 1.2em;
		float: left;
		border: 2px solid gray;
		border-radius: 2px;
		text-align: center;
		margin-right: 10px;
		color: black;
	}
	.content{
		text-align: center;
		margin-left: 50px;
	}
	.table{
		font-size: 1.5em;	
		text-align: center;	
	}
	.table input{
		font-family:黑体;
	}
	
	.table td, th{
		width: 100px;
		padding: 5px;
	}
	.footer{
	  	position:absolute;
	  	right:0px;
	  	top:550px;
	  	width:100%;
	  	height:100px;
	  	background-color: gray;
	  	border-radius:5px; 
	  	text-align: center;
	  	line-height: 100px;
   }
	input[type="text"]{
		width:50px;
	}
</style>
</head>
<body>
	 <div class ="Header">
	 	<div class="login">干洗店</div>
	 </div>
	  <div class="main">
	 	<ul>
			<c:if test="${Admin.state=='管理员'}">
	 		<a href="deleteUserCard.jsp"><li>注销会员卡</li></a>
			</c:if>
	 		<a href="UnWashedRecords.jsp"><li>未洗涤记录</li></a>
	 		<a href="WashedRecords.jsp"><li>已洗涤记录</li></a>
			<c:if test="${Admin.state=='管理员'}">
	 		<a href="BenefitManagement.jsp"><li>收益管理</li></a>
	 		<a href="ChangeClothPrice.jsp"><li>调整价格</li></a>
			<a href="Starff.jsp"><li>员工管理</li></a>
			</c:if>
			<a href="index.jsp"><li>退出登录</li></a>
	 	</ul>
	 </div>
	 <div class ="content">
	 <form action="ChanggePrice" method="post">
		 <%
		SqlSession sqlsession = GetSession.getSession();
		try {  
			UserMapper up = sqlsession.getMapper(UserMapper.class);
			Cloth cloth1 = up.getCloth(1);
			Cloth cloth2 = up.getCloth(2);
			Cloth cloth3 = up.getCloth(3);
			Cloth cloth4 = up.getCloth(4);
			Cloth cloth5 = up.getCloth(5);
		%>
	 	<table class="table" >
			<tr>
			  <th>类型</th>
			  <th>价格</th>		  
			</tr>
			<tr>
			  <td><%=cloth1.getC_type() %></td>
			  <td><input type="text"   name = "price" value="<%=cloth1.getPrice() %>"></td>
			</tr>
			<tr>
			  <td><%=cloth2.getC_type() %></td>
			  <td><input type="text"   name = "price" value="<%=cloth2.getPrice() %>"></td>
			</tr>
			<tr>
			  <td><%=cloth3.getC_type() %></td>
			  <td><input type="text"   name = "price" value="<%=cloth3.getPrice() %>"></td>		 
			</tr>
			<tr>
			  <td><%=cloth4.getC_type() %></td>
			  <td><input type="text" name = "price" value="<%=cloth4.getPrice() %>"></td>
			</tr>
			<tr>
			  <td><%=cloth5.getC_type() %></td>
			  <td><input type="text"   name ="price" value="<%=cloth5.getPrice() %>"></td>
			  <td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			  <td><input type="submit" value="修改价格" onclick="run()"></td>
			</tr>
			</table>
			<%} 
			finally {  
				sqlsession.close(); 
			} %>
		</form>
	 </div>	 
	 <%--<div class="footer">

	 </div>--%>
	 <script type="text/javascript">
	 	function run() {
			alert("价格修改成功！");
		}
	 </script>
</body>
</html>