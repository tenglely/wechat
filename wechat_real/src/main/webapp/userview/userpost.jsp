<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>厨分享</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.3.1.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/js/userwillview.js"></script>
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
		border: 6px solid #D2CF99;
		border-radius: 35px;
		background-color: #fff;
	}
	.h{
		color: #FF7F24;
		font-family: STHupo;
		font-size:20px;
		margin-left: 10px;
	}
	.ppo{
		font-size:16px;
	}
	.ii{
		width: 520px;
	}
	.r1{
		margin-left: 10px;
	}
	.r2{
		margin-top: 6px;
		margin-bottom: 6px;
	}
	.guide{width:60px;margin-left:450px;position:fixed;left:50%;bottom:134px;_position:absolute;_top:expression(documentElement.scrollTop+documentElement.clientHeight - this.clientHeight - 134+'px');display:block;}
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
			      	<li><a href="${APP_PATH}/userview/userindex.jsp">首页</a></li>
			        <li><a href="${APP_PATH}/userview/allgreens.jsp">菜品大全</a></li>
			        <li class="active"><a href="${APP_PATH}/userview/userpost.jsp">厨分享</a></li>
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
		   	<input type="hidden" id="findway" value="hot">
		   	<div class="col-md-9">
		   	   <ul class="feature">
		   	   	 <h3><i class="arrow"> </i><span>厨分享--分享/交流你的菜品故事</span></h3>
		   	   </ul>
		   	   <br>
		   	   <div class="container" id="p1">
			   	   
			   </div>
		    </div>
		   </div>
		</div>
	</div>
			<!-- 悬浮框 -->
		   	<div class="guide">
				<div class="guide-wrap">
					<a href="javascript:window.scrollTo(0,0)" class="top" title="回顶部"><span>回顶部</span></a>
				</div>
			</div>
	<script type="text/javascript">
		$(function(){
			//加载每日热门
			putlist();
			//加载热门讨论
			puthotpost();
			//加载贴子
			putpost(1);
		});
		
	</script>

</body>
</html>

