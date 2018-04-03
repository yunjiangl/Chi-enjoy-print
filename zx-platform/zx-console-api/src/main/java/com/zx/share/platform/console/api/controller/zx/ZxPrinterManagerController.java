package com.zx.share.platform.console.api.controller.zx;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.console.service.zx.ZxPrinterManagerService;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @ClassName: ZxPrinterManagerController
 * @Description: 打印机管理接口
 * @author 芸江
 * @date 2018年1月30日 上午9:25:38
 *
 */
@RestController
@Api("打印机管理接口")
@RequestMapping("zx/pm/")
public class ZxPrinterManagerController {

	@Autowired
	private ZxPrinterManagerService zxPrinterManagerService;

	/**
	 * 
	 * @Title: add
	 * @Description: 添加设备
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "添加打印机设备", notes = "添加打印机设备")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxPrinterManager", name = "zxPM", value = "设备信息", required = true) })
	@ACSPermissions(permissions = "zx:pm:add")
	public DefaultResopnseBean<Object> add(@RequestBody ZxPrinterManager zxPM) {

		return zxPrinterManagerService.add(zxPM);
	}

	/**
	 * 
	 * @Title: updateStatus
	 * @Description: 改变设备状态
	 */
	@RequestMapping(value = "update/status", method = RequestMethod.POST)
	@ApiOperation(value = "更新设备状态", notes = "更新设备状态")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body", dataType = "ZxPrinterManager", name = "zxPM", value = "设备信息", required = true) })
	public DefaultResopnseBean<Object> updateStatus(@ApiParam("设备id") @RequestParam(name = "id", required = true) Long id,
			@ApiParam("设备状态") @RequestParam(name = "status", required = true) Boolean status) {
		ZxPrinterManager zxPM = new ZxPrinterManager();
		zxPM.setStatus(status);
		zxPM.setId(id);

		return zxPrinterManagerService.update(zxPM);
	}
	
	/**
	 * 
	 * @Title: updateInfo
	 * @Description: 审核设备信息
	 */
	@RequestMapping(value = "update/info", method = RequestMethod.POST)
	@ApiOperation(value = "审核设备信息", notes = "审核设备信息")
	public DefaultResopnseBean<Object> updateInfo(@RequestBody ZxPrinterManager zxPM) {
		return zxPrinterManagerService.update(zxPM);
	}

	/**
	 * 
	 * @Title: list
	 * @Description: 设备列表
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ApiOperation(value = "设备列表", notes = "设备列表")
	@ACSPermissions(permissions = "zx:pm:list")
	public DefaultResopnseBean<PageResponseBean<ZxPrinterManager>> list(
			@ApiParam("第几页") @RequestParam(name = "pageNum", required = false) Integer pageNum,
			@ApiParam("每页多少条数据") @RequestParam(name = "pageSize", required = false) Integer pageSize,
			@ApiParam("设备id") @RequestParam(name = "zxPMId", required = false) Long zxPMId,
			@ApiParam("设备编码") @RequestParam(name = "printerCode", required = false) String printerCode,
			@ApiParam("物主名称") @RequestParam(name = "nickname", required = false) String nickname,
			@ApiParam("物主id") @RequestParam(name = "sysUserId", required = false) Long sysUserId,
			@ApiParam("设备地址") @RequestParam(name = "address", required = false) String address,
			@ApiParam("设备状态") @RequestParam(name = "status", required = false) Boolean status,
			@ApiParam("开始时间") @RequestParam(name = "startTime", required = false) String startTime,
			@ApiParam("结束时间") @RequestParam(name = "endTime", required = false) String endTime) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("pageNum", pageNum);
		params.put("pageSize", pageSize);
		params.put("zxPMId", zxPMId);
		params.put("printerCode", printerCode);
		params.put("nickname", nickname);
		params.put("sysUserId",sysUserId);
		params.put("address", address);
		params.put("status", status);
		params.put("startTime", startTime);
		params.put("endTime", endTime);

		return zxPrinterManagerService.list(params);
	}

	/**
	 * 
	 * @Title: info
	 * @Description: 设备信息
	 */
	@RequestMapping(value = "info/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "设备信息", notes = "设备信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "设备id", required = true) })
	@ACSPermissions(permissions = "zx:pm:info")
	public DefaultResopnseBean<Object> info(@PathVariable(name = "id") Long id) {
		return zxPrinterManagerService.queryByZxPMId(id);
	}
}
