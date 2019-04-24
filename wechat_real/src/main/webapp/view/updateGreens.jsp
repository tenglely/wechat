<%@page import="com.wechat.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改菜品信息</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.3.1.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${APP_PATH}/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${APP_PATH}/utf8-jsp/ueditor.all.min.js"> </script>    
<script type="text/javascript" charset="utf-8" src="${APP_PATH}/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<style type="text/css">
	
	.top{
		background-color: 	#A9A9A9;
	}
	.list{
		background-color: #D3D3D3;
		height: 875px;
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

	<div class="modal fade" id="add_emp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">添加员工</h4>
	      </div>
	      <div class="modal-body">
	        	修改成功
	      </div>
	    </div>
	  </div>
	</div>
	

	<!-- Modal -->
	<div class="modal fade" id="add_gstyle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">自定义菜系</h4>
	      </div>
	      <div class="modal-body">
	      	<input type="text" id="newstyle" class="form-control" placeholder="自定义新菜系分类">	
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="btn_add_style">添加自定义</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="add_glabel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">添加标签</h4>
	      </div>
	      <div class="modal-body">
	      	<input type="text" id="new_glabel" class="form-control" placeholder="添加标签">	
	      	<button type="button" id="one" class="btn btn-default btn-xs">家常菜</button>
	      	<button type="button" id="two" class="btn btn-default btn-xs">甜点</button>
	      	<button type="button" id="three" class="btn btn-default btn-xs">粥类</button>
	      	<button type="button" id="four" class="btn btn-default btn-xs">寿司</button>
	      	<button type="button" id="five" class="btn btn-default btn-xs">西餐</button>
	      	<button type="button" id="six" class="btn btn-default btn-xs">烧烤</button>
	      	<button type="button" id="seven" class="btn btn-default btn-xs">面食类</button>
	      	<button type="button" id="eight" class="btn btn-default btn-xs">早点</button>
	      	<span class="glyphicon glyphicon-tag" aria-hidden="true"></span>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="btn_add_glabel">添加自定义</button>
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
				</div>
			</div>
			<div class="col-md-10">
				<br>
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12" id="main" style="background-color: #e3e3e8;height:  850px;">
							<br>
							<form action="${APP_PATH}/updateGreens" enctype="multipart/form-data"  method="post">
								<input type="hidden" value="${greens.gid}" name="gid">
								<div class="input-group col-md-6">
									<span class="input-group-addon" style="font-size: 20px;">菜品名：</span>
									<input class="form-control " type="text" value="${greens.gname}" name="gname" id="gname">
								</div><br>
								<div class="input-group col-md-6">
									<span class="input-group-addon" style="font-size: 20px;">所属菜系：</span>
									<div class="col-xs-10">
									<select class="form-control" name="gstyle">
										<option value="${greens.gstyle}">${greens.gstyle}</option>
										<option id="gstyle_o">自定义</option>
										<option value="粤菜">粤菜</option>
										<option value="鲁菜">鲁菜</option>
										<option value="川菜">川菜</option>
										<option value="苏菜">苏菜</option>
										<option value="闽菜">闽菜</option>
										<option value="浙菜">浙菜</option>
										<option value="湘菜">湘菜</option>
										<option value="徽菜">徽菜</option>
									</select>
									</div>
									<button type="button" class="btn btn-info" data-toggle="modal" data-target="#add_gstyle">
									  自定义
									</button>
								</div><br>
								<div class="input-group col-md-6">
									<span class="input-group-addon" style="font-size: 20px;">标签：</span>
									<div class="col-xs-10">
									<input class="form-control" type="text" value="${greens.glabel}" name="glabel" id="glabel" placeholder="如：家常菜，甜品，汤，粥等分类">
									</div>
									<button type="button" class="btn btn-info" data-toggle="modal" data-target="#add_glabel">
									  添加标签
									</button>
								</div><br>
								<div class="input-group col-md-6">
									<span class="input-group-addon" style="font-size: 20px;">封面原图片：</span>
									<img alt="原图" src="${APP_PATH}/image/${greens.gcover}" style="width: 160px;height: 100px;">
								</div><br>
								<div class="input-group col-md-6">
									<span class="input-group-addon" style="font-size: 20px;">替换封面图片：</span>
									<input class="form-control btn btn-info" type="file" name="file">
								</div><br> 
								<div class="input-group col-md-6">
									<span class="input-group-addon" style="font-size: 16px;"><b>菜品简介：</b></span>
						           
						            <textarea rows="15" cols="50" style="font-size: 20px;" name="editorValue">${greens.gneed}</textarea>    
								</div><br>
								<div class="input-group col-md-6 col-md-offset-3">
									<input type="submit" class="btn btn-primary" value="确认并结束">
									&nbsp;&nbsp;&nbsp;&nbsp;
									<button class="btn btn-primary">重置</button>
								</div>
							</form>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	

          
	
	<script type="text/javascript">
				
		//修改greens
		$("#addGreens_last").click(function(){
			$.ajax({
				url:"${APP_PATH}/updateGreens",
				type:"POST",
				data:$("#saveform").serialize(),
				success:function(result){
					window.location.href="${APP_PATH}/view/greensManager.jsp";
				}
			});
		});
		
		//调用文本编辑器
		var ue = UE.getEditor('editor');
	
		$("#btn_add_style").click(function(){
			var v=$("#newstyle").val();
			$("#gstyle_o").val(v);
			$("#gstyle_o").empty();
			$("#gstyle_o").append(v+"(自定义菜系)");
			$("#add_gstyle").modal("hide");
		});
		
		$("#btn_add_glabel").click(function(){
			var v=$("#new_glabel").val();
			$("#glabel").empty();
			$("#glabel").val(v);
			$("#add_glabel").modal("hide");
		});
		
		$("#one").click(function(){
			var v=$("#new_glabel").val()+"家常菜 ";
			$("#new_glabel").val(v);
		});
		$("#two").click(function(){
			var v=$("#new_glabel").val()+"甜点 ";
			$("#new_glabel").val(v);
		});
		$("#three").click(function(){
			var v=$("#new_glabel").val()+"粥类 ";
			$("#new_glabel").val(v);
		});
		$("#four").click(function(){
			var v=$("#new_glabel").val()+"寿司 ";
			$("#new_glabel").val(v);
		});
		$("#five").click(function(){
			var v=$("#new_glabel").val()+"西餐 ";
			$("#new_glabel").val(v);
		});
		$("#six").click(function(){
			var v=$("#new_glabel").val()+"烧烤 ";
			$("#new_glabel").val(v);
		});
		$("#seven").click(function(){
			var v=$("#new_glabel").val()+"面食类 ";
			$("#new_glabel").val(v);
		});
		$("#eight").click(function(){
			var v=$("#new_glabel").val()+"早点 ";
			$("#new_glabel").val(v);
		});
		
	</script>
</body>
</html>