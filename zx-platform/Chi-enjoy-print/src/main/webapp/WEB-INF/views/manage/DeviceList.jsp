<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/public/css/font.css">
    <link rel="stylesheet" href="/public/css/xadmin.css">
    <link rel="stylesheet" href="/public/lib/layui/css/modules/layer/default/layer.css">
  	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/public/lib/layui/layui.js" charset="utf-8"></script>
   
    <link rel="stylesheet" href="/public/css/bootstrap.min.css">
	<link rel="stylesheet" href="/public/css/font-awesome.min.css">
	<link rel="stylesheet" href="/public/plugins/jqgrid/ui.jqgrid-bootstrap.css">
	<link rel="stylesheet" href="/public/plugins/ztree/css/metroStyle/metroStyle.css">
	<link rel="stylesheet" href="/public/css/main.css">
	<link rel="stylesheet" href="/public/css/deviceList.css">
	<link rel="stylesheet" type="text/css" href="/public/css/devicelist-manage.css">
	
	<script src="/public/plugins/layer/layer.js"></script>
	<script src="/public/libs/bootstrap.min.js"></script>
	<script src="/public/libs/vue.min.js"></script>
	<script src="/public/plugins/jqgrid/grid.locale-cn.js"></script>
	<script src="/public/plugins/jqgrid/jquery.jqGrid.min.js"></script>
	<script src="/public/plugins/ztree/jquery.ztree.all.min.js"></script>
	 <script type="text/javascript" src="/public/js/xadmin.js"></script>
	<script src="/public/js/common.js"></script>
	
	<link rel="stylesheet" type="text/css" href="http://www.java1234.com/jquery-easyui-1.3.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.java1234.com/jquery-easyui-1.3.3/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="http://www.java1234.com/jquery-easyui-1.3.3/demo/demo.css ">
	
	
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="x-body rrapp">
    	<div class="layui-row">
    	 	<div class="layui-col-md12 x-so grid-btn container-fluid">
				<input class="layui-input" v-model="q.deviceCode" @keyup.enter="query" placeholder="输入设备码" >
				<input class="layui-input" v-model="q.nickname" @keyup.enter="query" placeholder="输入设备物主">
                <div class="layui-input-inline">
	                <select v-model="q.deviceDetailedAddress" class="address">
	                    <option value="">请输入地址</option>
	                    <option>山西省</option>
	                </select>
	            </div>
	            <div class="layui-input-inline">
	                <select v-model="q.status">
	                    <option value="">全部</option>
	                    <option value="1">已审核</option>
	                    <option value="0">未审核</option>
	                </select>
                </div>
                <input class="layui-input easyui-datetimebox led" v-model="q.startTime" placeholder="创建时间" id="time1" style="width:190px;">
				至
          		<input class="layui-input easyui-datetimebox led" v-model="q.endTime" placeholder="创建时间" id="time2" style="width:190px;" >
            	<a class="btn btn-default" @click="query">查询</a>
            	<a class="layui-btn addList" href="/sys/manage/device/addPage">添加设备</a>
            </div>
		</div>
	<table id="jqGrid"></table>
	<div id="jqGridPager"></div>
</div>

<script src="/public/plugins/layer/layer.js"></script>

   

<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;



        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

   
</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
<script src="/public/plugins/jqgrid/jquery.jqGrid.min.js"></script>
<script src="/public/js/deviceList.js"></script>
<script type="text/javascript" src="http://www.java1234.com/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="http://www.java1234.com/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
</body>

</html>