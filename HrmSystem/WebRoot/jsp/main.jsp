<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>mms人事管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  <frameset rows="80,*" cols="*" frameborder="no" border="0" framespacing="0">
  	<frame src="${pageContext.request.contextPath}/jsp/top.jsp" name="title" scrolling="no" noresize="noresize">
  	<frameset cols="220,*" frameborder="no" border="0" framespacing="0">
  		<frame src="${pageContext.request.contextPath}/jsp/left.jsp" name="tree" scrolling="no" marginheight="0" marginwidth="0">
  		<frame src="${pageContext.request.contextPath}/jsp/right.jsp" name="main" scrolling="yes" marginheight="0" marginwidth="0" frameborder="0" noresize="noresize">
  	</frameset>
  </frameset>
  
  <body>
  </body>
</html>
