<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.su.domain.*,java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>人事管理系统——修改员工</title>
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
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	$(function(){
		// 控制文档加载完成以后 选中性别 
		$("#sex").val("${employee.employeeSex}");
		$("#job_id").val("${employee.job.jobId}");
		
    	/** 员工表单提交 */
		$("#employeeForm").submit(function(){
			
			var msg = "";
			var cardId = $("#cardId");
			var phone = $("#phone");
			
			
			
			var education = $("#education");
			var email = $("#email");
			var name = $("#name");
			var party = $("#party");
			var qqNum = $("#qqNum");
			var address = $("#address");
			var postCode = $("#postCode");
			var birthday = $("#birthday");
			var race = $("#race");
			var speciality = $("#speciality");
			var hobby = $("#hobby");
			var tipInfop = $("#tipInfop").text();
			var tipInfoc = $("#tipInfoc").text();
			
			if ($.trim(name.val()) == ""){
				msg = "姓名不能为空！";
				name.focus();
			}else if ($.trim(cardId.val()) == ""){
				msg = "身份证号码不能为空！";
				cardId.focus();
			}else if (!/^[1-9]\d{16}[0-9A-Za-z]$/.test($.trim(cardId.val()))){
				msg = "身份证号码格式不正确！";
				cardId.focus();
			}else if ($.trim(education.val()) == ""){
				msg = "学历不能为空！";
				education.focus();
			}else if ($.trim(email.val()) == ""){
				msg = "邮箱不能为空！";
				email.focus();
			}else if (!/^\w+@\w{2,3}\.\w{2,6}$/.test($.trim(email.val()))){
				msg = "邮箱格式不正确！";
				email.focus();
			}else if ($.trim(phone.val()) == ""){
				msg = "手机号码不能为空！";
				phone.focus();
			}else if (!/^1[3|5|8]\d{9}$/.test($.trim(phone.val()))){
				msg = "手机号码格式不正确！";
				phone.focus();
			}else if ($.trim(party.val()) == ""){
				msg = "政治面貌不能为空！";
				party.focus();
			}else if ($.trim(qqNum.val()) == ""){
				msg = "QQ号码不能为空！";
				qqNum.focus();
			}else if (!/^\d{6,}$/.test($.trim(qqNum.val()))){
				msg = "QQ号码格式不正确！";
				qqNum.focus();
			}else if ($.trim(address.val()) == ""){
				msg = "地址不能为空！";
				address.focus();
			}else if ($.trim(postCode.val()) == ""){
				msg = "邮政编码不能为空！";
				postCode.focus();
			}else if (!/^[1-9]\d{5}$/.test($.trim(postCode.val()))){
				msg = "邮政编码格式不正确！";
				postCode.focus();
			}else if ($.trim(birthday.val()) == ""){
				msg = "出生日期不能为空！";
				birthday.focus();
			}else if (!birthday.val()){
//					!/^\d{4}-\d{2}-\d{2}$/.test($.trim(birthday.val()))
				msg = "出生日期格式不正确！";
				birthday.focus();
			}else if ($.trim(race.val()) == ""){
				msg = "民族不能为空！";
				race.focus();
			}else if ($.trim(hobby.val()) == ""){
				msg = "爱好不能为空！";
				hobby.focus();
			}else if(tipInfoc == "该身份证号已存在"){
					msg="身份证号码重复，请重新输入";
			}else if(tipInfop == "该手机号已存在"){
				msg="手机号码重复，请重新输入";
			}
			
			if (msg != ""){
				$.ligerDialog.error(msg);
				return false;
			}else{
				return true;
			}
			$("#employeeForm").submit();
		});
    });
		
	function checkCardId(cardId){
		var cardId = cardId.value;
		if(cardId == ""){
			alert("号码不能为空");
			cardId.focus();
			return ;
		}
		//获取xmlHttpRequest对象
		createXmlHttpRequest();
		//拼写访问服务器的url
		var url = "${pageContext.request.contextPath}/findAllEmployee.action?Id="+cardId;
		//xmlHttpRequest对象设置回掉函数
		xmlHttpRequest.onreadystatechange=checkIdExistCallBack;
		//设置请求参数
		xmlHttpRequest.open("GET",url,true);
		//发送请求
		xmlHttpRequest.send(null);
	}
	
	function checkPhone(phone){
		var phone = phone.value;
		if(phone == ""){
			alert("号码不能为空");
			phone.focus();
			return ;
		}
		//获取xmlHttpRequest对象
		createXmlHttpRequest();
		//拼写访问服务器的url
		var url = "${pageContext.request.contextPath}/findAllEmployee.action?Id="+phone;
		//xmlHttpRequest对象设置回掉函数
		xmlHttpRequest.onreadystatechange=checkPhoneExistCallBack;
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
	
	function checkIdExistCallBack(){
	
		//请求完成并成功返回，等于4和200
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var result = xmlHttpRequest.responseText;
			
			if(result == "true"){
				document.getElementById("tipInfoc").innerHTML="该身份证号已存在";
			}else{
				document.getElementById("tipInfoc").innerHTML="可以使用";
			}
			
		}
	}
	
	function checkPhoneExistCallBack(){
	
		//请求完成并成功返回，等于4和200
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var result = xmlHttpRequest.responseText;
			
			if(result == "true"){
				document.getElementById("tipInfop").innerHTML="该手机号已存在";
			}else{
				document.getElementById("tipInfop").innerHTML="可以使用";
			}
			
		}
	}

	function clearInfoCardId(){
		document.getElementById("tipInfoc").innerHTML="";
	}
	function clearInfoPhone(){
		document.getElementById("tipInfop").innerHTML="";
	}

	</script>
</head>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：员工管理  &gt; 修改员工</td>
	<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 <form action="${pageContext.request.contextPath}/updateEmployee.action" id="employeeForm" method="post">
			<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
			<input type="hidden" name="employeeId" value="${employee.employeeId }">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">姓名：<input type="text" name="employeeName" id="name" size="20" value="${employee.employeeName }"/></td>
		    			<td class="font3 fftd">身份证号码：<input type="text" name="employeeCardId" id="cardId" onblur="checkCardId(this)" onfocus="clearInfoCardId()" size="20" value="${employee.employeeCardId }"/></td>
		    			<td><span  id="tipInfoc" style="color: red;font-size: 12px"></span><br></td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">性别：
								<select id="sex" name="employeeSex" style="width:143px;">
									<option value="未填">--请选择性别--</option>
									<option value="男">男</option>
									<option value="女">女</option>
					    		</select>
					    </td>
		    			<td class="font3 fftd">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位：
		    			 	<select id="job_id" name="jobId" style="width:143px;">
					    			<option value="0">--请选择职位--</option>
					    			<c:forEach items="${requestScope.jobList }" var="job">
					    				<option value="${job.jobId }">${job.jobName }</option>
					    			</c:forEach>
					    		</select>
					    </td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">学历：<input name="employeeEducation" id="education" size="20" value="${employee.employeeEducation }"/></td>
		    			<td class="font3 fftd">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input name="employeeEmail" id="email" size="20" value="${employee.employeeEmail }"/></td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">手机：<input name="employeePhone" id="phone" onblur="checkPhone(this)" onfocus="clearInfoPhone()" size="20" value="${employee.employeePhone }"/></td>
		    			<td class="font3 fftd"><span id="tipInfop" style="color: red;font-size: 12px"></span><br></td>
		    		</tr>
		    		
		    	</table>
		    </td></tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					政治面貌：<input name="employeeParty" id="party" size="40" value="${employee.employeeParty }"/>&nbsp;&nbsp;
					QQ&nbsp;&nbsp;号码：<input name="employeeQQ" id="qqNum" size="20" value="${employee.employeeQQ }"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					联系地址：<input name="employeeAddress" id="address" size="40" value="${employee.employeeAddress }"/>&nbsp;&nbsp;
					邮政编码：<input name="employeePostCode" id="postCode" size="20" value="${employee.employeePostCode }"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					出生日期：<input cssClass="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});" 
					name="employeeBirthday" id="birthday" size="40"/>&nbsp;&nbsp;
					民&nbsp;&nbsp;&nbsp;&nbsp;族：<input name="employeeRace" id="race" size="20" value="${employee.employeeRace }"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					
					爱&nbsp;&nbsp;&nbsp;&nbsp;好：<input name="employeeHobby" id="hobby" size="20" value="${employee.employeeHobby }"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					
					&nbsp;&nbsp;所属部门：
					<select  name="deptId" style="width:100px;">
						   <option value="0">--部门选择--</option>
						   <c:forEach items="${requestScope.deptList }" var="dept">
						   		<c:choose>
			    					<c:when test="${employee.dept.deptId == dept.deptId }">
			    						<option value="${dept.deptId }" selected="selected">${dept.deptName }</option>
			    					</c:when>
			    					<c:otherwise>
			    						<option value="${dept.deptId }">${dept.deptName }</option>
			    					</c:otherwise>
			    				</c:choose>
			    			</c:forEach>
					</select>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr><td align="left" class="fftd"><input type="submit" value="修改">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>
</body>
</html>