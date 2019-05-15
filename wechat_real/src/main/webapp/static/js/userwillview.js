		//项目前缀
		var war="http://localhost:8080/wechat_real";
		
		//加载贴子
		function putpost(pn){
			$.ajax({
				url:war+"/wechat_findPost",
				data:"pn="+pn,
				type:"GET",
				success:function(result){
					var list=result.extend.pageInfo.list;
					$.each(list,function(index,item){
						var title=$("<h3></h3>").append(item.title);
						var main=$("<p></p>").append($("<span></span>").addClass("glyphicon glyphicon-time").attr("aria-hidden","true")).append(item.pdate)
								 .append("&nbsp;&nbsp;&nbsp;&nbsp;").append($("<span></span>").addClass("glyphicon glyphicon-eye-open").attr("aria-hidden","true")).append(item.hits)
								 .append("&nbsp;&nbsp;&nbsp;").append($("<span></span>").addClass("glyphicon glyphicon-thumbs-up").attr("aria-hidden","true")).append(item.goodnum)
								 .append("&nbsp;&nbsp;&nbsp;").append($("<span></span>").addClass("glyphicon glyphicon-thumbs-down").attr("aria-hidden","true")).append(item.badnum)
								 .addClass("ppo");
						var img=$("<img></img>").attr("src",war+"/image/"+item.pfile).addClass("ii");
						var c=$("<p></p>").append(item.pcontent.substring(0,15)).css("font-size","20px");
						var a=$("<a></a>").append("<br>").append(title).append(main).append(img).append(c).append("<br>");
						var dd=$("<div></div>").addClass("im col-md-6 r2").append(a);
						var dd2=$("<div></div>").addClass("row r1").append(dd);
						$("#p1").append(dd2);
					})
				}
			});
		}
		
		//按标签加载
		function putglabel(pn,glabel){
			$.ajax({
				url:war+"/wchat_findByGlabel",
				data:"pn="+pn+"&&glabel="+glabel,
				type:"GET",
				success:function(result){
					$("#one").empty();
					$("#two").empty();
					$("#page_nav").empty();
					//显示菜品
					seethefind(result);
					//显示分页条
					bulid_page_nav_glabel(result);
				}
			});
		}
		
		//加载 按菜系
		function putstyle(pn,gstyle){
			$.ajax({
				url:war+"/wechat_findByGstyle",
				data:"pn="+pn+"&&gstyle="+gstyle,
				type:"GET",
				success:function(result){
					$("#one").empty();
					$("#two").empty();
					$("#page_nav").empty();
					//显示菜品
					seethefind(result);
					//显示分页条
					bulid_page_nav_style(result);
				}
			});
		}
		
		//加载热门
		function putnew(pn,rule){
			$.ajax({
				url:war+"/wechat_findByHits",
				data:"pn="+pn+"&&rule="+rule,
				type:"GET",
				success:function(result){
					$("#one").empty();
					$("#two").empty();
					$("#page_nav").empty();
					//显示菜品
					seethefind(result);
					//解析显示分页条
					bulid_page_nav(result);
				}
			});
		}
		
		//显示菜品
		function seethefind(result){
			var list=result.extend.pageInfo.list;
			var i=0;
			$.each(list,function(index,item){
				var img=$("<img></img>").addClass("img-responsive")
				.attr("src",war+"/image/"+item.gcover);
				var p=$("<p></p>").addClass("p1").append(item.gname);
				var li=$("<li></li>").append($("<span></span>").append(item.ghits))
						.append($("<i></i>").addClass("like1"));
				var glabel=item.glabel.substring(0,8);
				var li2=$("<li></li>").append($("<span></span>").addClass("glyphicon glyphicon-tag").attr("aria-hidden","true")).append("&nbsp;&nbsp;").append($("<span></span>").append(glabel));
				var ul=$("<ul></ul>").append(li2).append(li).append($("<div></div>").addClass("clearfix")).addClass("product_but");
				var d1=$("<div></div>").addClass("content_box-grid").append(p).append(ul);
				var d2=$("<div></div>").addClass("view view-fifth").append(img).append(d1);
				var a=$("<a></a>").attr("href",war+"/userview/single.jsp?gid="+item.gid).append(d2).attr("target","_blank");
				var d3=$("<div></div>").addClass("content_box").append(a);
				var d4=$("<div></div>").addClass("col-md-3").append(d3);
				if(i<4)
					$("#one").append(d4);
				if(i>=4)
					$("#two").append(d4);
				i++;
			})
		}
		
		//解析显示分页条(最新/热门)
		function bulid_page_nav(result){
			$("#page_nav").empty();
			var way=$("#findway").val();
			var ul=$("<ul></ul>").addClass("pagination");
			var firstPageLi=$("<li></li>").append($("<a></a>").append("首页"));
			var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;"));
			if(result.extend.pageInfo.hasPreviousPage==false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				firstPageLi.click(function(){
					putnew(1,way);
				});
				
				prePageLi.click(function(){
					putnew(result.extend.pageInfo.pageNum-1,way);
				});
			}
			
			var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi=$("<li></li>").append($("<a></a>").append("末页"));
			if(result.extend.pageInfo.hasNextPage==false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				nextPageLi.click(function(){
					putnew(result.extend.pageInfo.pageNum+1,way);
				});
				
				lastPageLi.click(function(){
					putnew(result.extend.pageInfo.pages,way);
				});
			}
			
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numLi=$("<li></li>").append($("<a></a>").append(item));
				if(result.extend.pageInfo.pageNum==item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					putnew(item,way);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var nav=$("<nav></nav>").append(ul).appendTo("#page_nav");
		}
		
		//加载选择按钮
		function putbtn(){
			var l1=new Array("鲁菜","川菜","粤菜","苏菜","闽菜","徽菜","湘菜","浙菜","早餐","午餐","晚餐");
			var l2=new Array("点心","面包","蛋糕","饼干","肉类","蔬菜","汤粥","水果","广州菜","潮州菜","客家菜","上河帮","小河帮","下河帮","济南菜","胶东菜","孔府菜","博山菜","淮扬菜","苏锡菜","金陵菜","徐海菜");
			$.each(l1,function(index,item){
				var btn=$("<a></a>").append(item).addClass("aa fstyle").attr("fv",item);
				$("#dd1").append(btn).append("&nbsp;&nbsp;&nbsp;");
			});
			var i=1;
			$.each(l2,function(index,item){
				var btn=$("<a></a>").append(item).addClass("aa fglabel").attr("fvalue",item);
				
				if(i==14)
					$("#dd2").append(btn).append("<br>");
				if(i!=14)
				$("#dd2").append(btn).append("&nbsp;&nbsp;&nbsp;");
				i++;
			});
		}
			
		//加载每日热门
		function putlist(){
			$.ajax({
				url:war+"/wechat_findByHits",
				data:"rule=hot",
				type:"GET",
				success:function(result){
					var emps=result.extend.pageInfo.list;
					$.each(emps,function(index,item){
						var a=$("<a></a>").append(item.gname).attr("href",war+"/userview/single.jsp?gid="+item.gid);
						var li=$("<li></li>").append(a);
						$("#ll").append(li);				  
					});
				}
			});
		}
		
		//加载热门讨论
		function puthotpost(){
			$.ajax({
				url:war+"/getpostbyhits",
				type:"GET",
				success:function(result){
					var emps=result.extend.pageInfo.list;
					var i=0;
					$.each(emps,function(index,item){
						if(i==0){
							var l1=$("<li></li>").addClass("review1_img")
									.append($("<img></img>").addClass("img-responsive")
									.attr("src",war+"/image/"+item.pfile));
							var l2=$("<li></li>").addClass("review1_desc").append($("<h3></h3>")
									.append($("<a></a>").append(item.title))).append($("<p></p>")
											.append(item.pdate));
							$("#u1").append(l1).append(l2).append($("<div></div>").addClass("clearfix"));
						}	
						if(i==1){
							var l1=$("<li></li>").addClass("review1_img")
									.append($("<img></img>").addClass("img-responsive")
									.attr("src",war+"/image/"+item.pfile));
							var l2=$("<li></li>").addClass("review1_desc").append($("<h3></h3>")
									.append($("<a></a>").append(item.title))).append($("<p></p>")
											.append(item.pdate));
							$("#u2").append(l1).append(l2).append($("<div></div>").addClass("clearfix"));
						}		
						if(i==2){
							var l1=$("<li></li>").addClass("review1_img")
									.append($("<img></img>").addClass("img-responsive")
									.attr("src",war+"/image/"+item.pfile));
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
		
		
		//解析显示分页条   (菜系)
		function bulid_page_nav_style(result){
			$("#page_nav").empty();
			var way=$("#findway").val();
			var ul=$("<ul></ul>").addClass("pagination");
			var firstPageLi=$("<li></li>").append($("<a></a>").append("首页"));
			var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;"));
			if(result.extend.pageInfo.hasPreviousPage==false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				firstPageLi.click(function(){
					putstyle(1,way);
				});
				
				prePageLi.click(function(){
					putstyle(result.extend.pageInfo.pageNum-1,way);
				});
			}
			
			var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi=$("<li></li>").append($("<a></a>").append("末页"));
			if(result.extend.pageInfo.hasNextPage==false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				nextPageLi.click(function(){
					putstyle(result.extend.pageInfo.pageNum+1,way);
				});
				
				lastPageLi.click(function(){
					putstyle(result.extend.pageInfo.pages,way);
				});
			}
			
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numLi=$("<li></li>").append($("<a></a>").append(item));
				if(result.extend.pageInfo.pageNum==item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					putstyle(item,way);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var nav=$("<nav></nav>").append(ul).appendTo("#page_nav");
		}
		
		//解析显示分页条   (标签)
		function bulid_page_nav_glabel(result){
			$("#page_nav").empty();
			var way=$("#findway").val();
			var ul=$("<ul></ul>").addClass("pagination");
			var firstPageLi=$("<li></li>").append($("<a></a>").append("首页"));
			var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;"));
			if(result.extend.pageInfo.hasPreviousPage==false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				firstPageLi.click(function(){
					putglabel(1,way);
				});
				
				prePageLi.click(function(){
					putglabel(result.extend.pageInfo.pageNum-1,way);
				});
			}
			
			var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi=$("<li></li>").append($("<a></a>").append("末页"));
			if(result.extend.pageInfo.hasNextPage==false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				nextPageLi.click(function(){
					putglabel(result.extend.pageInfo.pageNum+1,way);
				});
				
				lastPageLi.click(function(){
					putglabel(result.extend.pageInfo.pages,way);
				});
			}
			
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numLi=$("<li></li>").append($("<a></a>").append(item));
				if(result.extend.pageInfo.pageNum==item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					putglabel(item,way);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var nav=$("<nav></nav>").append(ul).appendTo("#page_nav");
		}