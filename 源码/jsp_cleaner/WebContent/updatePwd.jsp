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
<title>修改密码</title>
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
	  	background-color: gray;
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
   
   input[type="password"]{
   	width:300px;
   	height:40px;
   	font-size: 80%;
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

</style>
</head>
<body>
	 <div class ="Header">
	 	<div class="login">干洗店</div>
	 </div>
	 <div class="handle">
	 	<form action="" id="form">
			<div>
				电话号码:<input type="text" name="Phone" id="Phone" value="${sessionScope.User.phone}"/>
			</div>
			<div>
				家庭住址:<input type="text" name="Address" id="address" value="${sessionScope.User.adderss}"/>
			</div>
	 		<div>
	 			修改密码:<input type="password" name="pwd" id="pwd" value="${sessionScope.User.password}"/>
	 		</div>
	 		<div>
	 			重输密码:<input type="password" id="pwd1" value="${sessionScope.User.password}"/>
	 		</div>
	 		<div style="text-align: center;">
	 			<input type="submit" value="确认" style="width: 125px;" onclick="return yanzheng()">
				<input type="button" value="返回" style="width: 125px;height: 40px;margin: 0 auto;font-size: 1.0em;" onclick="history.go(-1);">
	 		</div>
	 	</form>
	 </div>
	 <%--<div class="footer">

	 </div>--%>
<script type="text/javascript">
	function yanzheng() {
	    var pwd=document.getElementById("pwd").value;
        var pwd1=document.getElementById("pwd1").value;
	    if(pwd==null||pwd1==null||pwd==""||pwd1==""){
	        alert("请输入密码");
		}else if(pwd!=pwd1){
	        alert("两次输入密码不一致");
		}else {
	        var form=document.getElementById("form");
            document.getElementById("form").action="UpdatePwd";
            form.submit();
		}
    }
</script>
</body>
</html>