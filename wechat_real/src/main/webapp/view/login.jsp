<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录界面</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link href="${APP_PATH}/css/login.css" rel='stylesheet' type='text/css' media="all" />
</head>
<body>
	<div class="log">
	<div class="content1">
		<h2>厨来了</h2>
		<%  String date=(String)session.getAttribute("date");
			if(date==null||date=="")
				date="";
		%>
		<form action="${APP_PATH}/userlogin" method="post">
			<label style="font-size: 18px;color: red;"><%=date %></label>
			<input type="text" name="uname" placeholder="管理员账号">
			<input type="password" name="openid" placeholder="密码" >
			<div class="button-row">
				<input type="submit" class="sign-in" value="登录">
				<input type="reset" class="reset" value="重置">
			</div>
		</form>
	</div>
	</div>
</body>
</html>