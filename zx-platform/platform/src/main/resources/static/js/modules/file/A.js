var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};
var ztree;
$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'zx/ab/list?type=zx_file_type_a',
        datatype: "json",
        mtype: "post",
        colModel: [
            {label: 'ID', name: 'id', width: 50, key: true},
            {label: '标题', name: 'fileName', width: 80},
            {label: '文件分类', name: 'categoryName', width: 80},
            {label: '打印次数', name: 'fileNum', width: 80},
            {label: '页数', name: 'fileNum', width: 80}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            fileName: null
        },
        showList: true,
        title: null,
        bean: {categoryName:null,categoryId:0},
        category:{
            parentName:null,
            parentId:0,
            type:1,
            orderNum:0
        }
    },
    methods: {
        getCategory: function(){
            //加载菜单树
            $.get(baseURL + "zx/ab/dictionary/list/zx_file_type_a", function(r){
                ztree = $.fn.zTree.init($("#categoryTree"), setting, r.list);
                var node = ztree.getNodeByParam("id", vm.category.parentId);
                ztree.selectNode(node);

                vm.category.parentName = node.name;
            })
        },
        categoryTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择分类",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#categoryLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择类型
                    vm.bean.categoryId=node[0].id;
                    vm.bean.categoryName=node[0].name;
                    vm.bean.categoryCode=node[0].code;
                    layer.close(index);
                }
            });
        },
        query: function () {
            vm.reload();
        },
        saveFile: function () {
            //alert();
            vm.showList = false;
            vm.title = "新增文件";
            vm.bean = {categoryName:null,categoryId:0,fileNum:0,fileUrl:'',categoryCode:''};
            vm.getCategory();
        },
        //修改
        updateFile: function () {
            var id = getSelectedRow();
            vm.getCategory();
            if (id == null) {
                return;
            }
            console.log(id);
            vm.showList = false;
            vm.title = "修改文件";
            vm.getfile(id);
        },
        //删除
        deleteAll: function () {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的文件？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "zx/ab/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
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
        getfile: function (id) {
            //console.log(id);
            var fileId = id;
            $.ajax({
                type: "POST",
                url: baseURL + "zx/ab/info/" + fileId,
                contentType: "application/json",
                data: JSON.stringify(fileId),
                success: function (r) {
                    console.log(r);
                    vm.bean = r.bean;
                    vm.bean.categoryName = r.categoryName;
                }
            })
        },
        uploadFile: function (e) {
            var formData = new FormData();
            formData.append('file', e.target.files[0]);
            formData.append('type', 'a');
            $.ajax({
                url: baseURL+'upload/a/file',//这里是后台接口需要换掉
                type: 'POST',
                dataType: 'json',
                cache: false,
                data: formData,
                processData: false,
                contentType: false,
                success: function (r) {
                    if (r.code === 0) {
                        vm.bean.fileNum = r.pageNum;
                        vm.bean.fileUrl = r.fileURL;
                    } else {
                        alert(r.msg);
                    }
                },
                error:function (r) {

                }
            })
        },
        saveOrUpdate: function () {
            var url = vm.bean.id == null ? "zx/ab/save" : "zx/ab/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.bean),
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
        }
    },
    beforeMount: function () {

    },
    watch: {}

});





	  




