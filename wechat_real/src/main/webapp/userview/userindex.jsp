<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
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
	.p1{
		font-size: 16px;
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
		   	<div class="col-md-9">
		   	   <ul class="feature">
		   	   	 <h3><i class="arrow"> </i><span>今日新闻</span></h3>
		   	   </ul>
		   	   <ul class="feature_grid">
				 <li class="grid1"><img src="images/f1.jpg" class="img-responsive" alt=""/>
				 	<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed</p>
				 	<div class="price">Price:
					  <span class="actual">$12.00</span>
					</div>
				    <div class="but1">
			          <a href="#">Buy Now</a>
			        </div>
				 </li>		   	   	
				 <li class="grid1"><img src="images/f2.jpg" class="img-responsive" alt=""/>
				 	<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed</p>
				 	<div class="price">Price:
					  <span class="actual">$12.00</span>
					</div>
				    <div class="but1">
			          <a href="#">Buy Now</a>
			        </div>
				 </li>		   	
				 <li class="grid2"><img src="images/f3.jpg" class="img-responsive" alt=""/>
				 	<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed</p>
				 	<div class="price">Price:
					  <span class="actual">$12.00</span>
					</div>
				    <div class="but1">
			          <a href="#">Buy Now</a>
			        </div>
				 </li>		   	
				 <div class="clearfix"> </div>
		   	   </ul>
		   	    <ul class="feature">
		   	   	 <h3><a id="new"><i class="arrow"></i><span>智能推荐</span></a></h3>
		   	   </ul>
		   	   <div class="row content_bottom" id="one">
			   	   
			   </div>
			   <div class="row content_bottom1" id="two">
			   </div>
			   
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
			//加载推荐
			putgreens();
		});
		
		//刷新推荐
		$("#new").click(function(){
			$("#one").empty();
			$("#two").empty();
			//加载推荐
			putgreens();
		});
		
		//加载推荐
		function putgreens(){
			$.ajax({
				url:"${APP_PATH}/random_greens",
				type:"GET",
				success:function(result){
					var list=result.extend.list;
					var i=0;
					$.each(list,function(index,item){
						var img=$("<img></img>").addClass("img-responsive")
						.attr("src","${APP_PATH}/image/"+item.gcover);
						var p=$("<p></p>").addClass("p1").append(item.gname);
						var li=$("<li></li>").append($("<span></span>").append(item.ghits))
								.append($("<i></i>").addClass("like1"));
						var glabel=item.glabel.substring(0,8);
						var li2=$("<li></li>").append($("<span></span>").addClass("glyphicon glyphicon-tag").attr("aria-hidden","true")).append("&nbsp;&nbsp;").append($("<span></span>").append(glabel));
						var ul=$("<ul></ul>").append(li2).append(li).append($("<div></div>").addClass("clearfix")).addClass("product_but");
						var d1=$("<div></div>").addClass("content_box-grid").append(p).append(ul);
						var d2=$("<div></div>").addClass("view view-fifth").append(img).append(d1);
						var a=$("<a></a>").attr("href","${APP_PATH}/userview/single.jsp?gid="+item.gid).append(d2).attr("target","_blank");
						var d3=$("<div></div>").addClass("content_box").append(a);
						var d4=$("<div></div>").addClass("col-md-3").append(d3);
						if(i<4)
							$("#one").append(d4);
						if(i>=4)
							$("#two").append(d4);
						i++;
					})
				}
			});
		}
			
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

