<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.four.Mybatis.Bean.Cloth" %>
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
	.Header .mem1{
		color:black;			
		position: absolute;
		top:20px;
		right: 50px;	
		font-size: 1.5em;
	}
	.Header .mem2{
		color:black;			
		position: absolute;
		top:20px;
		right: 150px;	
		font-size: 1.5em;
	}
	.Header .mem3{
		color:black;
		position: absolute;
		top:20px;
		right: 250px;
		font-size: 1.5em;
	}

	.Header .mem4{
		color:black;
		position: absolute;
		top:20px;
		right: 350px;
		font-size: 1.5em;
	}

	.Header .mem5{
		color:black;
		position: absolute;
		top:20px;
		right: 450px;
		font-size: 1.5em;
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
	}
	.content{
		text-align: center;
		margin-left: 50px;
	}
	.table{
		font-size: 1.5em;		
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
		 <%
			 User user= (User) session.getAttribute("User");
			 if(user.getIsMember()!=1){%>
			     <a href="Handlemembers.jsp" class="mem4">办理会员</a>
		 <%	 }%>
		 <a href="MyOrders.jsp" class="mem5">我的订单</a>
		 <a href="Recharge.jsp" class="mem3">余额充值</a>
		 <a href="updatePwd.jsp" class="mem2">修改信息</a>
		 <a href="index.jsp" class="mem1">退出登录</a>
	 </div>
	 <div class ="content">
	 <form action="SubmitOrder" name="form1" onsubmit="return check(this)">
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
			  <th>数量</th>
			  <th>价格</th>	
			  <th>洗涤数量</th>		  
			</tr>
			<tr>
			  <td><%=cloth1.getC_type() %></td>
			  <td><%=cloth1.getC_number()%>件</td>
			  <td><%=cloth1.getPrice() %></td>
			  <td><input type="text"  name = "cloth" value="0"></td>
			  <td><input type="hidden"  name = "type" value="<%=cloth1.getC_type() %>"></td>
			  <td><input type="hidden" name="price" value="<%=cloth1.getPrice() %>"></td>
			</tr>

			<tr>
			  <td><%=cloth2.getC_type() %></td>
			  <td><%=cloth2.getC_number()%>件</td>
			  <td><%=cloth2.getPrice() %></td>
			  <td><input type="text"  name = "cloth" value="0"></td>
			   <td><input type="hidden"  name = "type" value="<%=cloth2.getC_type() %>"></td>
			  <td><input type="hidden" name="price" value="<%=cloth2.getPrice() %>"></td>
			</tr>
			<tr>
			  <td><%=cloth3.getC_type() %></td>
			  <td><%=cloth3.getC_number()%>件</td>
			  <td><%=cloth3.getPrice() %></td>
			  <td><input type="text"   name = "cloth" value="0"></td>
			   <td><input type="hidden"  name = "type" value="<%=cloth3.getC_type() %>"></td>
			  <td><input type="hidden" name="price" value="<%=cloth3.getPrice() %>"></td>
			</tr>
			<tr>
			  <td><%=cloth4.getC_type() %></td>
			  <td><%=cloth4.getC_number()%>件</td>
			  <td><%=cloth4.getPrice() %></td>
			  <td><input type="text"   name = "cloth" value="0"></td>
			   <td><input type="hidden"  name = "type" value="<%=cloth4.getC_type() %>"></td>
			  <td><input type="hidden" name="price" value="<%=cloth4.getPrice() %>"></td>
			</tr>
			<tr>
			  <td><%=cloth5.getC_type() %></td>
			  <td><%=cloth5.getC_number()%>件</td>
			  <td><%=cloth5.getPrice() %></td>
			  <td><input type="text"  name = "cloth" value="0"></td>
			   <td><input type="hidden"  name = "type" value="<%=cloth5.getC_type() %>"></td>
			  <td><input type="hidden" name="price" value="<%=cloth5.getPrice() %>"></td>
			 <td></td><td></td><td></td>
			 <td><input type="submit" value="提交订单" ></td>
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
	 	function check() {
	 		var pattern = /^[0-9]+$/;
	 	    var dp =document.getElementsByName("cloth");
	 	    var i = 0;
	 	    for (;i<dp.length;i++){
				if(!pattern.test(dp[i].value)){					
					break;
				} 				
			}
	 	    if(i == dp.length){
	 	    	return true;
	 	    }
	 	    else{
	 	    	alert("输入只能是数字!"+i);
				return false;
	 	    }
	 	    
		}
	 </script>
</body>
<%
	PrintWriter out1=response.getWriter();
	String flag= (String) request.getAttribute("pwdFlag");
	if(flag=="true"){
		out1.println("<script type='text/javascript'>alert('修改成功');</script>");
	}


%>


</html>