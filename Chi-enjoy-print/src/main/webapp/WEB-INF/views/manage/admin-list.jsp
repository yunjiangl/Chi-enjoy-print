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
	    <link rel="stylesheet" type="text/css" href="http://www.java1234.com/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.java1234.com/jquery-easyui-1.3.3/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.java1234.com/jquery-easyui-1.3.3/demo/demo.css ">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/public/js/xadmin.js"></script>
<script type="text/javascript" src="http://www.java1234.com/jquery-easyui-1.3.3/jquery.min.js "></script>
<script type="text/javascript" src="http://www.java1234.com/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="http://www.java1234.com/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

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
			<form class="layui-form layui-col-md12 x-so layui-form-pane" action="/sys/selectDim">
				<input class="layui-input" placeholder="用户组名称" name="roleName">
				
				<div class="layui-input-inline">
					<select name="status">
						<option value="1">可用</option>
						<option value="0">禁用</option>
					</select>
				</div>
				<input class="layui-input easyui-datetimebox led" placeholder="创建时间" name="time1" style="width:190px;">
				至
          		<input class="layui-input easyui-datetimebox led" placeholder="创建时间" name="time2" style="width:190px;" > 
				<input class="layui-btn" lay-submit=" " lay-filter="sreach" type="submit" value="查询">
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
			<div class="layui-input-inline select-input">
				<select name="status" value="请选择状态">
					<option value="1">可用</option>
					<option value="0">禁用</option>
				</select>
			</div>
			<div style="clear:both;"></div>
			<font>创建时间:</font><div id="date1" class="layui-input date1"></div>
			<div style="clear: both;"></div>
			<tt style="margin-top: 20px;">
				<a href="/sys/selectRoleAll" class="layui-btn">返回</a>
				<button class="layui-btn" type="submit">保存</button>
			</tt>
		</form>
	</div>

	<!-- saveuser end -->
<script type="text/javascript">
    function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    document.getElementById("date1").innerHTML=currentdate;
}setInterval("getNowFormatDate()",1000);
 
 
 
</script>
<a href="javascript:void(0)" onclick="getNowFormatDate()">点我查看当前时间</a>

<div id="date1">adad</div>

	 <!-- <script src="../node_modules/jquery/dist/jquery.min.js"></script>
	<script src="../layer/layer.js"></script>  -->
	<script type="text/javascript">
$('.organize').on("click",function(){
	layer.open({
		type:1,
		title:'添加用户组',
		area:['600px','420px'],
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
<script>
	laydate({
    elem: '.validatebox-text',
    format: 'YYYY/MM/DD hh:mm:ss', // 分隔符可以任意定义，该例子表示只显示年月
    festival: true,
    istoday: true,
    start: laydate.now(0, "YYYY/MM/DD hh:00:00"),
    istime: true,
	});
</script>
</body>
</html>