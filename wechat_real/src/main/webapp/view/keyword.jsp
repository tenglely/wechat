<%@page import="com.wechat.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>关键词屏蔽管理</title>
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

	<div class="modal fade" id="add_keyword" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">添加需屏蔽关键词</h4>
	      </div>
	      <div class="modal-body">
	      	<input type="text" id="word" class="form-control" placeholder="添加需屏蔽关键词">	
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="btn_add_keyword">添加</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="modal fade" id="see_keyword" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">当前所有需被屏蔽的关键词</h4>
	      </div>
	      <div class="modal-body">
	      	<center>
	      		<textarea rows="10" cols="50" id="tt"></textarea>
	      	</center>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	      </div>
	    </div>
	  </div>
	</div>
	
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
					 <a class="list-group-item" href="${APP_PATH}/index.jsp">
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
					 <a class="list-group-item active" href="${APP_PATH}/view/keyword.jsp">
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
				  		<a>
				  		<span class="text_1">当前关键词</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  		<span class="text_2">55个</span>
				  		</a>
				  	</div>
				  	<div class="box col-md-3" style="margin-left: 100px;background-image:url('${APP_PATH}/image/p01.jpg') ;">
				  		<br>&nbsp;&nbsp;&nbsp;&nbsp;
				  		<span class="text_1">已拦截屏蔽</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  		<span class="text_2">128次</span>
				  	</div>
				  	<div class="col-md-1" style="margin-left: 100px;">
				  		<a id="add">
				  			<img alt="添加" src="${APP_PATH}/image/添加.png" style="height: 100px;">
				  			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  			添加
				  		</a>
				  	</div>
				  	<div class="col-md-1" style="margin-left: 100px;">
				  		<a id="see">
				  			<img alt="查看" src="${APP_PATH}/image/查看.png" style="height: 100px;">
				  			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  			查看
				  		</a>
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
	          name: "月屏蔽数",
	          values: [21,23,26,23,33]
	        },
	    
	      ],
	    },
	    title: "2019年关键词月屏蔽数据(单位：次)",
	    type: 'bar', // or 'bar', 'line', 'pie', 'percentage'
	    height: 250,
	    colors: ['light-blue']
	  });
	let chart1 = new Chart( "#chart1", { // or DOM element
	    data: {
	      labels: ['1时','2时','3时','4时','5时',
	    	  '6时','7时','8时','9时','10时','11时','12时',
	    	  '13时','14时','15时','16时','17时','18时','19时','20时',
	    	  '21时','22时','23时','24时'],

	      datasets: [
	        {
	          name: "小时屏蔽数", chartType: 'line',
	          values: ['0','0','0','0','0','0',
	        	  '0','2','0','1','3','0',
	        	  '0','0','4','0','2','0',
	        	  '0','0','0','0','0','0',]
	        },
	      
	      ],
	    },
	    lineOptions: {
	        regionFill: 1 // default: 0
	    },
	    title: "今日实时屏蔽数据(单位：次)",
	    type: 'axis-mixed', // or 'bar', 'line', 'pie', 'percentage'
	    height: 250,
	    colors: ['light-blue']
	  });
	
	$("#add").click(function(){
		$("#add_keyword").modal();
	});	
	
	$("#see").click(function(){
		$("#tt").empty();
		$("#see_keyword").modal();
		$.ajax({
			url:"${APP_PATH}/seekeyword",
			type:"GET",
			success:function(result){
				var text=result.extend.keyword;
				$("#tt").append(text);
			}
		});
	});	
	
	$("#btn_add_keyword").click(function(){
		var word=$("#word").val();
		alert(word);
		$.ajax({
			url:"${APP_PATH}/addkeyword",
			type:"GET",
			data:"word="+word,
			success:function(result){
				$("#add_keyword").modal("hide");
				alert("添加成功");
			}
		});
	});	
	</script>
</body>
</html>