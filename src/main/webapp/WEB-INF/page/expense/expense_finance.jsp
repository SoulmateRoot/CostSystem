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
<title>报销单财务审核</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>报销管理</li>
			<li>财务审核</li>

		</ul>
	</div>
	<form action="" method="post" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">报销单基本信息</h5>
		<div class="row">
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销原因</label>
					<div class="col-sm-9">
						<p class="form-control-static">上海出差</p>
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销时间</label>
					<div class="col-sm-9">
						<p class="form-control-static">2016-12-12</p>
					</div>
				</div>
			</div>
				<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销总金额</label>
					<div class="col-sm-9">
						<p class="form-control-static">￥5000.0</p>
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销详情</label>
					<div class="col-sm-9">
					<p class="form-control-static">报销详情报销详情报销详情报销详情</p>
					</div>
				</div>
			</div>
		</div>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">
			报销单明细 
		</h5>
		<table class="table" id="tab1">
			<tr>
				<th>费用名称</th>
				<th>费用说明</th>
				<th>具体金额</th>
			</tr>
			<tr>
				<td>住宿费</td>
				<td>住宿费上线报销200元</td>
				<td>￥200.0</td>
			</tr>
			<tr>
				<td>住宿费</td>
				<td>住宿费上线报销200元</td>
				<td>￥200.0</td>
			</tr>
			<tr>
				<td>住宿费</td>
				<td>住宿费上线报销200元</td>
				<td>￥200.0</td>
			</tr>
		</table>

		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">报销单审核信息</h5>
		<div class="row">
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">审核状态</label>
					<div class="col-sm-9">
						<label class="radio-inline"> <input type="radio"
							name="state" value="1" />审核通过
						</label> <label class="radio-inline"> <input type="radio"
							name="state" value="2" />审核不通过
						</label> <label class="radio-inline"> <input type="radio"
							name="state" value="3" />作废
						</label>
					</div>
				</div>
			</div>

			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">审核描述</label>
					<div class="col-sm-9">
						<textarea rows="" cols="" class="form-control"
							placeholder="请输入审核描述"></textarea>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-7" align="center">
				<input type="submit" value="审核提交" class="btn btn-success" />

			</div>
		</div>
	</form>
</body>
</html>