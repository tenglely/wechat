<%@page import="com.wechat.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>浏览贴子内容</title>
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
	.mob{
		margin-left: 300px;
		margin-top:10px;
		width: 339px;
		height: 606px;
		overflow-y:auto; 
		overflow-x:auto;
		box-shadow:0px 0px  10px 5px #aaa;
	}
	.td_c{
		border:solid #ccc 1px;
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
					 <a class="list-group-item active" href="${APP_PATH}/view/postManager.jsp">
						<span class="glyphicon glyphicon-send" aria-hidden="true"></span>
						 分享贴信息管理
					 </a>
				</div>
			</div>
			<div class="col-md-10">
				<button class="btn btn-warning btn-sm" onclick="window.history.back(-1);">返回上一页</button>
				<br>
				<input type="hidden" id="pid" value="<%=request.getParameter("pid")%>">
				<div class="mob">
					<table id="seetable">
							
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		//查询贴子数据
		finddata();
	});
	
	//查询贴子数据
	function finddata(){
		var pid=$("#pid").val();
		$.ajax({
			url:"${APP_PATH}/findpostbypid",
			data:"pid="+pid,
			type:"GET",
			success:function(result){
				//放数据到table
				putdata(result);
			}
		});
	}
	
	//放数据到table
	function putdata(result){
		var pfile=$("<img></img>").attr("src","${APP_PATH}/image/"+result.extend.post.pfile)
								  .css("width","333px").css("height","180px");
		var title=$("<td></td>").append(result.extend.post.title)
								.css("font-size","35px");
		var t=$("<img></img>").addClass("img_manager img-circle")
							  .attr("src","${APP_PATH}/image/"+result.extend.post.user.purl);
		var tt=$("<label></label>").append(t)
								   .append("&nbsp;<span style='font-size:15px'>"+result.extend.post.user.uname+"</span>")
								   .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发帖日期:"+result.extend.post.pdate);
		var pdate=$("<td></td>").append(tt)
								.css("font-size","9px");
		
		if(result.extend.post.pfile!=null){
		var pcontent=$("<td></td>").append(pfile)
								   .append("<br><br>")
								   .append(result.extend.post.pcontent)
								   .append("<br><br>")
								   .addClass("td_c")
								   .css("font-size","20px");
		}else{
			var pcontent=$("<td></td>").append(result.extend.post.pcontent)
			   .append("<br><br>")
			   .addClass("td_c")
			   .css("font-size","20px");
		}
		$("<tr></tr>").append(title).appendTo("#seetable");
		$("<tr></tr>").append(pdate).appendTo("#seetable");
		$("<tr></tr>").append(pcontent).appendTo("#seetable");
		var b=$("<td></td>").append("评论").css("font-size","22px").css("background-color","#E8E8E8").css("color","	#FFFAFA");
		$("<tr></tr>").append(b).appendTo("#seetable");
		userComment();
	}
	
	//加载用户评论及用户头像、姓名
	function userComment(){
		var pid=$("#pid").val();
		$.ajax({
			url:"${APP_PATH}/findComment",
			data:"ctype=post&&typeid="+pid,
			type:"GET",
			success:function(result){
				addCommentData(result);
			}
		});
	}
	
	function addCommentData(result){
		var emps=result.extend.pageInfo.list;
		$.each(emps,function(index,item){
			var t=$("<img></img>").addClass("img_manager img-circle")
			  					  .attr("src","${APP_PATH}/image/"+item.user.purl);
			var tt=$("<label></label>").append(t)
			   .append("&nbsp;<span style='font-size:15px'>"+item.user.uname+"</span>");
			$("<tr></tr>").append($("<td></td>").append(tt)).appendTo("#seetable");
			var comment=$("<td></td>").append(item.comment).css("font-size","18px");
			$("<tr></tr>").append(comment).appendTo("#seetable");
			$("<tr></tr>").append($("<td></td>").addClass("td_c").append(item.cdate).attr("align","right").css("font-size","10px")).appendTo("#seetable");
		});
	}
	
	</script>
</body>
</html>