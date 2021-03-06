<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查看</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>查看用户>
		</ul>
	</div>
	<!-- 通过为表单添加 .form-horizontal 类，并联合使用 Bootstrap 预置的栅格类，
	可以将 label 标签和控件组水平并排布局。这样做将改变 .form-group 的行为，
	使其表现为栅格系统中的行（row），因此就无需再额外添加 .row 了。 -->
	<form action="" method="post" class="form-horizontal">
		<h5 class="page-header alert-info" 
		style="margin:0px; padding:10px;margin-bottom:10px">用户基本信息</h5>
		<div class="row">
			<!--用户姓名  -->
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户姓名</label>
					<div class="col-sm-9">
						<p class="from-control-static">${userinfo.userName}</p>
					</div>
				</div>
			</div>
			
			<!--用户名称  -->
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户性别</label>
					<div class="col-sm-5">
						<p class="from-control-static">${userinfo.userSex}</p>
					</div>
				</div>
			</div>
			
				<!--用户年龄  -->
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户年龄</label>
					<div class="col-sm-9">
						<p class="from-control-static">${userinfo.userAge}</p>
					</div>
				</div>
			</div>
			<!--用户薪资 -->
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户薪资</label>
					<div class="col-sm-5">
						<p calss="from-control-static">${userinfo.userSalary}</p>
					</div>
				</div>
			</div>	
		</div>
		
		<h5 class="page-header alert-info" style="margin:0px; padding:10px;margin-bottom:10px">帐号基本信息</h5>
		<div class="row">
			<!--账户名称  -->
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户帐号</label>
					<div class="col-sm-9">
						<p class="from-control-static">${userinfo.userAccount}</p>
					</div>
				</div>
			</div>
			<!--账户密码  -->
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户密码</label>
					<div class="col-sm-5">
						<p class="from-control-static">${userinfo.userPassword }</p>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 添加用户与返回上一级按钮， -->
		<div class="row">
			<div class="col-sm-10" align="center">
				<a href="user/loadupdate.do?userId=${userinfo.userId }" class="btn btn-primary">
					修改用户信息</a>
				<a href="user/list.do" class="btn btn-danger">返回上一级</a>
			</div>
		</div>
	</form>
	
	

</body>
</html>