<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	margin-right: 20px;
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
  	background-color: gray;
  	border-radius:5px; 
  	text-align: center;
  	line-height: 100px;
  }
</style>
</head>
<body>
	 <div class ="Header">
	 	<div class="login">干洗店</div>
	 </div>
	 <div class="main">
	 	<ul>
	 		<a href="deleteUserCard.jsp"><li>注销会员卡</li></a>
	 		<a href="UnWashedRecords.jsp"><li>未洗涤记录</li></a>
	 		<a href="WashedRecords.jsp"><li>已洗涤记录</li></a>
	 		<a href="BenefitManagement.jsp"><li>收益管理</li></a>
			<a href="ChangeClothPrice.jsp"><li>调整价格</li></a>
			<a href="Starff.jsp"><li>员工管理</li></a>
			<a href="index.jsp"><li>退出登录</li></a>
	 	</ul>
	 </div>
	 <div class="Handle">
	 	
	 </div>
	 <%--<div class="footer">

	 </div>--%>
</body>
</html>