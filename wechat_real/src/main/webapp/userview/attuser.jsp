<%@page import="com.wechat.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>关注用户</title>
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
	.a1{
		color: #000;
	}
	
	.img_manager{
		width: 55px;
		height: 55px;
	}
	.t1{
		font-size: 22px;
		padding-bottom: 20px;
		padding-left: 100px;
	}
	.t2{
		font-size: 12px;
		padding-top:5px;
		padding-left: 12px;
		padding-bottom: 20px;
	}
	.t3{
		padding-left: 10px;
		padding-bottom: 20px;
	}
	.t4{
		padding-left: 100px;
	}
	.t5{
		padding-left: 10px;
		padding-bottom: 20px;
	}
	.t6{
		padding-left: 100px;
		padding-bottom: 20px;
		font-size: 20px;
		font-family: STHupo;
		color: #708090;
	}
	.ii{
		width: 500px;
	}
	.r1{
		margin-left: 10px;
	}
	.r2{
		margin-top: 6px;
		margin-bottom: 6px;
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
			      	<li><a href="${APP_PATH}/userview/userindex.jsp">首页</a></li>
			        <li><a href="${APP_PATH}/userview/allgreens.jsp">菜品大全</a></li>
			        <li><a href="${APP_PATH}/userview/userpost.jsp">厨分享</a></li>
			       	<li class="active"><a href="${APP_PATH}/userview/myset.jsp">我的</a></li>
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
			       <a href="${APP_PATH}/userview/userpost.jsp">更多讨论<i class="but_arrow"> </i></a>
			    </div>
		   	   </ul> 
		   	   <input type="hidden" id="uid" value="<%=request.getParameter("nid")%>">
		   	   
		   	</div>
		   	<div class="col-md-9 im">
		   		<br>
		   		<% User user2=(User)session.getAttribute("user"); 
		   	   	  if(user2!=null){ %>
		   	   		<input type="hidden" id="uuid" value="<%=user2.getUid()%>">
		   	    <% }else{
		   	    %>
		   	    <input type="hidden" id="uuid">
		   	    <% } %>
		   	   
		   		<div class="row" style="margin-left: 10px;">
		   			<img class="img_manager img-circle" id="iig" alt="photo">		
			    	&nbsp;&nbsp;&nbsp;&nbsp;
			    	<label class="ln" id="un">
			    		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
			    	</label>
			    	<label id="pan">
				    	<button class="btn btn-info" style="margin-left: 20px;">
				    		关注
				    	</button>
			    	</label>
				</div>
		
		   <br>
		   			<!-- 显示关注栏 -->
		   			<div class="row">
		   				<div class="col-md-6">
			   				<ul class="nav nav-tabs" id="uul">
							  <li role="presentation" class="active"><a class="att" vv="user">关注</a></li>
							  <li role="presentation"><a class="att" vv="comment">评论</a></li>
							  <li role="presentation"><a class="att" vv="gp">分享贴</a></li>
							</ul>
						</div>
		   			</div><br>
		   			<div class="row">
		   				<div class="col-md-12">
		   					<table id="see">
		   					</table>
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
			//加载用户
			putuser();
			//加载关注
			putatt();
			//关注或已关注按钮
			outatt();
		});
		
		//关注或已关注按钮
		function outatt(){
			var uid=$("#uuid").val();
			var nid=$("#uid").val();
			if(uid==""){
				$("#pan").empty();
				var btn=$("<button></button>").append("关注").addClass("btn btn-info sa").css("margin-left","20px");
				$("#pan").append(btn);
			}else{
				$.ajax({
					url:"${APP_PATH}/panattention",
					data:"uid="+uid+"&&nid="+nid+"&&type=user",
					type:"GET",
					success:function(result){
						if(result.extend.state==0){
							$("#pan").empty();
							var btn=$("<button></button>").append("已关注").addClass("btn btn-link had").css("margin-left","20px");
							$("#pan").append(btn);
						}else{
							$("#pan").empty();
							var btn=$("<button></button>").append("关注").addClass("btn btn-info none").css("margin-left","20px");
							$("#pan").append(btn);
						}
					}
				});
			}
		}
		
		$(document).on("click",".sa",function(){
			alert("您还没有登录，需要登录才能关注用户");
		});
		
		//取消关注
		$(document).on("click",".had",function(){
			var uid=$("#uuid").val();
			var nid=$("#uid").val();
			$.ajax({
				url:"${APP_PATH}/deleteAttention",
				data:"uid="+uid+"&&nid="+nid+"&&type=user",
				type:"GET",
				success:function(result){
					$("#pan").empty();
					var btn=$("<button></button>").append("关注").addClass("btn btn-info none").css("margin-left","20px");
					$("#pan").append(btn);
				}
			});
		});
		
		//添加关注
		$(document).on("click",".none",function(){
			var uid=$("#uuid").val();
			var nid=$("#uid").val();
			$.ajax({
				url:"${APP_PATH}/addattention",
				data:"uid="+uid+"&&nid="+nid+"&&type=user",
				type:"GET",
				success:function(result){
					$("#pan").empty();
					var btn=$("<button></button>").append("已关注").addClass("btn btn-link had").css("margin-left","20px");
					$("#pan").append(btn);
				}
			});
		});
		
		//加载用户
		function putuser(){
			var uid=$("#uid").val();
			$.ajax({
				url:"${APP_PATH}/finduserbyuid",
				data:"uid="+uid,
				type:"GET",
				success:function(result){
					$("#iig").attr("src","${APP_PATH}/image/"+result.extend.user.purl);
					$("#un").append("用户："+result.extend.user.uname);
				}
			});
		}
		
		//加载关注
		function putatt(){
			var uid=$("#uid").val();
			if(uid!=""){
				//放关注的数据
				putattdata(uid);
			}
		}	
		
		//放关注的数据
		function putattdata(uid){
			$.ajax({
				url:"${APP_PATH}/findAllattention",
				data:"uid="+uid+"&&type=user",
				type:"GET",
				success:function(result){
					var list=result.extend.list;
					if(list==""){
						$("<tr></tr>").append($("<td></td>").addClass("t6").append("该用户还没有关注其他人")).append("&nbsp;&nbsp;&nbsp;&nbsp;").appendTo("#see");

					}
					$.each(list,function (index,item) {
						var img=$("<img></img>").addClass("img_manager img-circle").attr("src","${APP_PATH}/image/"+item.purl);
						var a2=$("<a></a>").attr("href","${APP_PATH}/userview/attuser.jsp?nid="+item.uid).append(img).addClass("a1");
						var sp=$("<span></span>").addClass("glyphicon glyphicon-user").attr("aria-hidden","true");
						var l=$("<label></label>").addClass("ln").append(sp).append("&nbsp;&nbsp;").append(item.uname);
						var a1=$("<a></a>").attr("href","${APP_PATH}/userview/attuser.jsp?nid="+item.uid).append(l).addClass("a1");
						var cdate=$("<td></td>").addClass("t2").append(item.cdate);
						var delBtn=$("<button></button>").addClass("btn btn-info btn-sm del_att")
                        .append($("<span></span>").append("&nbsp;取消关注"));
	                    delBtn.attr("del-nid",item.uid);
	                    var t=$("<td></td>").addClass("t5").append(delBtn);
						$("<tr></tr>").append($("<td></td>").addClass("t5").append(a2).append("&nbsp;&nbsp;&nbsp;&nbsp;").append(a1)).append(t).appendTo("#see");
					})
				}
			});
		}
		
		 //删除操作
        $(document).on("click",".del_att",function () {
            var nid=$(this).attr("del-nid");
            var uid=$("#uid").val();
            if (confirm("确认取消关注吗？")) {
                $.ajax({
                    url : "${APP_PATH}/deleteAttention",
                    data:"uid="+uid+"&&nid="+nid+"&&type=user",
                    type: "GET",
                    success : function(result) {
                    	$("#uul").empty();
        				$("#see").empty();
        				var a1=$("<a></a>").addClass("att").attr("vv","user").append("关注");
        				var l1=$("<li></li>").attr("role","presentation").append(a1).addClass("active");
        				var a2=$("<a></a>").addClass("att").attr("vv","comment").append("评论");
        				var l2=$("<li></li>").attr("role","presentation").append(a2);
        				var a3=$("<a></a>").addClass("att").attr("vv","gp").append("分享贴");
        				var l3=$("<li></li>").attr("role","presentation").append(a3);
        				$("#uul").append(l1).append(l2).append(l3);
        				putattdata(uid);
                    }
                });
            }
        });
		
		//关注栏显示
		$(document).on("click",".att",function(){
			var type=$(this).attr("vv");
			if(type=="user"){
				$("#uul").empty();
				$("#see").empty();
				var a1=$("<a></a>").addClass("att").attr("vv","user").append("关注");
				var l1=$("<li></li>").attr("role","presentation").append(a1).addClass("active");
				var a2=$("<a></a>").addClass("att").attr("vv","comment").append("评论");
				var l2=$("<li></li>").attr("role","presentation").append(a2);
				var a3=$("<a></a>").addClass("att").attr("vv","gp").append("分享贴");
				var l3=$("<li></li>").attr("role","presentation").append(a3);
				$("#uul").append(l1).append(l2).append(l3);
				var uid=$("#uid").val();
				putattdata(uid);
			}
			if(type=="comment"){
				$("#uul").empty();
				$("#see").empty();
				var a1=$("<a></a>").addClass("att").attr("vv","user").append("关注");
				var l1=$("<li></li>").attr("role","presentation").append(a1);
				var a2=$("<a></a>").addClass("att").attr("vv","comment").append("评论");
				var l2=$("<li></li>").attr("role","presentation").append(a2).addClass("active");
				var a3=$("<a></a>").addClass("att").attr("vv","gp").append("分享贴");
				var l3=$("<li></li>").attr("role","presentation").append(a3);
				$("#uul").append(l1).append(l2).append(l3);
				var uid=$("#uid").val();
				addmycomment(1,uid);
			}
			if(type=="gp"){
				$("#uul").empty();
				$("#see").empty();
				var a1=$("<a></a>").addClass("att").attr("vv","user").append("关注");
				var l1=$("<li></li>").attr("role","presentation").append(a1);
				var a2=$("<a></a>").addClass("att").attr("vv","comment").append("评论");
				var l2=$("<li></li>").attr("role","presentation").append(a2);
				var a3=$("<a></a>").addClass("att").attr("vv","gp").append("分享贴");
				var l3=$("<li></li>").attr("role","presentation").append(a3).addClass("active");
				$("#uul").append(l1).append(l2).append(l3);
				var uid=$("#uid").val();
				addmypost(1,uid);
			}
		});
		
		
		//查找某一用户所有贴子
		function addmypost(pn,uid){
			$.ajax({
				url:"${APP_PATH}/findpostByuid",
				data:"pn="+pn+"&&uid="+uid,
				type:"GET",
				success:function(result){
					var list=result.extend.pageInfo.list;
					if(list==""){
						$("<tr></tr>").append($("<td></td>").addClass("t6").append("该用户还没有发过分享贴")).append("&nbsp;&nbsp;&nbsp;&nbsp;").appendTo("#see");
					}
					$.each(list,function (index,item) {
						var title=$("<h3></h3>").append(item.title);
						var main=$("<p></p>").append($("<span></span>").addClass("glyphicon glyphicon-time").attr("aria-hidden","true")).append(item.pdate)
								 .append("&nbsp;&nbsp;&nbsp;&nbsp;").append($("<span></span>").addClass("glyphicon glyphicon-eye-open").attr("aria-hidden","true")).append(item.hits)
								 .append("&nbsp;&nbsp;&nbsp;").append($("<span></span>").addClass("glyphicon glyphicon-thumbs-up").attr("aria-hidden","true")).append(item.goodnum)
								 .append("&nbsp;&nbsp;&nbsp;").append($("<span></span>").addClass("glyphicon glyphicon-thumbs-down").attr("aria-hidden","true")).append(item.badnum)
								 .addClass("ppo");
						var img=$("<img></img>").attr("src","${APP_PATH}/image/"+item.pfile).addClass("ii");
						var c=$("<p></p>").append(item.pcontent.substring(0,15)).css("font-size","20px");
						var a=$("<a></a>").addClass("a1").attr("target","_blank").attr("href","${APP_PATH}/userview/seeonepost.jsp?pid="+item.pid).append("<br>").append(title).append(main).append(img).append(c).append("<br>");
						var dd=$("<div></div>").addClass("im col-md-12 r2").append(a);
						var dd2=$("<div></div>").addClass("row r1").append(dd);
						$("<tr></tr>").append($("<td></td>").append(dd2).addClass("t4")).appendTo("#see");
					})
				}
			});
		}
		
		//查找某一用户的所有评论
		function addmycomment(pn,uid){
			$.ajax({
				url:"${APP_PATH}/findcommentbyuid",
				data:"pn="+pn+"&&uid="+uid,
				type:"GET",
				success:function(result){
					var emps=result.extend.pageInfo.list;
					if(emps==""){
						$("<tr></tr>").append($("<td></td>").addClass("t6").append("该用户还没有发表过评论")).append("&nbsp;&nbsp;&nbsp;&nbsp;").appendTo("#see");
					}
					$.each(emps,function (index,item) {
						var type=item.ctype;
						var commentTd;
						if(type=="post"){
							var a1=$("<a></a>").addClass("a1").attr("target","_blank").attr("href","${APP_PATH}/userview/seeonepost.jsp?pid="+item.typeid).append(item.comment);
							commentTd=$("<td></td>").addClass("t1").append(a1);
						}
						if(type=="greens"){
							var a2=$("<a></a>").addClass("a1").attr("href","${APP_PATH}/userview/single.jsp?gid="+item.typeid).append(item.comment).attr("target","_blank");
							commentTd=$("<td></td>").addClass("t1").append(a2);
						}
						var cdate=$("<td></td>").addClass("t2").append(item.cdate);
						var delBtn=$("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                        .append($("<span></span>").addClass("glyphicon glyphicon-trash").append("删除"));
	                    //为删除按钮添加一个自定义的属性来表示当前的删除的员id
	                    delBtn.attr("del-id",item.cid);
	                    var btnTd = $("<td></td>").append(delBtn).addClass("t3");
                        $("<tr></tr>").append(commentTd).append(cdate).append(btnTd).appendTo("#see");
                    })
				}	
			});
		}
		
		 //删除操作
        $(document).on("click",".delete_btn",function () {
            // alert($(this).parents("tr").find("td:eq(1)").text());
            var uid=$(this).parents("tr").find("td:eq(2)").text();
            var cid=$(this).attr("del-id");
            if (confirm("确认删除该评论吗？")) {
                $.ajax({
                    url : "${APP_PATH}/deletecommentbycid/"+cid,
                    type : "DELETE",
                    success : function(result) {
                    	$("#uul").empty();
        				$("#see").empty();
        				var a1=$("<a></a>").addClass("att").attr("vv","user").append("关注");
        				var l1=$("<li></li>").attr("role","presentation").append(a1);
        				var a2=$("<a></a>").addClass("att").attr("vv","comment").append("评论");
        				var l2=$("<li></li>").attr("role","presentation").append(a2).addClass("active");
        				var a3=$("<a></a>").addClass("att").attr("vv","gp").append("分享贴");
        				var l3=$("<li></li>").attr("role","presentation").append(a3);
        				$("#uul").append(l1).append(l2).append(l3);
        				var uid=$("#uid").val();
        				addmycomment(1,uid);
                    }
                });
            }
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
									.append($("<a></a>").attr("href","${APP_PATH}/userview/seeonepost.jsp?pid="+item.pid).append(item.title))).append($("<p></p>")
											.append(item.pdate));
							$("#u1").append(l1).append(l2).append($("<div></div>").addClass("clearfix"));
						}	
						if(i==1){
							var l1=$("<li></li>").addClass("review1_img")
									.append($("<img></img>").addClass("img-responsive")
									.attr("src","${APP_PATH}/image/"+item.pfile));
							var l2=$("<li></li>").addClass("review1_desc").append($("<h3></h3>")
									.append($("<a></a>").attr("href","${APP_PATH}/userview/seeonepost.jsp?pid="+item.pid).append(item.title))).append($("<p></p>")
											.append(item.pdate));
							$("#u2").append(l1).append(l2).append($("<div></div>").addClass("clearfix"));
						}		
						if(i==2){
							var l1=$("<li></li>").addClass("review1_img")
									.append($("<img></img>").addClass("img-responsive")
									.attr("src","${APP_PATH}/image/"+item.pfile));
							var l2=$("<li></li>").addClass("review1_desc").append($("<h3></h3>")
									.append($("<a></a>").attr("href","${APP_PATH}/userview/seeonepost.jsp?pid="+item.pid).append(item.title))).append($("<p></p>")
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

