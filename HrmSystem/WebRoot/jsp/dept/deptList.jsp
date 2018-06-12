<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.su.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>人事管理系统 ——部门管理</title>
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
		function one(frm,num){ 
		frm.currentPage.value=num;
		frm.submit();
	}
	function jump_to(frm,pageNo){
		var reg=/^\d+$/;
	    if(!reg.test(pageNo)){
			alert("请输入正确数字");
		}else{
			one(frm,pageNo);
		}
	}
	
		$(function(){
	 	   /** 获取上一次选中的部门数据 */
	 	   var boxs  = $("input[type='checkbox'][id^='box_']");
	 	   
	 	  /** 给全选按钮绑定点击事件  */
	    	$("#checkAll").click(function(){
	    		// this是checkAll  this.checked是true
	    		// 所有数据行的选中状态与全选的状态一致
	    		boxs.attr("checked",this.checked);
	    	})
	    	
	 	  /** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
	    	$("tr[id^='data_']").hover(function(){
	    		$(this).css("backgroundColor","#eeccff");
	    	},function(){
	    		$(this).css("backgroundColor","#ffffff");
	    	})
	    	
	    	
	 	   /** 删除员工绑定点击事件 */
	 	   $("#delete").click(function(){
	 		   /** 获取到用户选中的复选框  */
	 		   var checkedBoxs = boxs.filter(":checked");
	 		   if(checkedBoxs.length < 1){
	 			   $.ligerDialog.error("请选择一个需要删除的部门！");
	 		   }else{
	 			   /** 得到用户选中的所有的需要删除的ids */
	 			   var ids = checkedBoxs.map(function(){
	 				   return this.value;
	 			   })
	 			   
	 			   $.ligerDialog.confirm("确认要删除吗?","删除部门",function(r){
	 				   if(r){
	 					   // alert("删除："+ids.get());
	 					   // 发送请求
	 					   window.location = "${pageContext.request.contextPath}/removeDept.action?ids=" + ids.get();
	 				   }
	 			   });
	 		   }
	 	   })
	    })
	</script>
</head>
<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr><td height="10"></td></tr>
	  <tr>
	    <td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
		<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：部门管理 &gt; 部门查询</td>
		<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
	  </tr>
	</table>
	<form name="empform0" method="post" id="empform0" action="${pageContext.request.contextPath}/findDeptByPage.action">
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
	  <!-- 查询区  -->
	  <tr valign="top">
	    <td height="30">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr>
			  <td class="fftd">
			  	
				    <table width="100%" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td class="font3">
					    	部门名称：<input type="text" name="deptName" value="${requestScope.name }">
					    	<input type="hidden" name="currentPage" value="1">
					    	&nbsp;&nbsp;&nbsp;&nbsp;
					    	 <input type="submit" value="搜索"/>
					    	<input id="delete" type="button" value="删除"/>
					    </td>
					  </tr>
					</table>
				
			  </td>
			</tr>
		  </table>
		</td>
	  </tr>
	  
	  <!-- 数据展示区 -->
	  <tr valign="top">
	    <td height="20">
		  <table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		    <tr class="main_trbg_tit" align="center">
			  <td><input type="checkbox" name="checkAll" id="checkAll"></td>
			  <td>部门名称</td>
			  <td>详细信息</td>
			  <td align="center">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.list}" var="dept" varStatus="stat">
				<tr id="data_${stat.index}" align="center" class="main_trbg" onMouseOver="move(this);" onMouseOut="out(this);">
					<td><input type="checkbox" id="box_${stat.index}" value="${dept.deptId}"></td>
					 <td>${dept.deptName }</td>
					  <td>${dept.deptDesc }</td>
					 <td align="center" width="40px;"><a href="${pageContext.request.contextPath}/updateDept.action?flag=1&deptId=${dept.deptId}">
							<img title="修改" src="${pageContext.request.contextPath}/images/update.gif"/></a>
					  </td>
				</tr>
			</c:forEach>
		  </table>
		</td>
	  </tr>
	  <!-- 分页标签 -->
	  <tr valign="top"><td align="center" class="font3">
	  <!--  
	  	  <c:if test="${page.currentPage>1}">
			<input type="button" onclick="javascript:one(document.forms[0],1);" value="首页"/>
			<input type="button" onclick="javascript:one(document.forms[0],${page.currentPage-1});" value="上一页"/>
		</c:if>
		<c:if test="${page.currentPage<page.totalPages}">
			<input type="button" onclick="javascript:one(document.forms[0],${page.currentPage+1});" value="下一页"/>
			<input type="button" onclick="javascript:one(document.forms[0],${page.totalPages});" value="末页"/>
		</c:if>
		<span>跳转至</span> <input type="text" name="inputPage" id="inputPage" value="${page.currentPage}" style="width:30px;text-align:center;"/>页
		<input type="button" onclick="javascript:jump_to(document.forms['empform0'],document.getElementById('inputPage').value)" value="GO"/>
	-->
		<% Page pageOne = (Page)request.getAttribute("page"); %>
		<% if(pageOne!=null) {for(int i=1;i<=pageOne.getTotalPages();i++){ %>
			<a href="javascript:one(document.forms[0],<%=i%>)"><font size="3px"><%=i%>&nbsp;</font></a>
		<% }} %>
		
		<br>
		搜索结果共<font style="color:red">${page.tatalNums }</font>条&nbsp;当前页${page.currentPage}/共${page.totalPages}页
		<span>跳转至</span><input type="text" name="inputPage" id="inputPage" value="${page.currentPage}" style="width:30px;text-align:center;"/>页
		<input type="button" onclick="javascript:jump_to(document.forms[0],document.getElementById('inputPage').value)" value="GO"/>
		<br>
		
	  </td></tr>
	</table>
	</form>
	<div style="height:10px;"></div>
	
</body>
</html>