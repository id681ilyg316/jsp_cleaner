<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   .handle{
   	height:500px;
   	width:500px;
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
   	width:450px;
   	height:40px;
   	margin: 0 auto;
   	font-size: 1.0em;
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
	 <div class="handle">
	 	<form action="ShowAllCostByTome" method="post">
	 		<div>
	 			时间日期:<input type="text" name="DateTime" >
	 		</div>
	 		<div>
	 			&nbsp;&nbsp;总收入:<input type="text" value=<%=session.getAttribute("AllIncome")%> disabled="disabled">
	 		</div>
	 		<div>
	 			<input type="submit" value="搜索" onclick="run()">
	 		</div>
	 	</form>
	 </div>
	 <%--<div class="footer">

	 </div>--%>
</body>
</html>