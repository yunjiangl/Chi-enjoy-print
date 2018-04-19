$(function () {
    $("#File").jqGrid({
        url: baseURL + 'zx/cde/list?typeString=e文件分类',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: 'id', width: 50, key: true },
			{ label: '标题', name: 'fileName', index: 'fileName', width: 80 },
            { label: '客户', name: 'zxUser.nickname', index: 'zxUser.nickname', width: 80 },
            { label: '操作', name: 'loginIp', index: 'loginIp', width: 80 ,formatter: function(value, options, row){
            	return '<li class="btn btn-default" onclick="aaa('+value+')">删除</li>'
				+'<button class="btn btn-default" onclick="queryById('+row.fileName+')">查看</button>';
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

function queryById(id){
	alert(id);
	/*$.ajax({
	    url:baseURL + 'zx/cde/sys/deleteUserById?ids='+id,
	    type:"GET",
	    data:{
	      ids:id
	    },
	    async:false,
	    success:function (res) {
	      
	      alert(res);
	    }
	  })*/
}

function aaa(id){
	$.ajax({
	    url:baseURL + 'zx/cde/sys/deleteUserById?ids='+id,
	    type:"GET",
	    data:{
	      ids:id
	    },
	    async:false,
	    success:function (res) {
	      
	      location.reload();
	      alert("删除成功");
	    }
	  })
}
var vm = new Vue({
	el:'#userAttorney',
	data:{
        q:{
            username: null,
            useStatus: null,
			userType:2
        },
		showList: true,
		title: null,
		user: {}
	},
	methods: {
		delectC: function(){
			
			alert();
		},
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
		}
		
	}
});