<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.su.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>人事管理系统 ——文档管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${pageContext.request.contextPath}/css/css.css" type="text/css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/pager.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.js"></script>
	<link href="${pageContext.request.contextPath}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css" rel="stylesheet" type="text/css" />  
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
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
	    	
	    	var boxs = $("input[type='checkbox'][id^='box_']");
	    	/** 给全选按钮绑定点击事件  */
	    	$("#checkAll").click(function(){
	    		// this是checkAll  this.checked是true
	    		// 所有数据行的选中状态与全选的状态一致
	    		boxs.attr("checked",this.checked);
	    	})
	    	
	    	/** 给每个数据行绑定点击事件：判断如果数据行都选中全选也应该选中，反之  */
	    	boxs.click(function(event){
	    		/** 去掉复选按钮的事件传播：点击复选会触发行点击：因为复选在行中 */
	    		event.stopPropagation();
	    		
	    		/** 判断当前选中的数据行有多少个  */
	    		var checkedBoxs = boxs.filter(":checked");
	    		/** 判断选中的总行数是否等于总行数：以便控制全选按钮的状态   */
	    		$("#checkAll").attr("checked",checkedBoxs.length == boxs.length);
	    	})
	    	
	    	/** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
	    	$("tr[id^='data_']").hover(function(){
	    		$(this).css("backgroundColor","#eeccff");
	    	},function(){
	    		$(this).css("backgroundColor","#ffffff");
	    	}).click(function(){
	    		/** 控制该行是否需要被选中 */
	    		/** 获取此行的复选框id */
	    		var checkboxId = this.id.replace("data_","box_");
	    		
	    		/** 触发本行的复选点击 */
	    		$("#"+checkboxId).trigger("click");
	    	})
	    	
	    	/** 删除员工绑定点击事件 */
	 	   $("#delete").click(function(){
	 		   /** 获取到用户选中的复选框  */
	 		   var checkedBoxs = boxs.filter(":checked");
	 		   if(checkedBoxs.length < 1){
	 			   $.ligerDialog.error("请选择一个需要删除的文档！");
	 		   }else{
	 			   /** 得到用户选中的所有的需要删除的ids */
	 			   var ids = checkedBoxs.map(function(){
	 				   return this.value;
	 			   })
	 			   
	 			   $.ligerDialog.confirm("确认要删除吗?","删除文档",function(r){
	 				   if(r){
	 					   // alert("删除："+ids.get());
	 					   // 发送请求
	 					   window.location = "${pageContext.request.contextPath}/removeDocument.action?ids=" + ids.get();
	 				   }
	 			   });
	 		   }
	 	   })
	    	
	    	/** 下载文档功能 */
	    	$("a[id^='down_']").click(function(){
	    		/** 得到需要下载的文档的id */
	    		var id = this.id.replace("down_","");
	    		/** 下载该文档 */
	    		window.location = "${pageContext.request.contextPath}/downLoadDoc.action?id="+id;
	    	})
	    	
	    	
	    	
	    })
	    
	    function down(id){
	    	$("a[id='down_"+id+"']").trigger("click");
	    }
	    
	</script>
</head>
<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr><td height="10"></td></tr>
	  <tr>
	    <td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
		<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：文档管理 &gt; 文档查询</td>
		<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
	  </tr>
	</table>
	
	<form name="documentform" method="post" id="documentform" action="${pageContext.request.contextPath}/findDocByPageName.action">
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
					    	标题：<input type="text" name="documentTitle" value="${requestScope.title }"/>
					    	<input type="hidden" name="currentPage" value="1">
					    	<input type="submit"  value="搜索"/>
					    	<input type="button" id="delete" value="删除">
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
		      <td><input type="checkbox" id="checkAll" ></td>
			  <td>标题</td>
			  <td>创建时间</td>
			  <td>创建人</td>
			  <td>描述</td>
			 
			  <td>下载</td>
			</tr>
			<c:forEach items="${requestScope.page.list}" var="document" varStatus="stat">
				<tr ondblclick="down(${document.documentId});"  class="main_trbg" align="center" id="data_${stat.index}">
					<td><input type="checkbox" id="box_${stat.index}" value="${document.documentId}"></td>
					 <td>${document.documentTitle }</td>
					 <td>
					  	<f:formatDate value="${document.documentCreateDate}" 
								type="date" dateStyle="long"/>
					  </td>
					  <td>${document.user.userName }</td>
					  <td>${document.documentDesc }</td>
					
					  <td align="center"  width="40px;"><a href="#" id="down_${document.documentId }">
							<img width="20" height="20" title="下载" src="${pageContext.request.contextPath}/images/downLoad.png"/></a>
					  </td>
				</tr>
			</c:forEach>
			 

		  </table>
		</td>
	  </tr>
	  <!-- 分页标签 -->
	  <tr valign="top"><td align="center" class="font3">
	  	   <% Page pageOne = (Page)request.getAttribute("page"); %>
		<% if(pageOne!=null) {for(int i=1;i<=pageOne.getTotalPages();i++){ %>
			<a href="javascript:one(document.forms[0],<%=i%>)"><font size="3px"><%=i%>&nbsp;</font></a>
		<% }} %>
		
		<br>
		搜索结果共<font style="color:red">${page.tatalNums }</font>条&nbsp;当前页${page.currentPage}/共${page.totalPages}页
		<span>跳转至</span><input type="text" name="inputPage" id="inputPage" value="${page.currentPage}" style="width:30px;text-align:center;"/>页
		<input type="button" onclick="javascript:jump_to(document.forms[0],document.getElementById('inputPage').value)" value="GO"/>
	  </td></tr>
	</table>
	</form>
	<div style="height:10px;"></div>
</body>
</html>