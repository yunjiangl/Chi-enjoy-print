$(function() {

	$("#jqGrid")
			.jqGrid(
					{
						url : '/sys/manage/device/list',
						datatype : "json",
						colModel : [
								{
									label : '设备ID',
									name : 'deviceId',
									index : "a.device_id",
									width : 45,
									key : true
								},
								{
									label : '设备编码',
									name : 'deviceCode',
									index : "a.device_code",
									width : 75
								},
								{
									label : '设备物主',
									name : 'sysUser.nickname',
									index : "a.nickname",
									width : 75
								},
								{
									label : '审核状态',
									name : 'status',
									index : "a.status",
									width : 75,
									formatter : function(value, options, row) {
										return value === 1 ? '通过' : '禁用';
									}
								},
								{
									label : '设备地址',
									name : 'deviceDetailedAddress',
									index : "a.device_detailed_address",
									width : 75
								},
								{
									label : '添加时间',
									name : 'createDate',
									index : "a.create_date",
									width : 75
								},
								{
									label : '操作',
									width : 75,
									formatter : function(options, row) {
										return '<button class="layui-btn">禁用</span>'
												+ '<button class="layui-btn">审核</span>';
									}
								} ],
						viewrecords : true,
						height : "80%",
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
			nickname : null,
			deviceDetailedAddress : null,
			status : null,
			startTime : null,
			endTime : null,
		},
		showList : true,
		title : null
	},
	methods : {
		query : function() {
			console.log("test3");
			vm.reload();
		},
		reload : function(event) {
			var startTime = $(".combo-value").eq(0).val();
			var endTime = $(".combo-value").eq(1).val();
			console.log('teset');
			console.log(startTime);
			console.log(endTime);
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
				postData : {
					'deviceCode' : vm.q.deviceCode,
					'nickName' : vm.q.nickname,
					'deviceAddress' : vm.q.deviceDetailedAddress,
					'status' : vm.q.status,
					'startTime' : startTime,
					'endTime' : endTime
				},
				page : page
			}).trigger("reloadGrid");
		}
	}
});