<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>消息推送</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<div align="center" style="margin-top: 10%">

		推送消息类型<select name="msgType">
			<option>新闻</option>
			<option>直播</option>
			<option>系统通知</option>
			<option>版本更新</option>
		</select>
	</div>
	<div align="center" style="margin-top: 2%">
	<input type="radio" value="" name="all"/>全部设备
	<input type="radio" value="" name="all"/>指定TAG设备
	<input type="radio" value="" name="all"/>指定TOKEN设备
	</div>
	<div style="margin-top: 2%" align="center">
	TAG名称<input type="text" >
	</div>
	<div align="center" style="margin-top: 2%">
	TOKEN名称<input type="text"> 
	</div>
	<div align="center" style="margin-top: 2%">
	消息内容<input type="text">
	</div>
</body>
</html>
