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
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/public/js/xadmin.js"></script>
    
    
    <link rel="stylesheet" href="/public/css/bootstrap.min.css">
	<link rel="stylesheet" href="/public/css/font-awesome.min.css">
	<link rel="stylesheet" href="/public/plugins/jqgrid/ui.jqgrid-bootstrap.css">
	<link rel="stylesheet" href="/public/plugins/ztree/css/metroStyle/metroStyle.css">
	<link rel="stylesheet" href="/public/css/main.css">
	<script src="/public/libs/jquery.min.js"></script>
	<script src="/public/plugins/layer/layer.js"></script>
	<script src="/public/libs/bootstrap.min.js"></script>
	<script src="/public/libs/vue.min.js"></script>
	<script src="/public/plugins/jqgrid/grid.locale-cn.js"></script>
	<script src="/public/plugins/jqgrid/jquery.jqGrid.min.js"></script>
	<script src="/public/plugins/ztree/jquery.ztree.all.min.js"></script>
	<script src="/public/js/common.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so layui-form-pane">
            <input class="layui-input" placeholder="输入设备码" name="cate_name" >
            <input class="layui-input" placeholder="输入设备物主" name="cate_name" >
            <div class="layui-input-inline">
                <select name="cateid">
                    <option>请输入地址</option>
                    <option>山西省</option>
                </select>
            </div>
            <div class="layui-input-inline">
                <select name="cateid">
                    <option>全部</option>
                    <option>已审核</option>
                    <option>未审核</option>
                </select>
            </div>
            <input class="layui-input" placeholder="创建时间" name="start" id="start">
            <input class="layui-input" placeholder="" name="end" id="end">
            <button class="layui-btn"  lay-submit="" lay-filter="sreach">查询</button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <span class="x-right" style="line-height:40px">共有数据：88 条</span>
    </xblock>
    <table id="jqGrid"></table>
	<div id="jqGridPager"></div>
    

</div>
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

    /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){

            if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

            }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
            }

        });
    }

    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }



    function delAll (argument) {

        var data = tableCheck.getData();

        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }
</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
<script src="/public/js/deviceList.js"></script>
</body>

</html>