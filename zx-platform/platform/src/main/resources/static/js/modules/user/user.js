$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/list?userType=1',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: 'user_id', width: 50, key: true },
			{ label: '用户名', name: 'username', index: 'username', width: 80 },
            { label: '状态', name: 'useStatus', index: 'useStatus', width: 80 ,formatter:function(cellvalue, options, rowObject){
            	if(cellvalue==1){
            		return '正常';
				}
            	return '关闭';
			}},
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 },
            { label: '上次登录时间', name: 'loginTime', index: 'loginTime', width: 80 },
            { label: '上次登录IP', name: 'loginIp', index: 'loginIp', width: 80 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
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
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
        q:{
            username: null,
            useStatus: null,
			userType:1
        },
		showList: true,
		title: null,
		user: {}
	},
	methods: {
		query: function () {
			vm.reload();
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
		delete: function (event) {
			var userIds = getSelectedRows();
			if(userIds == null){
				return ;
			}
			
			confirm('确定要关闭选中的记录？', function(){
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
        check: function (event) {
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
		}
	}
});