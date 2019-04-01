<%@page import="com.wechat.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员界面</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.3.1.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<style type="text/css">
	.img_manager{
		width: 55px;
		height: 55px;
	}
	.td_bc{
		opacity:0.85;
		background-color: #E0FFFF;
	}
	.bc{
		background-color: #F5F5F5;
	}
	.ln{
		font-size: 25px;
	}
	body {
		background: url(../image/foot.jpg) no-repeat;
		background-attachment:fixed;
		background-position:center;
		background-size:cover;
		-webkit-background-size:cover;
		-moz-background-size:cover;
		-o-background-size:cover;
		font-family: 'Muli', sans-serif;
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
	<input type="hidden" id="nowdate" value="<%=user.getUclass()%>">
	
	<div class="modal fade" id="update_admin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">个人设置</h4>
	      </div>
	      <form action="${APP_PATH}/updateAdmin" enctype="multipart/form-data" method="post">
	      <input type="hidden" name="uid" value="<%=user.getUid()%>">
	      <div class="modal-body">
	      	<div class="container-fluid" style="margin-left: 150px;">
	      		<div class="row">
	      			<label>头&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;像:&nbsp;&nbsp;</label>
	      			<img class="img_manager img-circle" src="${APP_PATH}/image/<%=user.getPurl() %>" alt="photo">&nbsp;&nbsp;		
	      			<a id="btn_p">修改<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
	      			<input id="file" class="form-control btn btn-info" type="file" name="file">
	      		</div><br>
	      		<div class="row">
	      			<label>用&nbsp;&nbsp;户&nbsp;名：</label>
	      			<input type="text" name="uname" value="<%=user.getUname() %>" placeholder="用户名由2-10位组成">
	      		</div><br>
	      		<div class="row">
	      			<label>修改密码：</label>
	      			<input type="password" name="openid" value="<%=user.getOpenid()%>" placeholder="密码由3-10位数字或字母组成">
	      		</div>
	      	</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <input type="submit" class="btn btn-primary" id="btn_update_admin" value="修改个人设置">
	      </div>
	      </form>
	    </div>
	  </div>
	</div>
	
	<div class="modal fade" id="add_admin_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">添加管理员</h4>
	      </div>
	      <form id="add_admin_form">
	      <div class="modal-body">
	      	<div class="container-fluid" style="margin-left: 150px;">
	      		
	      		<div class="row">
	      			<label>用&nbsp;&nbsp;户&nbsp;名：&nbsp;&nbsp;</label>
	      			<input type="text" name="uname" placeholder="用户名由2-10位组成">
	      		</div><br>
	      		<div class="row">
	      			<label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：&nbsp;</label>
	      			<input type="password" name="openid" placeholder="密码由3-10位数字或字母组成">
	      		</div>
	      	</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="btn_add_admin">添加管理员</button>
	      </div>
	     </form>
	    </div>
	  </div>
	</div>
	
	<br><br>
	<div class="container-fluid">
	  <div class="row">
	    <div class="col-md-12 col-md-offset-4" style="width: 500px;">
	     <div class="td_bc col-md-12" style="height: 85px;">
	     	<br>
	    	<img class="img_manager img-circle" src="${APP_PATH}/image/<%=user.getPurl() %>" alt="photo">		
	    	&nbsp;&nbsp;&nbsp;&nbsp;
	    	<label class="ln">
	    		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
	    		管理员：<%=user.getUname() %>
	    	</label>
	    	<button class="btn btn-link" style="margin-left: 20px;" id="update_a">
	    		<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
	    		修改
	    	</button>	
	    	<br>	
		 </div>
		 <div  class="bc">
			 <div style="margin-left: 30px;">
		     	<table id="admin_table" style="width: 400px;">
		     		<thead>
		     			<th>#</th>
		     			<th>当前管理员</th>
		     			<th>管理员类型</th>
		     			<th><th>
		     		</thead>
		     		<tbody></tbody>
		     	</table>
			 </div>
		 </div>
		 <div class="td_bc col-md-12" style="height: 85px;">
			<center>
		 	<br>
		 	<% if(user.getUclass().equals("超级管理员")) {%>
		 	<button id="add_admin" class="btn btn-primary">添加新管理员</button>
		 	<% } %>
		 	<a class="btn btn-danger" href="${APP_PATH}/index.jsp">返回首页</a>
		 	<br>
			</center>
		 </div>
	    </div>
	  </div>
	</div>
</body>

<script type="text/javascript">
	$(function(){
		userall();
	});
	
	//弹出修改框
	$("#update_a").click(function(){
		$("#file").hide();
		$("#update_admin").modal();
	});
	
	//弹出添加框
	$("#add_admin").click(function(){
		$("#add_admin_modal").modal();
	});	
	
	$("#btn_p").click(function(){
		$("#file").show();
	});	
	
	$("#btn_add_admin").click(function(){
		$.ajax({
			url:"${APP_PATH}/addAdmin",
			type:"POST",
			data:$("#add_admin_form").serialize(),
			success:function(result){
				$("#add_admin_modal").modal("hide");
				userall();
			}
		});
	});	
	
	//查询管理员
	function userall(){
		$.ajax({
			url:"${APP_PATH}/userAdmin",
			type:"GET",
			success:function(result){
				$("#admin_table tbody").empty();
				var emps=result.extend.list;
				$.each(emps,function(index,item){
					var photo=$("<img></img>").attr("src","${APP_PATH}/image/"+item.purl)
											  .css("width","30px").css("height","30px")
											  .addClass("img-circle");				
					var purl=$("<td></td>").append(photo);
					var uname=$("<td></td>").append(item.uname);
					var uclass=$("<td></td>").append(item.uclass);
					var x=$("<span></span>").addClass("glyphicon glyphicon-trash").append("<br><br>");
					var a=$("<button></button>").append(x)
												.addClass("btn btn-link dele_admin");
					a.attr("dele_btn",item.uid);
					$("<tr></tr>").append(purl)
								  .append(uname)
								  .append(uclass)
								  .append(a)
								  .appendTo("#admin_table tbody");
				});
			}
		});
	}
	
	//超级管理员删除管理员
	$(document).on("click",".dele_admin",function(){
		var uclass=$("#nowdate").val();
		var uname=$(this).parents("tr").find("td:eq(1)").text();
		var uid=$(this).attr("dele_btn");
		if(uclass!="超级管理员"){
			alert("权限不足，无法进行删除操作");
		}else{
			if(confirm("确定删除管理员‘ "+uname+" ’吗")){
				$.ajax({
                    url : "${APP_PATH}/deleteuser/" + uid,
                    type : "DELETE",
                    success : function(result) {
                    	userall();
                    }
                });
			}
		}
	});
</script>
</html>