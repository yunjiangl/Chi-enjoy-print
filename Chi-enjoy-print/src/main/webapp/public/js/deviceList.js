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
									index : "device_id",
									width : 45,
									key : true
								},
								{
									label : '设备编码',
									name : 'deviceCode',
									index : "device_code",
									width : 75
								},
								{
									label : '设备物主',
									name : 'sysuser.nickname',
									index : "nickname",
									width : 75
								},
								{
									label : '审核状态',
									name : 'status',
									index : "status",
									width : 75,
									formatter : function(value, options, row) {
										return value === 0 ? '<span class="label label-danger">禁用</span>'
												: '<span class="label label-success">通过</span>';
									}
								}, {
									label : '设备地址',
									name : 'deviceDetailedAddress',
									index : "device_detailed_address",
									width : 75
								}, {
									label : '添加时间',
									name : 'createDate',
									index : "create_date",
									width : 75
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
	el : '#rrapp',
	data : {
		q : {
			fileName : null
		},
		showList : true,
		title : null
	},
	methods : {
		query : function() {
			vm.reload();
		},
		down : function() {
			var fileId = getSelectedRow();
			if (fileId == null) {
				return;
			}
			console.log(fileId);
			window.open("/sys/file/downLoad?fileId=" + fileId);
			/*
			 * $.ajax({ type : "POST", url : "/sys/file/downLoad", async :
			 * false, data : JSON.stringify(fileId) });
			 */

		},
		del : function() {
			var fileIds = getSelectedRows();
			if (fileIds == null) {
				return;
			}

			confirm('确定要删除选中的记录？', function() {
				$.ajax({
					type : "POST",
					url : "/sys/file/delete",
					data : JSON.stringify(fileIds),
					success : function(r) {
						if (r.code == 0) {
							alert('操作成功', function(index) {
								vm.reload();
							});
						} else {
							alert(r.msg);
						}
					}
				});
			});
		},
		reload : function(event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
				postData : {

				},
				page : page
			}).trigger("reloadGrid");
		}
	}
});