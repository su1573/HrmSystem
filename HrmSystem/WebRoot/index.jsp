<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>mms人事管理系统--首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.js"></script>
	<script type="text/javascript">
		$("#imgbtn").click(function(){
	    		window.location = "${pageContext.request.contextPath}/";
	    	})
		
	</script>
  </head>
  
  <body >
     
     <div style="width: 1394px;height: 472px;background-image: url('${pageContext.request.contextPath}/images/firstBg.jpg');">
     	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
     	<div style="width: 200px;height: 100px; margin: auto;">
     	<form action="main.action" method="post">
     		<input width="180px" height="65px" type="image" id="imgbtn" src="${pageContext.request.contextPath}/images/bt.png" 
     			onmouseover="this.src='${pageContext.request.contextPath}/images/button.png'" 
     			onmouseout="this.src='${pageContext.request.contextPath}/images/bt.png'" 
     			 />
     	</form>
     	</div>
     </div>
     
  </body>
</html>
