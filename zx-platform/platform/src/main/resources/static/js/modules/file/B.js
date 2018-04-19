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
		fileB:{},
		parent:{},
	},
	
	methods: {
		query: function () {
			vm.reload();
		},
		catalog: function(){
			console.log(123);
			var parentid="56";
			$.ajax({
                type: "POST",
                url: baseURL + "zx/ab/dictionary/list/"+parentid,
                contentType: "application/json",
                data:JSON.stringify(parentid),
                success: function (r) {
                	console.log(r);
                }
			});

		},
		saveFile:function(){
			//alert();
			vm.showList=false;
			vm.title="新增文件";
			vm.fileB={};
		},
		deleteAll:function(){
			var userId = getSelectedRow();
			console.log(userId);
		},
		saveOrUpdate: function () {
	            var url = vm.fileB.id == null ? "zx/ab/add" : "zx/ab/update";
	            vm.printer.province=vm.prov;
	            vm.printer.city=vm.city;
	            vm.printer.area=vm.district;
	            $.ajax({
	                type: "POST",
	                url: baseURL + url,
	                contentType: "application/json",
	                data: JSON.stringify(vm.fileB),
	                success: function (r) {
	                    if (r.code === 0) {
	                        alert('操作成功', function () {
	                            vm.reload();
	                        });
	                    } else {
	                        alert(r.msg);
	                    }
	                }
	            });
	        },
		getfileB: function(id){
			vm.catalog(id);
			console.log(id);
			$.ajax({
				type: "POST",
                url: baseURL + "zx/ab/info/"+id,
                contentType: "application/json",
                data:JSON.stringify(id),
                success: function (r) {
                	console.log(r);
                	vm.fileB=r.zxFileManagerAB;
                }
			})
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

/**
 * 删除文件
 * @param id
 * @returns
 */
function deleteFileB(id){
	console.log(id);
	window.confirm('是否确定删除！！！',function(){
		console.log('asd');
		$.ajax({
		    url:baseURL + 'zx/ab/sys/deleteUserById?Id='+id,
		    type:"GET",
		    data:{
		    	Id:id
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

function updateFileB(id){
	vm.showList=false;
	vm.title="修改文件";
	vm.getfileB(id);
}
