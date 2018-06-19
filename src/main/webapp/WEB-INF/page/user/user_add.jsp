<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户添加</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="res/validator/jquery.validator.css">
<script type="text/javascript" src="res/validator/jquery.validator.js"></script>
<script type="text/javascript" src="res/validator/local/zh-CN.js"></script>
<script type="text/javascript">
	$(function(){
		//绑定事件
		$("#userAccount").blur(function(){
			$.post("user/check.do",{userAccount:$(this).val()},
				function(data){
					$("#error").html(data);
			})
		})
	})

</script>
</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>添加用户</li>
		</ul>
	</div>
	<!-- 通过为表单添加 .form-horizontal 类，并联合使用 Bootstrap 预置的栅格类，
	可以将 label 标签和控件组水平并排布局。这样做将改变 .form-group 的行为，
	使其表现为栅格系统中的行（row），因此就无需再额外添加 .row 了。 -->
	<form action="user/add.do" method="post" class="form-horizontal"
		data-validator-option='{stopOnError:true ,theme:"yellow_right"}'>
		<h5 class="page-header alert-info" style="margin:0px; padding:10px;margin-bottom:10px">用户基本信息</h5>
		<div class="row">
			<!--用户名称  -->
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户名称</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="userName" 
							data-rule=用户名称:required; placeholder="请输入用户名称" >
					</div>
				</div>
			</div>
			
			<!--用户名称  -->
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户性别</label>
					<div class="col-sm-5">
					
						<select name="userSex" class="form-control">
							<option>男</option>
							<option>女</option>
							<option>保密</option>
						</select>
					</div>
				</div>
			</div>
			
				<!--用户年龄  -->
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户年龄</label>
					<div class="col-sm-9">
						<input type="text" name="userAge" class="form-control" 
						 data-rule=用户年龄:required; placeholder="请输入用户年龄">
					</div>
				</div>
			</div>
			<!--用户薪资 -->
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户薪资</label>
					<div class="col-sm-5">
						<input type="text" name="userSalary" class="form-control" 
						data-rule=用户薪资:required; placeholder="请输入薪资">
					</div>
				</div>
			</div>
			<!--用户角色 -->
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户角色</label>
					<div class="col-sm-9">
						<select name="roleId"  class="form-control" data-rule=用户角色:required;>
							<option value="请选择角色">请选择角色</option>
							<c:forEach items="${list}" var="role">
								<option value="${role.roleId}">${role.roleName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
				
		<!-- Div 节点 -->	
		</div>
		
		<h5 class="page-header alert-info" style="margin:0px; padding:10px;margin-bottom:10px">帐号基本信息
		<span id="error" style="color: red"></span></h5>
		<div class="row">
			<!--账户名称  -->
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户帐号</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="userAccount" onblur="" name="userAccount" 
							data-rule=用户帐号:required; placeholder="请输入用户帐号">
					</div>
				</div>
			</div>
			<!--账户密码  -->
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户密码</label>
					<div class="col-sm-5">
						<input type="password" class="form-control" name="userPassword" 
							data-rule=用户密码:required; placeholder="请输入用户密码">
					</div>
				</div>
			</div>
		</div>
		
		<!-- 添加用户与返回上一级按钮， -->
		<div class="row">
			<div class="col-sm-10" align="center">
				<input type="submit" value="添加用户" class="btn btn-success">
				<a href="user/list.do" class="btn btn-danger">返回上一级</a>
			</div>
		</div>
	</form>
	

</body>
</html>