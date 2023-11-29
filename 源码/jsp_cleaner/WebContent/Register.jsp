<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>洗衣店管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="CSS/Login.css">
<style type="text/css">
body{
	background-image: url("Image/1.jpg");
	background-size:100%  100%;
	
}
</style>
</head>
  
<body>
	<div class = "login">
    	<h3>用户注册</h3>
    	<form action = "UserRegister" method = "post">
    		<div class = "username">
    			用户名:<input type ="text" name = "name" >
		    </div>
		    <div class = "username">
    			密码:<input type ="password" name = "pwd">
		    </div>
		     <div class = "username">
    			 电话:<input type ="text" name = "phone" >
		    </div>
		     <div class = "username">
    			 地址:<input type ="text" name = "Address" >
		    </div>
		    <div class = "btn">
		    	<input type = "submit" value = "注册">
		    </div>
     	</form>   	
    </div>  
</html>
