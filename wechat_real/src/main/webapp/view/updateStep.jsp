<%@page import="com.wechat.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑步骤</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.3.1.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<style type="text/css">
	
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
					 <a class="list-group-item active" href="${APP_PATH}/view/greensManager.jsp">
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
				<div class="container-fluid">
				  <div class="row">
				  	<br>
				  	<button class="btn btn-warning" onclick="window.history.back(-1);">返回上一页</button>
				  	<br>
				  	<input type="hidden" id="gid" value="<%=request.getParameter("gid")%>">
				  	<table id="steptable" style="margin-left: 50px;width: 900px;">
						<thead>
							<th>#</th>
							<th>配图</th>
							<th>描述</th>
							<th>定时时间</th>
							<th>操作</th>
						</thead>
						<tbody></tbody>
						<tfoot>
							<tr>
								<td align="right" colspan="5">
									<a href="${APP_PATH}/jump_addStep?gid=<%=request.getParameter("gid")%>"  class="btn btn-primary">添加新步骤</a>
								</td>
							</tr>
						</tfoot>
				    </table>
				  </div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		var gid=$("#gid").val();
		$.ajax({
			url:"${APP_PATH}/stepByGid",
			type:"GET",
			data:"gid="+gid,
			success:function(result){
				bulid_table(result);
			}
		});
	});
	
	//点击删除，删除一条菜品步骤信息
	$(document).on("click",".delete-btn",function(){
		var sid=$(this).attr("del-id");
		if(confirm("确定删除该菜品步骤吗")){
			$.ajax({
				url:"${APP_PATH}/deleteStep/"+sid,
				type:"DELETE",
				success:function(result){
					alert(result.msg);
					var gid=$("#gid").val();
					$.ajax({
						url:"${APP_PATH}/stepByGid",
						type:"GET",
						data:"gid="+gid,
						success:function(result){
							bulid_table(result);
						}
					});
				}
			});
		}
	});
	
	function bulid_table(result){
		$("#steptable tbody").empty();
		var emps=result.extend.list;
		$.each(emps,function(index,item){
			var step=$("<td></td>").append("做菜第"+item.step+"步：").css("color","#FF0000").css("font-size","28px").attr("align","right");
			var sphoto=$("<img></img>").attr("src","${APP_PATH}/image/"+item.sphoto).css("width","200px").css("height","120px");
			var describe=$("<td></td>").append(item.sdescribe).css("color","#000000").css("font-size","18px").attr("align","center");
			var timing=$("<td></td>").append(item.timing).css("color","#000000").css("font-size","18px").attr("align","center");
			var updBtn=$("<a></a>").addClass("btn btn-info btn-sm")
			.append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
			.append("修改");
			updBtn.attr("href","${APP_PATH}/view/updateStep_value.jsp?sid="+item.sid);
			var delBtn=$("<button></button").addClass("btn btn-danger btn-sm delete-btn")
			.append($("<span></span>").addClass("glyphicon glyphicon-trash"))
			.append(" 删除");
			delBtn.attr("del-id",item.sid);
			if(index==emps.length-1){
			$("<tr></tr>").append(step)
					.append($("<td></td>").append(sphoto).append("<br>"))
					.append(describe)
					.append(timing)
					.append($("<td></td>").append(updBtn).append(" ").append(delBtn))
					.attr("colspan","5")
					.appendTo("#steptable tbody");
			}else{
				$("<tr></tr>").append(step)
						.append($("<td></td>").append(sphoto).append("<br><br>"))
						.append(describe)
						.append(timing)
						.append($("<td></td>").append(updBtn))
						.appendTo("#steptable tbody");
			}
			
		});
	}
	</script>
</body>
</html>