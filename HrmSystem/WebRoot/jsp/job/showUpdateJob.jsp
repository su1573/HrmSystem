<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>人事管理系统——修改职位</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${pageContext.request.contextPath}/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${pageContext.request.contextPath}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/css/pager.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
	 $(function(){
	    	/** 职位表单提交 */
			$("#jobForm").submit(function(){
				var name = $("#name");
				var remark = $("#remark");
				var tipInfo = $("#tipInfo").text();
				var msg = "";
				if ($.trim(name.val()) == ""){
					msg = "职位名称不能为空！";
					name.focus();
				}else if ($.trim(remark.val()) == ""){
					msg = "详细描述不能为空！";
					remark.focus();
				}else if(tipInfo == "该职位已存在"){
					msg="职位名称重复，请重新输入";
				}
				if (msg != ""){
					$.ligerDialog.error(msg);
					return false;
				}else{
					return true;
				}
				$("#jobForm").submit();
			});
	    });
		function checkName(Name){
		var Name = Name.value;
		if(Name == ""){
			alert("号码不能为空");
			Name.focus();
			return ;
		}
		//获取xmlHttpRequest对象
		createXmlHttpRequest();
		//拼写访问服务器的url
		var url = "${pageContext.request.contextPath}/findAllJob.action?jobName="+Name;
		//xmlHttpRequest对象设置回掉函数
		xmlHttpRequest.onreadystatechange=checkNameExistCallBack;
		//设置请求参数
		xmlHttpRequest.open("GET",url,true);
		//发送请求
		xmlHttpRequest.send(null);
	}
	
	
	
	function createXmlHttpRequest(){
		if(window.XMLHttpRequest){ //判断当前浏览器是不是支持xmlHttpRequest对象，支持返回true
			xmlHttpRequest = new XMLHttpRequest(); //浏览器支持xmlHttpRequest对象，并创建xmlHttpRequest对象
		}else{
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");//浏览器不支持xmlHttpRequest对象，并创建代理xmlHttpRequest对象
		}
	}
	
	function checkNameExistCallBack(){
	
		//请求完成并成功返回，等于4和200
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var result = xmlHttpRequest.responseText;
			
			if(result == "true"){
				document.getElementById("tipInfo").innerHTML="该职位已存在";
			}else{
				document.getElementById("tipInfo").innerHTML="";
			}
			
		}
	}
	function clearInfo(){
		document.getElementById("tipInfo").innerHTML="";
	}

	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：职位管理  &gt; 修改职位</td>
	<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 <form action="${pageContext.request.contextPath}/updateJob.action" id="jobForm" method="post">
    	 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
    	 	<input type="hidden" name="jobId" value="${job.jobId }">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">部门名称：<input type="text" name="jobName" id="name" onblur="checkName(this)" onfocus="clearInfo()" size="20" value="${job.jobName }"/></td>
		    			<td><span  id="tipInfo" style="color: red;font-size: 12px"></span><br></td>
		    			<td class="font3 fftd">详细描述：<input type="text" name="jobDesc" id="remark" size="20" value="${job.jobDesc }"/></td>
		    		</tr>
		    			
		    	</table>
		    </td></tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr><td align="left" class="fftd"><input type="submit" value="修改 ">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>
</body>
</html>