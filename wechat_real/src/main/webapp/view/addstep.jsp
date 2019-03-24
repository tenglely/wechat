<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加菜品步骤</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.3.1.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<style type="text/css">
	body{
		overflow: hidden;
	}
	.top{
		background-color: 	#A9A9A9;
	}
	.list{
		background-color: #D3D3D3;
		height: 1200px;
	}
	.acolor{
		background-color:#F0FFFF;
		color:#ffffff;
	}
	.img_manager{
		width: 35px;
		height: 35px;
	}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row top">
			<div class="col-lg-12">
				<h4 align="right">
					欢迎管理员:
					<a href="">
					<img class="img_manager img-circle" src="${APP_PATH}/image/manager.jpg" alt="photo">
					</a>
				</h4>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 list">
				<br>
				<div class="list-group" style="width: 100%">
					<a href="#" class="list-group-item disabled">
					 	<span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span>
					  	功能列表
					 </a>
					 <a class="list-group-item" href="${APP_PATH}/index.jsp">
					 	<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					 	首页
					 </a>
					 <a class="list-group-item active" href="${APP_PATH}/view/addGreens.jsp">
					 	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					 	添加菜品
					 </a>
					 <a class="list-group-item" href="${APP_PATH}/view/greensManager.jsp">
					 	<span class="glyphicon glyphicon-book" aria-hidden="true"></span>
					 	菜单信息管理
					 </a>
					 <a class="list-group-item" href="${APP_PATH}/view/userManager.jsp">
					 	<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					 	用户信息管理
					 </a>
					 <a class="list-group-item" href="${APP_PATH}/view/commentManager.jsp">
					 	<span class="glyphicon glyphicon-text-size" aria-hidden="true"></span>
					 	用户评论管理
					 </a>
					 <a class="list-group-item" href="${APP_PATH}/view/postManager.jsp">
						<span class="glyphicon glyphicon-send" aria-hidden="true"></span>
						 分享贴信息管理
					 </a>
				</div>
			</div>
			<div class="col-md-10">
				<br>
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12" id="main" style="background-color: #e3e3e8;height: 850px;">
							<p id="step" style="font-size: 20px;">做菜步骤：${step}</p>
							<form action="${APP_PATH}/addStep" enctype="multipart/form-data" method="post">
								<input type="hidden" name="step" value="${step}">
								<input type="hidden" name="gid" value="${gid}">
								<div class="input-group col-md-6">
									<span class="input-group-addon" style="font-size: 20px;">步骤描述：</span>
									<textarea class="form-control" rows="10" cols="60" name="describe" id="describe"></textarea>
								</div><br>
								<div class="input-group col-md-6">
									<span class="input-group-addon" style="font-size: 20px;">步骤图片：</span>
									<input class="form-control btn btn-info" type="file" name="file">
								</div><br> 
								<div class="input-group col-md-6">
									<span class="input-group-addon" style="font-size: 20px;">做菜定时：</span>
									<input type="text" class="form-control" name="timing" placeholder="时间默认为0分钟">
								</div><br>
								<div class="input-group col-md-6 col-md-offset-2">
									<input type="submit" class="btn btn-primary" value="继续添加下一步">
									&nbsp;&nbsp;&nbsp;&nbsp;
									<a class="btn btn-primary" href="${APP_PATH}/view/greensManager.jsp">结束</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>