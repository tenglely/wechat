<%@page import="com.wechat.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>我的设置</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.3.1.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<!-- Custom Theme files -->
<link href="${APP_PATH}/userview/css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</script>
<!----webfonts---->
<link href='http://fonts.googleapis.com/css?family=Exo+2:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<style type="text/css">
	.im {
		border: 6px solid #EBEBEB;
		border-radius: 35px;
		background-color: #fff;
	}
	.l1{
		font-family: STHupo;
		font-size: 20px;
		color: #708090;
	}
	.img_manager{
		width: 55px;
		height: 55px;
	}
</style>
</head>
<body>
	<div class="header">
		<div class="header_bottom">
		  <div class="header_nav">
      		
			 <nav class="navbar navbar-default menu" role="navigation"><h3 class="nav_right"><a href="index.html"><img src="images/logo.png" class="img-responsive" alt=""/></a></h3>
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    
				<!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="margin-left: 350px;">
			      <ul class="nav navbar-nav menu1">
			      	<li class="active"><a href="${APP_PATH}/userview/userindex.jsp">首页</a></li>
			        <li><a href="${APP_PATH}/userview/allgreens.jsp">菜品大全</a></li>
			        <li><a href="${APP_PATH}/userview/userpost.jsp">厨分享</a></li>
			       	<li><a href="${APP_PATH}/userview/myset.jsp">我的</a></li>
			        <li >
			        	<input type="text" class="text">
			  			<input class="btn btn-info btn-sm" type="submit" value="查询">
			  		</li>
		          </ul>
			      <div class="clearfix"></div>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
            <div class="clearfix"></div>
           </div>
          
		 </div>  
		</div>
	</div>
    <div class="main">
		<div class="container">
			<br>
		   <div class="row content">
		   	<div class="col-md-3 content_top">
		   	   <div class="category_box">
		   	  	<h3 class="cate_head">每日热门</h3>
		   	     <ul class="category" id="ll">
			   	  	
		   	     </ul>
		   	   </div>
		   	   <ul class="product_reviews">
		   	   	<h3><i class="arrow"> </i><span>热门讨论</span></h3>
		   	   	<li>
		   	   		<ul class="review1" id="u1">
		   	   			
		   	   		</ul>
		   	   	</li>
		   	   	<li>
		   	   		<ul class="review1" id="u2">
		   	   			
		   	   		</ul>
		   	   	</li>
		   	   	<li>
		   	   		<ul class="review1" id="u3">
		   	   			
		   	   		</ul>
		   	   	</li>
		   	    <div class="but">
			       <a href="#">更多讨论<i class="but_arrow"> </i></a>
			    </div>
		   	   </ul>
		   	   
		   	   
		   	</div>
		   	<div class="col-md-9 im">
		   		<br>
		   		<%
					if(session.getAttribute("user")==null||session.getAttribute("user")==""){	
				%>
		   		<form action="${APP_PATH}/peoplelogin" method="post">
		   		<div class="row">
		   			<div class="col-md-3" align="right">
		   				<label class="l1">用户名：</label>
		   			</div>
		   			<div class="col-md-6">
		   				<input type="text" class="form-control" name="uname">
		   			</div>
		   		</div><br>
		   		<div class="row">
		   			<div class="col-md-3" align="right">
		   				<label class="l1">密码：</label>
		   			</div>
		   			<div class="col-md-6">
		   				<input type="password" class="form-control" name="openid">
		   			</div>
		   		</div><br>
		   		<div class="row">
		   			<div class="col-md-1" style="margin-left: 450px;">
		   				<input type="submit" value="登录" class="btn btn-info">
		   			</div>
		   			<div class="col-md-1">
		   				<input type="reset" value="重置" class="btn btn-danger">
		   			</div>
		   		</div><br>
		   		</form>
		   		<% }else{
		   		User user=(User)session.getAttribute("user");
		   		%>
		   		
		   		<div class="row" style="margin-left: 10px;">
		   			<img class="img_manager img-circle" src="${APP_PATH}/image/<%=user.getPurl() %>" alt="photo">		
			    	&nbsp;&nbsp;&nbsp;&nbsp;
			    	<label class="ln">
			    		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
			    		用户：<%=user.getUname() %>
			    	</label>
			    	<button class="btn btn-link" style="margin-left: 20px;" id="update_a">
			    		<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
			    		修改
			    	</button>
			    	<input type="hidden" id="nowdate" value="<%=user.getUclass()%>">
						<div class="modal fade" id="update_admin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h4 class="modal-title" id="myModalLabel">个人设置</h4>
						      </div>
						      <form action="${APP_PATH}/updateuser" enctype="multipart/form-data" method="post">
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
		   		</div><br>
		   		<% } %>
	</div>
	</div>
	
	<script type="text/javascript">
		$(function(){
			//加载每日热门
			putlist();
			//加载热门讨论
			puthotpost();
		});
		
		//弹出修改框
		$("#update_a").click(function(){
			$("#file").hide();
			$("#update_admin").modal();
		});
		
		$("#btn_p").click(function(){
			$("#file").show();
		});	
		
		//加载每日热门
		function putlist(){
			$.ajax({
				url:"${APP_PATH}/wechat_findByHits",
				data:"rule=hot",
				type:"GET",
				success:function(result){
					var emps=result.extend.pageInfo.list;
					$.each(emps,function(index,item){
						var a=$("<a></a>").append(item.gname).attr("href","${APP_PATH}/userview/single.jsp?gid="+item.gid);
						var li=$("<li></li>").append(a);
						$("#ll").append(li);				  
					});
				}
			});
		}
		
		//加载热门讨论
		function puthotpost(){
			$.ajax({
				url:"${APP_PATH}/getpostbyhits",
				type:"GET",
				success:function(result){
					var emps=result.extend.pageInfo.list;
					var i=0;
					$.each(emps,function(index,item){
						if(i==0){
							var l1=$("<li></li>").addClass("review1_img")
									.append($("<img></img>").addClass("img-responsive")
									.attr("src","${APP_PATH}/image/"+item.pfile));
							var l2=$("<li></li>").addClass("review1_desc").append($("<h3></h3>")
									.append($("<a></a>").append(item.title))).append($("<p></p>")
											.append(item.pdate));
							$("#u1").append(l1).append(l2).append($("<div></div>").addClass("clearfix"));
						}	
						if(i==1){
							var l1=$("<li></li>").addClass("review1_img")
									.append($("<img></img>").addClass("img-responsive")
									.attr("src","${APP_PATH}/image/"+item.pfile));
							var l2=$("<li></li>").addClass("review1_desc").append($("<h3></h3>")
									.append($("<a></a>").append(item.title))).append($("<p></p>")
											.append(item.pdate));
							$("#u2").append(l1).append(l2).append($("<div></div>").addClass("clearfix"));
						}		
						if(i==2){
							var l1=$("<li></li>").addClass("review1_img")
									.append($("<img></img>").addClass("img-responsive")
									.attr("src","${APP_PATH}/image/"+item.pfile));
							var l2=$("<li></li>").addClass("review1_desc").append($("<h3></h3>")
									.append($("<a></a>").append(item.title))).append($("<p></p>")
											.append(item.pdate));
							$("#u3").append(l1).append(l2).append($("<div></div>").addClass("clearfix"));
						}	
						i++;
					});
				}
			});
		}
		
	</script>

</body>
</html>

