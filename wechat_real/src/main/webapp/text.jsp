<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑图文信息</title>
    <script type="text/javascript" charset="utf-8" src="/wechat_real/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/wechat_real/utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="/wechat_real/utf8-jsp/lang/zh-cn/zh-cn.js"></script>

    
</head>
<body>
	<form action="/wechat_real/addPost" enctype="multipart/form-data" method="post">
		<input type="text" name="title">
		<input type="text" name="uid">
		<input type="text" name="pcontent">
		<input type="file" name="file">
		<input type="submit">
	</form>
</body>
</html>