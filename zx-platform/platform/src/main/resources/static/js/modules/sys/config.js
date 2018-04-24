$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/config/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', width: 20, key: true },
            { label: '类型', name: 'type', width: 90 },
            { label: 'code', name: 'code', width: 70 },
            { label: '参数名', name: 'name', width: 60 },
            { label: '参数值', name: 'value', width: 60 },
            { label: '父级id', name: 'parentId', width: 30 },
			{ label: '排序号', name: 'sort', width: 30 },
			{ label: '备注', name: 'remark', width: 80 }
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
			key: null
		},
		showList: true,
		title: null,
		config: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.config = {
				type:'zx_file_type_a',
				sort:0,
				parentId:0
			};
		},
		update: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			
			$.get(baseURL + "sys/config/info/"+id, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.config = r.config;
                if(r.config.sort==undefined || r.config.sort=='' || r.config.sort==null){
                	vm.config.sort=0;
				}
                if(r.config.parentId==undefined || r.config.parentId=='' || r.config.parentId==null){
                    vm.config.parentId=0;
                }
            });
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/config/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(){
								vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		saveOrUpdate: function () {
            if(vm.validator()){
				return ;
			}

			var url = vm.config.id == null ? "sys/config/save" : "sys/config/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.config),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		reload: function () {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'key': vm.q.key},
                page:page
            }).trigger("reloadGrid");
		},
		validator: function () {
			if(isBlank(vm.config.name)){
				alert("参数名不能为空");
				return true;
			}

            if(isBlank(vm.config.value)){
                alert("参数值不能为空");
                return true;
            }
        }
	}
});