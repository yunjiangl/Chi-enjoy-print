$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'apply/list?userType=2',
        datatype: "json",
        colModel: [
            { label: 'ID', name: 'id', index: 'user_id', width: 50, key: true },
            { label: '消息', name: '', index: '', width: 90 ,formatter:function(cellvalue, options, rowObject){
                var html  = rowObject.zxUser.username+'律师申请加入，请查看！';

                return html;
            }},
            { label: '申请人', name: 'zxUser.username', index: 'zxUser.username', width: 80 },
            { label: '状态', name: 'status', index: 'status', width: 80 ,formatter:function(cellvalue, options, rowObject){
                var html = '';
                if(cellvalue==1){
                    html = '<span class="label label-success">通过</span>';
                }
                if(cellvalue==0){
                    html = '<span class="label label-success">未审核</span>';
                }
                if(cellvalue==2) {
                    html = '<span class="label label-danger">未通过</span>';
                }
                return html;
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
            status: ''
        },
        dataId:null,
		showList: true,
		title: null,
		user: {},
        domains:[],
		attorney:{}
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
        checkOk:function(){
            var url = "apply/check" ;
            var status=1;
            vm.checkUpdate(url,status);
        },
        checkNo:function(){
            var url = "apply/check" ;
            var status=2;
            vm.checkUpdate(url,status);
        },
		checkUpdate:function(url,status){
            var data = new Object();
            data.id=vm.dataId;
            data.status=status;
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(data),
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
        updateAttorney:function (event) {
            var userIds = getSelectedRows();
            if(userIds == null){
                return ;
            }

            confirm('确定要禁用选中的账号？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "user/startUsing",
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
            var id = getSelectedRow();
            if(id == null){
                return ;
            }
            vm.showList = false;
            vm.title = "审核";

            vm.getInfo(id);
        },
		getInfo: function(id){
		    var userId = 0;
            $.get(baseURL + "apply/info/"+id, function(r){
                userId=r.user.userId;
                $.get(baseURL + "user/info/"+userId, function(r){
                    vm.user = r.user;
                });
                $.get(baseURL + "user/attorney/"+userId, function(r){
                    vm.attorney = r.attorney;
                });
                $.get(baseURL + "user/domain/"+userId, function(r){
                    vm.domains = r.domains;
                });
            });

            vm.dataId=id;
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page,
                postData:{'name': vm.q.username,'status':vm.q.status}
            }).trigger("reloadGrid");
		}
	}
});