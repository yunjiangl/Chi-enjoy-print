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
            //{ label: '操作', name: 'id',width: 80, formatter: function (value, options, row) { 
               // return '<a class="btn btn-primary btn-sm" href="javascript:;" onclick="deleteFileB(\''+value + '\');">删除</a>&nbsp;&nbsp;'               
                //+'<a class="btn btn-primary btn-sm" href="javascript:;" onclick="updateFileB(\''+value + '\')">修改</a>';
          //  } },

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
            page: "data.number",
            total: "data.totalPages",
            records: "data.totalElements"
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
		fileA:{},
		ldone:'请选择一级标题',
		parentone:[],
		ldtwo:'请选择二级标题',
		parenttwo:[
			{id:null,name:null,parentId:null}
		],
		ldthree:'请选择三级级标题',
		parentthree:[
			{id:null,name:null,parentId:null}
		],
		ldfore:'请选择四级标题',
		parentfore:[
			{id:null,name:null,parentId:null}
		]
	},
	methods: {
		query: function () {
			vm.reload();
		},
		saveFile:function(){
			//alert();
			vm.showList=false;
			vm.title="新增文件";
			vm.fileA={};
		},
		//修改
		updateFileA: function(){
			var id = getSelectedRow();
            if (id == null) {
                return;
            }
			console.log(id);
			vm.showList=false;
			vm.title="修改文件";
			vm.getfileA(id);
		},
		//删除
		deleteAll:function(){
			var Id = getSelectedRows();
			//console.log(Id);
            if (Id == null) {
                return;
            }
            confirm('是否删除选中的标题?', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "zx/ab/sys/delete",
                    contentType: "application/json",
                    data: JSON.stringify(Id),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function () {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
		},
		getfileA: function(id){
			//console.log(id);
			var fileId=id;
			$.ajax({
				type: "POST",
                url: baseURL + "zx/ab/info/"+fileId,
                contentType: "application/json",
                data:JSON.stringify(fileId),
                success: function (r) {
                	console.log(r);
                	vm.fileA=r.zxFileManagerAB;
                	console.log(vm.fileB.id);
                }
			})
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
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page,
                postData:{'fileName': vm.q.fileName}
            }).trigger("reloadGrid");
		},
		//获取一级标题
		ldyiji: function(){
			//console.log("联动一");
			var parentid=2;
			$.ajax({
                type: "GET",
                url: baseURL + "zx/ab/dictionary/list/"+parentid,
                contentType: "application/json",
                data: JSON.stringify(parentid),
                success: function (res) {
                	//console.log(res.list)
                	var parent=[];
					for(var i=0;i<res.list.length;i++){
						//console.log(res.list[i].sysDictionary);
						parent[i]=res.list[i].sysDictionary;
						//console.log(parent);
						vm.parentone[i]=parent[i];
						//console.log(vm.parentone[i]);
					}
                }
            });
			//console.log(parent[0]);
		},
		//获取二级标题
		lderji: function(){
			console.log("联动er");
			var parentone=[];
			parentone=eval(this.parentone);
			console.log(parentone);
			
/*			for(var i in vm.parenttwo){
				var obg=this.parenttwo[i];
				if(obj.id==vm.ldtwo){
					vm.ids=obj.parentId;
					$.ajax({
						url: baseURL + "zx/ab/dictionary/list",
						type:"POST",
						dataType: 'json',
						data:{
						parentid:ids
						},
						async:true,
						success:function (res,status) {
							var parent=null;
							for(var i=0;i<res.list.length;i++){
								parentone=res.list[i].sysDictionary;
								vm.parentthree[i]=parent;
								console.log(vm.parent[i].id);
							}
						}
					})
					break;
				}
			}
			*/
		}
/*		ldsanji: function(){
			for(var i in vm.parenttwo){
				var obg=this.parenttwo[i];
				if(obj.id==vm.ldtwo){
					vm.ids=obj.parentId;
					$.ajax({
						url: baseURL + "zx/ab/dictionary/list",
						type:"POST",
						dataType: 'json',
						data:{
						parentid:ids
						},
						async:true,
						success:function (res,status) {
							var parent=null;
							for(var i=0;i<res.list.length;i++){
								parentone=res.list[i].sysDictionary;
								vm.parentthree[i]=parent;
								console.log(vm.parent[i].id);
							}
						}
					})
					break;
				}
			}
		},
		ldsiji: function(){
			for(var i in vm.parentthree){
				var obg=this.parentthree[i];
				if(obj.id==vm.ldthree){
					vm.ids=obj.parentId;
					$.ajax({
						url: baseURL + "zx/ab/dictionary/list",
						type:"POST",
						dataType: 'json',
						data:{
						parentid:ids
						},
						async:true,
						success:function (res,status) {
							var parent=null;
							for(var i=0;i<res.list.length;i++){
								parentone=res.list[i].sysDictionary;
								vm.parentfore[i]=parent;
								console.log(vm.parent[i].id);
							}
						}
					})
					break;
				}
			}
		}*/
	},
	beforeMount: function () {
        this.ldyiji();
        this.lderji();
    },   
    watch: {
        ldone: function () {
        	this.ldyiji();
        }
    }
	
});





	  




