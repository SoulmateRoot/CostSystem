<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色修改</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="res/validator/jquery.validator.css">
<script type="text/javascript" src="res/validator/jquery.validator.js"></script>
<script type="text/javascript" src="res/validator/local/zh-CN.js"></script>
</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>角色管理</li>
			<li>修改角色</li>
		</ul>
	</div>
	<!-- 通过为表单添加 .form-horizontal 类，并联合使用 Bootstrap 预置的栅格类，
	可以将 label 标签和控件组水平并排布局。这样做将改变 .form-group 的行为，
	使其表现为栅格系统中的行（row），因此就无需再额外添加 .row 了。 -->
	<form action="role/update.do" method="post" class="form-horizontal"
	data-validator-option='{stopOnError:true ,theme:"yellow_right"}'>
	<input type="hidden" name="roleId" value="${role.roleId}"/>
		<h5 class="page-header alert-info" style="margin:0px; padding:10px;margin-bottom:10px">角色基本信息</h5>
		<div class="row">
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">角色名称</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="roleName" 
						data-rule=角色名称:required; placeholder="请输入角色名称" value="${role.roleName}"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">角色描述</label>
					<div class="col-sm-9">
						<textarea rows="" cols="" class="form-control" name="roleDesc"
						data-rule=角色描述:required; placeholder="请输入角色描述" >${role.roleDesc}</textarea>
					</div>
				</div>
			</div>
		<!-- 添加角色与返回上一级按钮， -->	
		</div>
			<div class="row">
				<div class="col-sm-7" align="center">
					<input type="submit" value="保存修改" class="btn btn-success">
					<a href="role/list.do" class="btn btn-danger">返回上一级</a>
				</div>
			</div>
	</form>
	

</body>
</html>