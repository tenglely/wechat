<%@page import="com.wechat.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.3.1.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/frappe-charts@1.0.0/dist/frappe-charts.min.iife.js"></script>
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
	.box{
		border-radius:5px 5px 5px 5px;  
		width:200px; 
		height:110px; 
		margin:0 auto;
		box-shadow:4px 0px  5px 5px #aaa;
	}
	.text_1{
		font-family: STHupo ;
		font-size:25px;
		color: #F0FFF0;
	}
	.text_2{
		font-family: STHupo ;
		font-size:30px;
		color: 	#FFF5EE;
	}
</style>
</head>
<body>
	<%
		if(session.getAttribute("login")==null||session.getAttribute("login")==""){
			request.getRequestDispatcher("/view/login.jsp").forward(request, response);
		}
		User user=(User)session.getAttribute("login");
	%>
	<div class="container-fluid">
		<div class="row top">
			<div class="col-lg-12">
				<h4 align="right">
					欢迎管理员:
					<a href="${APP_PATH}/view/admin.jsp?<%=user.getUid()%>">
					<img class="img_manager img-circle" src="${APP_PATH}/image/<%=user.getPurl() %>" alt="photo">
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
					 <a class="list-group-item active" href="${APP_PATH}/index.jsp">
					 	<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					 	首页
					 </a>
					 <a class="list-group-item" href="${APP_PATH}/view/addGreens.jsp">
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
					 <a class="list-group-item" href="${APP_PATH}/view/keyword.jsp">
						<span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span>
						 关键词屏蔽
					 </a>
				</div>
			</div>
			<div class="col-md-10">
				<br>
				<div class="container">
				  <div class="row">
				  	<div class="box col-md-3" style="margin-left: 100px;background-image:url('${APP_PATH}/image/p01.jpg') ;">
				  		<br>&nbsp;&nbsp;&nbsp;&nbsp;
				  		<span class="text_1">当前菜品数</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  		<span class="text_2">4755</span>
				  	</div>
				  	<div class="box col-md-3" style="margin-left: 100px;background-image:url('${APP_PATH}/image/p01.jpg') ;">
				  		<br>&nbsp;&nbsp;&nbsp;&nbsp;
				  		<span class="text_1">当前用户量</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  		<span class="text_2">1004</span>
				  	</div>
				  	<div class="box col-md-3" style="margin-left: 100px;background-image:url('${APP_PATH}/image/p01.jpg') ;">
				  		<br>&nbsp;&nbsp;&nbsp;&nbsp;
				  		<span class="text_1">当前评论数</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  		<span class="text_2">52062</span>
				  	</div>
				  </div>
				  
				  <!-- 图表 -->
				  <div class="row">
				  	<div id="chart" style="width: 550px;" class="col-md-4"> 
				  	</div>
				  	<div id="chart1" class="col-md-4" style="width: 550px;margin-left: 10px;"> 
				  	</div>
				  </div>
				  
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	let chart = new Chart( "#chart", { // or DOM element
	    data: {
	      labels: ['1月','2月','3月','4月','5月'],

	      datasets: [
	        {
	          name: "月增长数", chartType: 'line',
	          values: [57,142,203,233,426]
	        },
	        {
	            name: "平均每日用户增长数", chartType: 'bar',
	            values: [2,4.7,6.8,7.8,14.2]
	          },
	      ],
	    },
	    lineOptions: {
	        regionFill: 1 // default: 0
	    },
	    title: "2019年用户月增长数据(单位：人)",
	    type: 'axis-mixed', // or 'bar', 'line', 'pie', 'percentage'
	    height: 250,
	    colors: ['light-blue','pink']
	  });
	let chart1 = new Chart( "#chart1", { // or DOM element
	    data: {
	      labels: ['1','2','3','4','5','5',
	    	  '6','7','8','9','10','11','12',
	    	  '13','14','15','16','17','18','`9','20',
	    	  '21','22','23','24','25','26','27','28','29','30'],

	      datasets: [
	        {
	          name: "日活跃数", chartType: 'line',
	          values: [57,142,203,233,426,
	        	  560,540,578,610,660,
	        	  688,675,640,655,690,
	        	  699,651,682,686,695,
	        	  701,710,720,733,745,
	        	  732,766,764,736,788]
	        },
	        {
		          name: "日评论数", chartType: 'bar',
		          values: [37,102,103,133,226,
		        	  260,240,278,310,460,
		        	  388,375,340,455,390,
		        	  399,351,382,386,395,
		        	  401,410,420,433,445,
		        	  432,366,464,436,488]
		        },
	      ],
	    },
	    lineOptions: {
	        regionFill: 1 // default: 0
	    },
	    title: "4月日活跃数据(单位：人)",
	    type: 'axis-mixed', // or 'bar', 'line', 'pie', 'percentage'
	    height: 250,
	    colors: ['light-blue','pink']
	  });
	</script>
</body>
</html>