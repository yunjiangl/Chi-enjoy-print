$(function () {
    $("#File").jqGrid({
        url: baseURL + 'zx/cde/list?typeString=c文件分类',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: 'id', width: 50, key: true },
			{ label: '标题', name: 'fileName', index: 'fileName', width: 80 },
			{ label: '线上管理员', name: 'lawyer.username', index: 'awyer.username', width: 80 },
            { label: '客户', name: 'zxUser.nickname', index: 'zxUser.nickname', width: 80 },
            { label: '操作', name: 'id', index: '', width: 80 ,formatter: function(value, options, row){
				return '<li class="btn btn-default" onclick="aaa('+value+')">删除</li>'
				+'<button class="btn btn-default" onclick="bb('+row.userName+')">查看</button>';
				}}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#FilePager",
        jsonReader : {
            root: "data.content",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#File").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});
/*function queryById(id){
	alert(id);
	$.ajax({
	    url:baseURL + 'zx/cde/sys/deleteUserById?ids='+id,
	    type:"GET",
	    data:{
	      ids:id
	    },
	    async:false,
	    success:function (res) {
	      
	      alert(res);
	    }
	  })
}*/
function bb(a){
	alert(a);
}
function aaa(id){
	
	
	
	window.confirm('是否确定删除！！！',function(){
		console.log('123');
		$.ajax({
		    url:baseURL + 'zx/cde/sys/deleteUserById?ids='+id,
		    type:"GET",
		    data:{
		      ids:id
		    },
		    async:false,
		    success:function (res) {
		    	
		      location.reload();
		      parent.layer.alert("删除成功", function(index){
		  		
		    	  window.parent.location.reload();
		  	});
		      
		  		}
		  	});
		    
		  
	})
}

var vm = new Vue({
	el:'#userAttorney',
	data:{
		q:{
			userName: null,
			fileName: null,
			time1: null,
			time2: null
		},
		showList: true,
		title:null,
		paperType: null, // 纸张
		paperColcor: null, // 颜色
		paperUsage: null, // 单双面
		order:{
			orderNum:null, // 订单号
			payTime: null, // 支付时间
			payType: null, // 支付方式
			printerAmount: null, // 打印费用
			orderAmount: null, // 订单金额
			serviceAmount: null, // 服务费用
			status: null, // 订单状态
			lawyer:{
				nickname:null // 律师名称
			},
			zxUser:{
				nickname:null // 客户名称
			},
			zxPrinterManager:{
				managerName: null, // 线下管理员名称
				managerPhone: null, // 线下管理员联系电话
				printerCode: null // 设备编码
			},
			zxOrderPrinterFile: {
				fileId: null, // 文件id
				filePaper: null, //页数
				paperColcor: null, // 纸张颜色
				paperType: null, //  纸张类型
				paperUsage: null, // 纸张使用
				printerNum: null // 打印数量
			},
			sysUser: {
				username: null // 设备物主
			},
			zxFileManagerCDE: {
				fileName: null // 文件标题
			},
			zxFileManagerAB: {
				fileName: null // 文件标题
			}
		}
	},
	methods: {
		query: function () {
			
			vm.showList = true;
			var page = $("#File").jqGrid('getGridParam','page');
			$("#File").jqGrid('setGridParam',{ 
                postData:
                {
                	'userName': vm.q.userName,
                	'fileName': vm.q.fileName,
                	'time1': vm.q.time1,
                	'time2': vm.q.time2
                },
                page:page
            }).trigger("reloadGrid");
		},
		reload: function () {
			alert();
			
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.user = {};
		},
		update: function (event) {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(userId)
		},
		saveOrUpdate: function (event) {
			var url = vm.user.userId == null ? "user/save" : "user/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.user),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		deleteAttorney: function (event) {
			var userIds = getSelectedRows();
			if(userIds == null){
				return ;
			}
			
			confirm('确定要禁用选中的账号？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "user/delete",
                    contentType: "application/json",
				    data: JSON.stringify(userIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
        checkAttorney: function (event) {
            var userIds = getSelectedRows();
            if(userIds == null){
                return ;
            }
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "审核",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#checkLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    // var node = ztree.getSelectedNodes();
                    //选择上级菜单
                    // vm.menu.parentId = node[0].menuId;
                    // vm.menu.parentName = node[0].name;

                    layer.close(index);
                }
            });
            $("#jqGrid").trigger("reloadGrid");
        },
		getInfo: function(userId){
			$.get(baseURL + "user/info/"+userId, function(r){
                vm.user = r.user;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page,
                postData:{'username': vm.q.username,'useStatus':vm.q.useStatus,'userType':vm.q.userType}
            }).trigger("reloadGrid");
		},
		queryById: function(){
			alert();
		}
		
	}
});
layui.use('laydate', function(){
    var laydate = layui.laydate;
    //执行一个laydate实例
    laydate.render({
      elem: '#start', //指定元素
      done: function(data){
    	  vm.q.time1 = data;
      }
    });
    //执行一个laydate实例
    laydate.render({
      elem: '#end', //指定元素
      done: function(data){
    	  vm.q.time2 = data;
      }
    });
  });