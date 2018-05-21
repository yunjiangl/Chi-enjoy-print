$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'zx/order/lawyer/page?lawyerId='+localStorage.getItem("token"),
        datatype: "json",
        colModel: [			
			{ label: '订单号', name: 'orderNum', width: 45, key: true },
			{ label: '设备物主', name: 'sysUser.username', width: 75 },
			{ label: '设备编号', name: 'printerCode', width: 90 },
			{ label: '律师', name: 'lawyer.nickname', width: 100 },
			{ label: '客户', name: 'zxUser.nickname', width: 80},
			{ label: '支付金额', name: 'orderAmount', width: 100 },
			{ label: '支付时间', name: 'payTime', width: 100 },
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
			printCode: null,
			printName: null,
			printHostId: null,
			lawyerName: null,
			time1: null,
			time2: null
		},
		code:"",
		showList: true,
		title:null,
		paperType: null, // 纸张
		paperColcor: null, // 颜色
		paperUsage: null, // 单双面
		order:{
			orderNum:null, // 订单号
			payTime: null, // 支付时间
			payType: null, // 支付方式
			printerAmount: null, // 打印费用
			orderAmount: null, // 订单金额
			serviceAmount: null, // 服务费用
			status: null, // 订单状态
			lawyer:{
				nickname:null // 律师名称
			},
			zxUser:{
				nickname:null // 客户名称
			},
			zxPrinterManager:{
				managerName: null, // 线下管理员名称
				managerPhone: null, // 线下管理员联系电话
				printerCode: null // 设备编码
			},
			zxOrderPrinterFile: {
				fileId: null, // 文件id
				filePaper: null, //页数
				paperColcor: null, // 纸张颜色
				paperType: null, //  纸张类型
				paperUsage: null, // 纸张使用
				printerNum: null // 打印数量
			},
			sysUser: {
				username: null // 设备物主
			},
			zxFileManagerCDE: {
				fileName: null // 文件标题
			},
			zxFileManagerAB: {
				fileName: null // 文件标题
			}
		},
		url:null
	},
	methods: {
		query: function () {
			vm.reload();
		},
        uploadView: function(){
            var code = getSelectedRow();
            if (code == null) {
                return;
            }
            console.log(code);
            vm.code=code;
            vm.showList = false;
            vm.title = "上传文件";
			vm.url = "";
        },
        saveOrUpdate:function(){
        	vm.showList = true;
            console.log( vm.code+"\n"+vm.url);
            $.ajax({
                type: "GET",
                url: baseURL + "zx/order/lawyer/update?filePath="+vm.url+"&orderCode="+vm.code,
                data: {

				},
                success: function (r) {
                    if (r.code === 200) {
                        alert('操作成功', function () {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
		},
        uploadFile: function (e) {
            var formData = new FormData();
            formData.append('file', e.target.files[0]);
            formData.append('type', 'c');
            formData.append('userId', localStorage.getItem("token"));
            $.ajax({
                url: baseURL+'upload/lawyer/file',//这里是后台接口需要换掉
                type: 'POST',
                dataType: 'json',
                cache: false,
                data: formData,
                processData: false,
                contentType: false,
                success: function (r) {
                    if (r.code === 0) {
                        vm.url = r.fileURL;
                    } else {
                        alert(r.msg);
                    }
                },
                error:function (r) {

                }
            })
        },
		reload: function () {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:
                {
                	'printCode': vm.q.printCode,
                	'printName': vm.q.printName,
                	'printHostId': vm.q.printHostId,
                	'lawyerName': vm.q.lawyerName,
                	'time1': vm.q.time1,
                	'time2': vm.q.time2
                },
                page:page
            }).trigger("reloadGrid");
		},
        upload: function () {
            var userId = getSelectedRow();
            if (userId == null) {
                return;
            }

        },
        download: function () {
            var userId = getSelectedRow();
            if (userId == null) {
                return;
            }
        },
	}
});

/**
 * 订单详情获取数据
 * @param id 订单id
 * @returns
 */
function orderInfo(id){
	layer.open({
		type: 1,
		skin: 'layui-layer-molv',
		title: "订单详情",
		area: ['80%', '70%'],
		shadeClose: false,
		content: jQuery("#orderInfo"),
		btn: ['返回'],
		success: function(){
			$.ajax({
				type: "GET",
			    url: baseURL + "zx/order/info/" + id,
			    dataType: "json",
			    success: function(r){
					vm.order = r.data;
					paperInfo(r);
				}
			});
		}
	});
}

/**
 * 获取纸张value
 * @returns
 */
function paperInfo(r){
	$.ajax({
		type: "GET",
	    url: baseURL + "zx/order/paperInfo",
	    dataType: "json",
	    data:{
	    	paperTypeId:r.data.zxOrderPrinterFile.paperType,
	        paperColcorId:r.data.zxOrderPrinterFile.paperColcor,
	        paperUsageId:r.data.zxOrderPrinterFile.paperUsage
	    },
	    success: function(res){
	    	vm.paperType = res.data[0].name;
	    	vm.paperColcor = res.data[1].name;
	    	vm.paperUsage = res.data[2].name;
		}
	});
}

layui.use('laydate', function(){
    var laydate = layui.laydate;
    //执行一个laydate实例
    laydate.render({
      elem: '#start', //指定元素
      done: function(data){
    	  vm.q.time1 = data;
      }
    });
    //执行一个laydate实例
    laydate.render({
      elem: '#end', //指定元素
      done: function(data){
    	  vm.q.time2 = data;
      }
    });
  });