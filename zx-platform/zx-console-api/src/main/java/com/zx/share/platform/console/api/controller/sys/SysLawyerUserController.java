package com.zx.share.platform.console.api.controller.sys;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.console.service.sys.SysLawyerUserService;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("律师用户管理接口")
public class SysLawyerUserController {

	@Autowired
	private SysLawyerUserService sysLawyerUserService;
	
	/**
	 * 
	 * @Title: updateStatus
	 * @Description: 改变律师状态
	 */
	@RequestMapping(value = "/lawyer/update/status", method = RequestMethod.POST)
	@ApiOperation(value = "改变律师状态", notes = "改变律师状态")
	public DefaultResopnseBean<Object> updateStatus(@ApiParam("设备id") @RequestParam(name = "id", required = true) Long id,
			@ApiParam("设备状态") @RequestParam(name = "status", required = true) Boolean status) {
		ZxUser zxUser = new ZxUser();
		zxUser.setIsLock(status);
		zxUser.setId(id);

		return sysLawyerUserService.update(zxUser);
	}
	
	/**
	 * 
	 * @Title: updateInfo
	 * @Description: 审核律师信息
	 */
	@RequestMapping(value = "/lawyer/update/info", method = RequestMethod.POST)
	@ApiOperation(value = "审核律师信息", notes = "审核律师信息")
	public DefaultResopnseBean<Object> updateInfo(@RequestBody ZxUser zxUser) {
		return sysLawyerUserService.update(zxUser);
	}
	
	/**
	 * 
	 * @Title: list
	 * @Description: 设备列表
	 */
	@RequestMapping(value = "/lawyer/list", method = RequestMethod.GET)
	@ApiOperation(value = "律师列表", notes = "律师列表")
	public DefaultResopnseBean<PageResponseBean<ZxUser>> list(
			@ApiParam("第几页") @RequestParam(name = "pageNum", required = false) Integer pageNum,
			@ApiParam("每页多少条数据") @RequestParam(name = "pageSize", required = false) Integer pageSize,
			@ApiParam("律师名称") @RequestParam(name = "nickname", required = false) String nickname,
			@ApiParam("律师状态") @RequestParam(name = "status", required = false) Boolean status,
			@ApiParam("开始时间") @RequestParam(name = "startTime", required = false) String startTime,
			@ApiParam("结束时间") @RequestParam(name = "endTime", required = false) String endTime) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("pageNum", pageNum);
		params.put("pageSize", pageSize);
		params.put("nickname", nickname);
		params.put("status", status);
		params.put("startTime", startTime);
		params.put("endTime", endTime);

		return sysLawyerUserService.list(params);
	}
	
	/**
	 * 
	 * @Title: info
	 * @Description: 设备信息
	 */
	@RequestMapping(value = "/lawyer/info/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "律师信息", notes = "律师信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "律师id", required = true) })
	public DefaultResopnseBean<Object> info(@PathVariable(name = "id") Long id) {
		return sysLawyerUserService.queryByZxPMId(id);
	}
}
