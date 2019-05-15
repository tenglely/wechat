<%@page import="com.wechat.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>菜品详细页</title>
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
<script type="text/javascript" charset="utf-8" src="${APP_PATH}/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${APP_PATH}/utf8-jsp/ueditor.all.min.js"> </script>    
<script type="text/javascript" charset="utf-8" src="${APP_PATH}/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<style type="text/css">
	.img1{
		height: 300px;
	}
	.im {
		border: 6px solid #EBEBEB;
		border-radius: 35px;
	}
	.im1 {
		border: 6px solid #EBEBEB;
		border-radius: 15px;
	}
	.img_manager{
		width: 35px;
		height: 35px;
	}
	
	.mob{
		margin-left: 10px;
		width: 769px;
	}
	.h{
		color: #FF7F24;
		font-family: STHupo;
		margin-left: 10px;
	}
	.guide{width:60px;margin-left:600px;position:fixed;left:50%;bottom:134px;_position:absolute;_top:expression(documentElement.scrollTop+documentElement.clientHeight - this.clientHeight - 134+'px');display:block;}
	.guide a{display:block;width:60px;height:50px;background:url("${APP_PATH}/image/sprite_v2.png") no-repeat;margin-top:10px;text-decoration:none;font:16px/50px "Microsoft YaHei";text-align:center;color:#fff;border-radius:2px;}
	.guide a span{display:none;text-align:center;}
	.guide a:hover{text-decoration:none;background-color:#39F;color:#fff;}
	.guide a:hover span{display:block;width:60px;background:#39F}
	.guide .find{background-position:-84px -236px;}
	.guide .report{background-position:-146px -236px;}
	.guide .edit{background-position:-83px -185px;}
	.guide .top{background-position:-145px -185px;}
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
		   	<% String g=request.getParameter("gid"); %>
		   	<input type="hidden" id="gid" value="<%=g%>">
		   	<div class="col-md-9 im" id="d4" style="background-color: #fff;">
		   		<div class="row" id="d3" style="margin-left: 10px;">
		   		<br>
		   		</div>
		   		<div class="row" id="d1" align="center" >
		   		</div>
		   		<div class="row" id="d2" style="margin-left: 10px;">
		   			<br>
		   		</div>
		   		<div class="row">
		   			<br><h3 style="color: #FF7F24;font-family: STHupo;margin-left: 10px;">制作步骤：</h3>
		   		</div>
		   		
		   	</div>
		   	
		   	<!-- 悬浮框 -->
		   	<div class="guide">
				<div class="guide-wrap">
					<a href="javascript:window.scrollTo(0,0)" class="top" title="回顶部"><span>回顶部</span></a>
					<a data-toggle="modal" data-target="#add_gstyle" class="edit" title="写评论"><span>写评论</span></a>
				</div>
			</div>
			<!-- Modal -->
			<div class="modal fade" id="add_gstyle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">添加评论</h4>
			      </div>
			      <div class="modal-body">
			      	<div class="row">
			      	<%
						if(session.getAttribute("user")==null||session.getAttribute("user")==""){	
					%>
						<h4>你还没有登录，登录后才能评论</h4>
						<a href="${APP_PATH}/userview/myset.jsp">跳去登录/注册</a>
					<% }else{ 
						User user=(User)session.getAttribute("user");
					%>
					  <form action="${APP_PATH}/useraddcomment">
					  	 <input type="hidden" name="uid" value="<%=user.getUid()%>">
					  	 <input type="hidden" name="ctype" value="greens">
					  	 <input type="hidden" name="typeid" value="<%=g%>">
						 <script id="editor" type="text/plain"
		                style="width:596px;height:200px;"></script>
		                 <input type="submit" value="添加评论" class="btn btn-primary">	
					  </form>
	                <% } %>
					</div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			      </div>
			    </div>
			  </div>
			</div>
	
	<script type="text/javascript">
		$(function(){
			//加载每日热门
			putlist();
			//加载热门讨论
			puthotpost();
			//加载菜品内容
			putgreens();
			//加载菜品步骤
			putsteps();
			//加载菜品评论
			putcomment();
		});
		
		
		//调用文本编辑器
		var ue = UE.getEditor('editor');
		
		//加载菜品评论
		function putcomment(){
			var gid=$("#gid").val();
			$.ajax({
				url:"${APP_PATH}/findComment",
				data:"typeid="+gid+"&&ctype=greens",
				type:"GET",
				success:function(result){
					var list=result.extend.pageInfo.list;
					$("#d4").append($("<div></div>").addClass("row").append("<br>").append($("<h3></h3>").append("菜品评论").addClass("h")));
					$("#d4").append("<br>");
					$("#d4").append($("<div></div>").addClass("row mob").append(
						$("<table></table>").attr("id","seetable")));
                    $.each(list,function (index,item) {
                    	var t=$("<img></img>").addClass("img_manager img-circle")
	  					  .attr("src","${APP_PATH}/image/"+item.user.purl);
						var tt=$("<label></label>").append(t)
						   .append("&nbsp;<span style='font-size:15px'>"+item.user.uname+"</span>");
						$("<tr></tr>").append($("<td></td>").append(tt)).appendTo("#seetable");
						var comment=$("<td></td>").append(item.comment).css("font-size","18px");
						$("<tr></tr>").append(comment).appendTo("#seetable");
						$("<tr></tr>").append($("<td></td>").addClass("td_c").append(item.cdate).attr("align","right").css("font-size","10px")).appendTo("#seetable");
                    })
                    $("#d4").append("<br>");
				}
			});
		}
		
		//加载菜品步骤
		function putsteps(){
			var gid=$("#gid").val();
			$.ajax({
				url:"${APP_PATH}/stepByGid",
				data:"gid="+gid,
				type:"GET",
				success:function(result){
					var list=result.extend.list;
					$.each(list,function(index,item){
						var d1=$("<div></div>").addClass("col-md-1").attr("align","center").append("<br>").append(
						$("<p></p>").append(item.step).css("font-size","35px").css("color","#FF7F24"));
						var d2=$("<div></div>").addClass("col-md-3").append("<br>").append(
						$("<img></img>").addClass("im1").attr("src","${APP_PATH}/image/"+item.sphoto));
						var d3=$("<div></div>").addClass("col-md-5").append("<br>").append(
						$("<p></p>").append(item.sdescribe).css("font-size","20px").css("margin-top","12px"));
						var d4=$("<div></div>").addClass("row").append(d1).append(d2).append(d3);
						$("#d4").append(d4);
					})
					$("#d4").append("<br>");
				}
			});
		}
		
		
		//加载菜品内容
		function putgreens() {
			var gid=$("#gid").val();
			$.ajax({
				url:"${APP_PATH}/wechat_findgreens",
				data:"gid="+gid,
				type:"GET",
				success:function(result){
					var greens=result.extend.greens;
					var img=$("<img></img>").attr("src","${APP_PATH}/image/"+greens.gcover).addClass("img1");
					var read=$("<p></p>").append(greens.gneed).css("font-size","20px");
					var title=$("<h2></h2>").append(greens.gname);
					var date=$("<h5></h5>").append("标签:&nbsp;"+greens.glabel).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间:&nbsp;").append(greens.gdate).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点击量:&nbsp;"+greens.ghits);
					$("#d1").append(img);
					$("#d2").append(read);
					$("#d3").append(title).append(date);
				}
			});
		}
		
		//加载热门讨论
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
		//加载每日热门
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

