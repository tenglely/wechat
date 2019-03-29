<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单信息管理</title>
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
				<div class="container">
					<!-- 标题 -->
					<div class="row">
						<div class="col-md-">
							<h1>菜单信息管理</h1>
						</div>
					</div>
					<!-- 按钮 -->
					<div class="row">
						<div class="col-md-8 col-md-offset-6">
						  <table><tr>
							
								<td><p style="font-size: 20px;margin: auto;">查询方式:</p></td>
								<td>
								<select class="form-control" id="select_way" name="select_way">
									<option value="全部">(全部)</option>
									<option value="菜品编号">菜品编号</option>
									<option value="菜品名">菜品名</option>
									<option value="所属菜系">所属菜系</option>
									<option value="标签">标签</option>
									<option value="点击量">点击量(升序)</option>
								</select>
								</td>
								<td><input class="form-control" type="text" name="find_value" id="find_value" placeholder="输入查询值"></td>
								<td>
							<button id="btn_find" class="btn btn-primary">查询</button></td>
							
						 </tr></table>
						</div>
					</div>
					<!-- 显示表格数据-->
					<div class="row">
						<div class="col-md-12">
							<table class="table table-hover" id="greens_table">
								<thead>
								<tr>
									<th>#</th>
									<th>菜品名</th>
									<th>所属菜系</th>
									<th>标签</th>
									<th>点击量</th>
									<th>菜品发布者</th>
									<th>发布时间</th>
									<th>步骤</th>
									<th>操作</th>
								</tr>
								</thead>
								<tbody>
								
								</tbody>
								
							</table>
						</div>
					</div>
					<!-- 显示分页信息 -->
					<div class="row">
						<!-- 分页文字信息 -->
						<div class="col-md-6" id="page_info">
							
						</div>
						<!-- 分页条信息 -->
						<div class="col-md-6" id="page_nav">
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		//点击查询后进行查询
		$("#btn_find").click(function(){
			to_page(1);
		});	
	
		//1.页面加载完成后，直接发送ajax请求，要到分页数据
		$(function(){
			//去首页
			to_page(1);
		});
		function to_page(pn){
			//alert($("#select_way").val());
			var v=$("#select_way").val();
			var f=$("#find_value").val();
			$.ajax({
				url:"${APP_PATH}/findAllgreens",
				data:"pn="+pn+"&select_way="+v+"&find_value="+f,
				type:"POST",
				success:function(result){
					//1.解析并显示菜品数据
					build_emps_table(result);
					//2.解析并显示分页信息
					bulid_page_info(result);
					//3.解析显示分页条
					bulid_page_nav(result);
				}
			});
		}
		
		//点击删除，删除一条菜品信息
		$(document).on("click",".delete-btn",function(){
			var gname=$(this).parents("tr").find("td:eq(1)").text();
			var gid=$(this).attr("del-id");
			if(confirm("确定删除菜品‘ "+gname+" ’吗")){
				$.ajax({
					url:"${APP_PATH}/deleteGreens/"+gid,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						to_page(1);
					}
				});
			}
		});
		
		//1.解析并显示菜品数据
		function build_emps_table(result){
			//清空
			$("#greens_table tbody").empty();
			var emps=result.extend.pageInfo.list;
			$.each(emps,function(index,item){
				var gid=$("<td></td>").append(item.gid);
				var gname=$("<td></td>").append(item.gname);
				var gstyle=$("<td></td>").append(item.gstyle);
				var glabel=$("<td></td>").append(item.glabel);
				var ghits=$("<td></td>").append(item.ghits).append("次");
				var gwriter=$("<td></td>").append(item.gwriter);
				var gdate=$("<td></td>").append(item.gdate);
				var editBtn=$("<td></td>").append($("<a></a>").attr("href","${APP_PATH}/view/updateStep.jsp?gid="+item.gid).addClass("btn btn-primary btn-sm")
						.append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
						.append("编辑步骤"));
				var seeBtn=$("<button></button").addClass("btn btn-primary btn-sm")
							.append($("<span></span>").addClass("glyphicon glyphicon-eye-open"))
							.append(" 浏览");
				var updBtn=$("<a></a").addClass("btn btn-info btn-sm")
							.append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
							.append(" 修改");
				updBtn.attr("href","${APP_PATH}/findone?gid="+item.gid);
				var delBtn=$("<button></button").addClass("btn btn-danger btn-sm delete-btn")
							.append($("<span></span>").addClass("glyphicon glyphicon-trash"))
							.append(" 删除");
				delBtn.attr("del-id",item.gid);
				var btnTd=$("<td></td>").append(updBtn)
							.append(" ").append(delBtn);
				
				$("<tr></tr>").append(gid)
							  .append(gname)
							  .append(gstyle)
							  .append(glabel)
							  .append(ghits)
							  .append(gwriter)
							  .append(gdate)
							  .append(editBtn)
							  .append(btnTd)
							  .appendTo("#greens_table tbody");
			});
		}
		
		//2.解析并显示分页信息
		function bulid_page_info(result){
			//清空
			$("#page_info").empty();
			$("#page_info").append("当前页码:"+result.extend.pageInfo.pageNum+
					",总页码:"+result.extend.pageInfo.pages+
					",总记录数:"+result.extend.pageInfo.total);
		}
		
		function bulid_page_nav(result){
			$("#page_nav").empty();
			var ul=$("<ul></ul>").addClass("pagination");
			var firstPageLi=$("<li></li>").append($("<a></a>").append("首页"));
			var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;"));
			if(result.extend.pageInfo.hasPreviousPage==false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				firstPageLi.click(function(){
					to_page(1);
				});
				
				prePageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum-1);
				});
			}
			
			var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi=$("<li></li>").append($("<a></a>").append("末页"));
			if(result.extend.pageInfo.hasNextPage==false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				nextPageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum+1);
				});
				
				lastPageLi.click(function(){
					to_page(result.extend.pageInfo.pages);
				});
			}
			
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numLi=$("<li></li>").append($("<a></a>").append(item));
				if(result.extend.pageInfo.pageNum==item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					to_page(item);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var nav=$("<nav></nav>").append(ul).appendTo("#page_nav");
		}
	</script>
</body>
</html>
