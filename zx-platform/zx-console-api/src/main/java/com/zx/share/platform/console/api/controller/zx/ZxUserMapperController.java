/**
 * 
 */
package com.zx.share.platform.console.api.controller.zx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.console.service.zx.ZxUserMapperService;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author 曹聚丰
 *
 */
@Controller
@Api("设备管理员接口")
@RequestMapping("zx/um/")
public class ZxUserMapperController {

	@Autowired
	private ZxUserMapperService zxUserMapperService;

	/**
	 * 设备管理添加线上管理员遍历
	 */
	@RequestMapping(value = "selectOnlineAdmin", method = RequestMethod.GET)
	@ApiOperation(value = "设备管理线上管理员分页遍历", notes = "selectOnlineAdmin")
	@ACSPermissions(permissions = "zx:um:list")
	@ResponseBody
	public DefaultResopnseBean<PageResponseBean<ZxUser>> selectOnlineAdminByPage(
			@ApiParam("第几页") @RequestParam(name = "page", required = false) Integer page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		return zxUserMapperService.selectAdminByPage(params);
	}

	/**
	 * 
	 * @设备管理添加线上管理员查看功能
	 * @return
	 */
	@RequestMapping(value = "selectOnlineAdminById", method = RequestMethod.GET)
	@ApiOperation(value = "设备列表添加线上管理员列表查看接口", notes = "selectOnlineAdminById")
	@ACSPermissions(permissions = "zx:um:info")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "管理员id", required = true) })
	@ResponseBody
	public DefaultResopnseBean<ZxUser> selectOnlineAdminById(Long id) {
		ZxUser selectAdminById = zxUserMapperService.selectOnlineAdminById(id);
		return new DefaultResopnseBean<ZxUser>("成功", 200, selectAdminById);

	}
}
