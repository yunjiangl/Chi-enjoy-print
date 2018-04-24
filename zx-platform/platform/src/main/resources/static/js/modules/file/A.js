$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'zx/ab/list?typeString=a文件分类',
        datatype: "json",
        mtype:"post",
        colModel: [			
			{ label: 'ID', name: 'id',  width: 50, key: true },
			{ label: '标题', name: 'fileName',  width: 80 },
			{ label: '文件分类', name: 'sysDictionary.name',  width: 80 },
			{ label: '打印次数', name: 'fileNum', width: 80 },
            { label: '页数', name: 'fileNum', width: 80 },
            { label: '操作', name: 'id',width: 80, formatter: function (value, options, row) { 
                return '<a class="btn btn-primary btn-sm" href="javascript:;" onclick="deleteFileB(\''+value + '\');">删除</a>&nbsp;&nbsp;'               
                +'<a class="btn btn-primary btn-sm" href="javascript:;" onclick="updateFileB(\''+value + '\')">修改</a>';
            } },
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