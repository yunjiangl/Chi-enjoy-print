$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'zx/ab/list?typeString=b文件分类',
        datatype: "json",
        mtype:"post",
        colModel: [			
			{ label: 'ID', name: 'id',  width: 50, key: true },
			{ label: '标题', name: 'fileName',  width: 80 },
			{ label: '文件分类', name: 'sysDictionary.name',  width: 80 },
			{ label: '打印次数', name: 'fileNum', width: 80 },
            { label: '页数', name: 'fileNum', width: 80 },
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
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
        q:{
        	fileName:null
        },
		showList: true,
		title: null,
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
		
		deleteFileB:function(){
			var userIds = getSelectedRows();
			console.log(userIds);
			if(userIds == null){
				return ;
			}
			confirm('确定要删除该文件吗？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "zx/ab/sys/deleteUserById?Id='"+userIds+"'",
                    contentType: "application/json",
				    success: function(r){
				    	console.log(r);
						if(r.code == 0){
							alert('删除成功', function(index){
								$("#jqGrid")。
							});
						}else{
							alert('删除失败');
						}
					}
				});
			});
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
                postData:{'fileName': vm.q.fileName}
            }).trigger("reloadGrid");
		}
	}
});