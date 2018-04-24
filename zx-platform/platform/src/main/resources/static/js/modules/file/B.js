$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'zx/ab/list?typeString=b文件分类',
        datatype: "json",
        mtype: "post",
        colModel: [
            {label: 'ID', name: 'id', width: 50, key: true},
            {label: '标题', name: 'fileName', width: 80},
            {label: '文件分类', name: 'sysDictionary.name', width: 80},
            {label: '打印次数', name: 'fileNum', width: 80},
            {label: '页数', name: 'fileNum', width: 80},
            //{ label: '操作', name: 'id',width: 80, formatter: function (value, options, row) { 
            // return '<a class="btn btn-primary btn-sm" href="javascript:;" onclick="deleteFileB(\''+value + '\');">删除</a>&nbsp;&nbsp;'
            //+'<a class="btn btn-primary btn-sm" href="javascript:;" onclick="updateFileB(\''+value + '\')">修改</a>';
            //  } },

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
            root: "data.content",
            page: "data.number",
            total: "data.totalPages",
            records: "data.totalElements"
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
        bean: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        saveFile: function () {
            //alert();
            vm.showList = false;
            vm.title = "新增文件";
            vm.bean = {};
        },
        //修改
        updateFile: function () {
            var id = getSelectedRow();
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
            var Id = getSelectedRows();
            //console.log(Id);
            if (Id == null) {
                return;
            }
            confirm('是否删除选中的文件?', function () {
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
                success: function (res) {
                    if (res.code === 200) {

                    }
                },
                error: function (err) {
                    alert("网络错误");
                }

            });
        },
        saveOrUpdate: function () {
            var url = vm.bean.id == null ? "zx/ab/add" : "zx/ab/update";
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
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                page: page,
                postData: {'fileName': vm.q.fileName}
            }).trigger("reloadGrid");
        }
    },
    beforeMount: function () {

    },
    watch: {}

});





	  




