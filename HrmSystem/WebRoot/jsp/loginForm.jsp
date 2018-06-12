<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>mms人事管理系统--登录页面</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<link href="${pageContext.request.contextPath}/js/metronic/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/js/metronic/plugins/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/js/metronic/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/js/metronic/css/style-metro.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/js/metronic/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/js/metronic/css/style-responsive.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/js/metronic/css/themes/default.css" rel="stylesheet"
	type="text/css" id="style_color" />
<link href="${pageContext.request.contextPath}/js/metronic/plugins/uniform/css/uniform.default.css"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="${pageContext.request.contextPath}/js/metronic/css/pages/lock.css" rel="stylesheet"
	type="text/css" />
<!-- END PAGE LEVEL STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.js"></script>
<link href="${pageContext.request.contextPath}/js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />  
<script src="${pageContext.request.contextPath}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
<script type="text/javascript">
   if (window != top){
   		top.location.href = location.href; 
   } 
	
   $(function(){
	    /** 按了回车键 */
	   $(document).keydown(function(event){
		   if(event.keyCode == 13){
			   $("#login-submit-btn").trigger("click");
		   }
	   })

	   /** 给登录按钮绑定点击事件  */
	   $("#login-submit-btn").on("click",function(){
		   /** 校验登录参数 ctrl+K */
		   var loginname = $("#loginname").val();
		   var password = $("#password").val();
		   
		   var msg = "";
		   
		  
		   if(msg !=""){
			   $.ligerDialog.error(msg);
			   return;
		   }
		   /** 提交表单 */
		   $("#loginForm").submit();
		   
	   })
	   
   })
 


</script>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body style="font-family: 微软雅黑;background-color: black;">
	<div class="page-lock">
		<div class="page-logo" style="margin-bottom: 2px">
			<a class="brand" href="login.html"
				style="font-size: 22px; color: #FFF;"> 人事管理<font color="#FFCC00">Hrm</font><span
				style="font-size: 13px;">1.0</span> 系统
			</a>
		</div>
		<form action="${pageContext.request.contextPath}/login.action" method="post" id="loginForm">
			<div class="page-body">
				<img class="page-lock-img"
					src="${pageContext.request.contextPath}/js/metronic/img/profile/logo2.jpg" alt="">
				<div class="page-lock-info">
					<span>&nbsp;</span> 
					<c:choose>
						<c:when test="${requestScope.message == null }">
							<span style="padding-top: 5px">允许以中文名称登录</span>
						</c:when>
						<c:otherwise>
							<span style="padding-top: 5px"><font color="red">${requestScope.message}</font></span>
						</c:otherwise>
					</c:choose>
					
					<div class="control-group">
		
						<div class="controls">
							<div class="input-icon left">
								<i class="icon-user"></i> <input
									class="m-wrap placeholder-no-fix" type="text" placeholder="帐号"
									id="loginname" name="loginName" value="su">
							</div>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<div class="input-icon left">
								<i class="icon-lock"></i> <input
									class="m-wrap placeholder-no-fix" type="password"
									placeholder="密码" id="password" name="loginPwd"
									value="1573">
							</div>
						</div>
					</div>
				</div>
				<div class="relogin">
						<!-- 单击登录 -->
						<button type="submit" id="login-submit-btn" class="btn green"
							style="margin-left: 20px">
							登录 <i class="m-icon-swapright m-icon-white"></i>
						</button>
				</div>
			</div>
			<div class="page-footer" style="color: #fff">
				兼容浏览器IE8+，最佳分辨率1280*800. <br>河南工业大学--甲骨文实训分部
			</div>
		</form>
	</div>
	
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script
		src="${pageContext.request.contextPath}/js/metronic/plugins/jquery-ui/jquery-ui-1.10.1.custom.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/metronic/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!--[if lt IE 9]>
   <script src="${pageContext.request.contextPath}/js/metronic/plugins/excanvas.js"></script>
   <script src="${pageContext.request.contextPath}/js/metronic/plugins/respond.js"></script>  
   <![endif]-->
	<script src="${pageContext.request.contextPath}/js/metronic/plugins/breakpoints/breakpoints.js"
		type="text/javascript"></script>
	<!-- IMPORTANT! jquery.slimscroll.min.js depends on jquery-ui-1.10.1.custom.min.js -->
	<script src="${pageContext.request.contextPath}/js/metronic/plugins/uniform/jquery.uniform.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script
		src="${pageContext.request.contextPath}/js/metronic/plugins/backstretch/jquery.backstretch.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<script src="${pageContext.request.contextPath}/js/metronic/scripts/app.js"></script>
	<script src="${pageContext.request.contextPath}/js/metronic/scripts/lock.js"></script>
	<script>
		$(function() {
			App.init();
			Lock.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-37564768-1' ]);
		_gaq.push([ '_setDomainName', 'keenthemes.com' ]);
		_gaq.push([ '_setAllowLinker', true ]);
		_gaq.push([ '_trackPageview' ]);
		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://'
					: 'http://')
					+ 'stats.g.doubleclick.net/dc.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
</body>
<!-- END BODY -->
</html>