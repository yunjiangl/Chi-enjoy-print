<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>智享打印-后台管理端</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/public/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/public/css/font.css">
	<link rel="stylesheet" href="/public/css/xadmin.css">
	<link rel="stylesheet" type="text/css" href="/public/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="/public/css/user-manage.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/public/js/xadmin.js"></script>

<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<a class="layui-btn layui-btn-small"
		style="line-height: 1.6em; margin-top: 3px; float: right"
		href="javascript:location.replace(location.href);" title="刷新"> <i
		class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so layui-form-pane">
				<input class="layui-input" placeholder="用户组名称" name="cate_name">
				<div class="layui-input-inline">
					<select name="cateid">
						<option>请选择状态</option>
						<option>可用</option>
						<option>禁用</option>
					</select>
				</div>
				<input class="layui-input" type="date" placeholder="创建时间"
					name="cate_name"> 至 <input class="layui-input" type="date"
					placeholder="创建时间" name="cate_name">
				<button class="layui-btn" lay-submit="" lay-filter="sreach">查询</button>
			</form>
			<button class="layui-btn organize" onclick="groups1()">添加用户组</button>
		</div>

		<xblock> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>用户组名称</th>
					<th>状态</th>
					<th>创建时间</th>
					<th>权限</th>
					<th>操作</th>
			</thead>
			<tbody>
			<c:forEach items="${RoleList }" var="rl">
				<tr>
					<td>${rl.roleName }</td>
					<c:if test="${rl.status ==1}">
					<td>可用</td>
					</c:if>
					<c:if test="${rl.status !=1}">
					<td>禁用</td>
					</c:if>
					<td>${rl.createTime }</td>
					<td><a href="/sys/jurisdiction" class="layui-btn">设置权限</a></td>
					<td>
						<a href="/sys/updateRole?roleId=${rl.roleId }" class="layui-btn modify">修改</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="page">
			<div>
				<a class="prev" href="">&lt;&lt;</a> <a class="num" href="">1</a> <span
					class="current">2</span> <a class="num" href="">3</a> <a
					class="num" href="">489</a> <a class="next" href="">&gt;&gt;</a>
			</div>
		</div>

	</div>

	<!-- 添加用户  -->
	<!-- saveuser start -->
	<div class="saveuser" style="display: none;">
		<form action="/sys/insertRole" method="get">
			<font>用户组名称：</font><input type="" name="roleName" class="layui-input"><br>
			<font class="ft">状态：</font>
			<div class="layui-input-inline">
				<select name="status" value="请选择状态">
					<option value="1">可用</option>
					<option value="0">禁用</option>
				</select>
			</div>
			<div style="clear: both;"></div>
			<tt>
				<button class="layui-btn"><a href="/sys/selectRoleAll">返回</a></button>
				<button class="layui-btn" type="submit">保存</button>
			</tt>
		</form>
	</div>

	<!-- saveuser end -->

	<!-- <script src="../node_modules/jquery/dist/jquery.min.js"></script>
	<script src="../layer/layer.js"></script> -->
	<script type="text/javascript">
$('.organize').on("click",function(){
	layer.open({
		type:1,
		title:'添加用户组',
		area:['600px','360px'],
		shadeClose:true,
		shad:[0.8,'#855'],
		content:$(".saveuser")
	});
});
</script>
	<script type="text/javascript">
/* $('.modify').on("click",function(roleId){
	alert(roleId);
	layer.open({
		type:2,
		title:'修改用户',
		area:['600px','360px'],
		shadeClose:true,
		shad:[0.8,'#855'],
		content:'/sys/updateUser?roleid=roleId'
	});
}); */
</script>
	
</body>
</html>