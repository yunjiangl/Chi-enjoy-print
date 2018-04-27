$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'apply/list?userType=2',
        datatype: "json",
        colModel: [
            { label: 'ID', name: 'id', index: 'user_id', width: 50, key: true },
            { label: '消息', name: '', index: '', width: 90 ,formatter:function(cellvalue, options, rowObject){
                var html  = rowObject.sysUser.username+'律师申请加入，请查看！';

                return html;
            }},
            { label: '申请人', name: 'username', index: 'username', width: 80 },
            { label: '状态', name: 'status', index: 'status', width: 80 ,formatter:function(cellvalue, options, rowObject){
                var html = '';
                if(cellvalue==1){
                    html += '<span class="label label-success">通过</span>';
                }else
                    html += '<span class="label label-danger">未通过</span>';
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
            useStatus: null,
            userType:2
        },
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
            vm.user.userType=1;
            vm.checkUpdate(url);
        },
        checkNo:function(){
            var url = "apply/check" ;
            vm.user.isLock=2;
            vm.checkUpdate(url);
        },
        checkUpdate:function(url){
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
        update: function (event) {
            var userId = getSelectedRow();
            if(userId == null){
                return ;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(userId)
        },
        deleteAttorney: function (event) {
            var userIds = getSelectedRows();
            if(userIds == null){
                return ;
            }

            confirm('确定要禁用选中的账号？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "apply/delete",
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
                    url: baseURL + "apply/startUsing",
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
            var userId = getSelectedRow();
            if(userId == null){
                return ;
            }
            vm.showList = false;
            vm.title = "审核";

            vm.getInfo(userId);
        },
        getInfo: function(userId){
            $.get(baseURL + "user/info/"+userId, function(r){
                vm.user = r.user;
            });
            $.get(baseURL + "user/attorney/"+userId, function(r){
                vm.attorney = r.attorney;
            });
            $.get(baseURL + "user/domain/"+userId, function(r){
                vm.domains = r.domains;
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