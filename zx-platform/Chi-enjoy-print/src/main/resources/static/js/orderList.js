$(function() {

	$("#jqGrid").jqGrid({
		url : '/sys/order/list',
		datatype : "json",
		colModel : [ {
			label : '订单号',
			name : 'orderCode',
			index : "sys_order.order_code",
			width : 45,
			key : true
		}, {
			label : '设备物主',
			name : 'sysDevice.sysUser.nickname',
			sortable: false,
			width : 75
		}, {
			label : '设备编号',
			name : 'sysDevice.deviceCode',
			index : "sys_device.device_code",
			width : 75
		}, {
			label : '律师',
			name : 'sysUser.nickname',
			index : "sys_user.nickname",
			width : 75
		}, {
			label : '客户',
			name : 'sysClient.clientName',
			index : "sys_client.client_name",
			width : 75
		}, {
			label : '律师服务费',
			name : 'serviceFee',
			index : "sys_order.service_fee",
			width : 75
		}, {
			label : '打印费',
			name : 'printFee',
			index : "sys_order.print_fee",
			width : 75
		}, {
			label : '支付金额',
			name : 'payMoney',
			sortable: false,
			width : 75
		}, {
			label : '支付方式',
			name : 'payMethod',
			index : "sys_order.pay_method",
			width : 75,
			formatter : function(value, options, row) {
				return value === 0 ? '微信支付' : '其他';
			}
		}, {
			label : '支付时间',
			name : 'payDate',
			index : "sys_order.pay_date",
			width : 75
		}, {
			label : '操作',
			width : 75,
			formatter : function(options, row) {
				return '<button class="layui-btn">查看</span>';
			}
		} ],
		viewrecords : true,
		height : 385,
		rowNum : 10,
		rowList : [ 10, 30, 50 ],
		rownumbers : true,
		rownumWidth : 25,
		autowidth : true,
		multiselect : true,
		pager : "#jqGridPager",
		jsonReader : {
			root : "page.list",
			page : "page.currPage",
			total : "page.totalPage",
			records : "page.totalCount"
		},
		prmNames : {
			page : "page",
			rows : "limit",
			order : "order"
		},
		gridComplete : function() {
			// 隐藏grid底部滚动条
			$("#jqGrid").closest(".ui-jqgrid-bdiv").css({
				"overflow-x" : "hidden"
			});
		}
	});
});

var vm = new Vue({
	el : '.rrapp',
	data : {
		q : {
			deviceCode : null,
			deviceHost : null,
			nickname : null,
			startTime : null,
			endTime : null,
		},
		showList : true,
		title : null
	},
	methods : {
		query : function() {
			vm.reload();
		},
		reload : function(event) {
			vm.showList = true;
			var startTime = $(".combo-value").eq(0).val();
			var endTime = $(".combo-value").eq(1).val();
			console.log(startTime);
			console.log(endTime);
			var page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
				postData : {
					'deviceCode' : vm.q.deviceCode,
					'deviceHost' : vm.q.deviceHost,
					'nickName' : vm.q.nickname,
					'startTime' : startTime,
					'endTime' : endTime
				},
				page : page
			}).trigger("reloadGrid");
		}
	}
});