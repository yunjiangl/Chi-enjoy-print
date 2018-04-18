package com.zx.share.platform.console.api.controller.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.bean.zx.ZxUserPrinterApply;
import com.zx.share.platform.console.service.sys.SysOwnerUserService;
import com.zx.share.platform.console.service.zx.ZxOrderService;
import com.zx.share.platform.console.service.zx.ZxPrinterManagerService;
import com.zx.share.platform.console.service.zx.ZxUserMapperService;
import com.zx.share.platform.console.service.zx.ZxUserPrinterApplyService;
import com.zx.share.platform.console.service.zx.ZxUserPrinterService;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("物主端接口")
public class OwnerController {

	@Autowired
	private SysOwnerUserService sysOwnerUserService;
	@Autowired
	private ZxUserMapperService zxUserMapperService;
	@Autowired
	private ZxUserPrinterApplyService zxUserPrinterApplyService;
	@Autowired
	private ZxUserPrinterService ZxUserPrinterService;

	private ZxOrderService zxOrderService;
	@Autowired
	private ZxPrinterManagerService zxPrinterManagerService;

	/**
	 * 物主端修改密码邮箱
	 */
	@RequestMapping(value = "/sys/updateOwnerById", method = RequestMethod.POST)
	@ApiOperation(value = "物主端修改密码邮箱", notes = "物主端")
	@ACSPermissions(permissions = "user:Integer")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "username", value = "用户名", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码名", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "email", value = "邮箱", required = true) })
	public DefaultResopnseBean<Object> updateOwnerById(String username, String password, String email) {
		Integer updateUserInt = sysOwnerUserService.updateOwerById(username, password, email);
		return new DefaultResopnseBean<Object>("成功", 200, updateUserInt);
	}

	/**
	 * 添加物主端收款信息
	 */
	@RequestMapping(value = "/sys/updateBank", method = RequestMethod.POST)
	@ApiOperation(value = "添加物主端收款信息", notes = "updateBank")
	@ACSPermissions(permissions = "user:Integer")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "openingBank", value = "开户行", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "province", value = "收款账号省份", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "city", value = "收款账号城市", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "region", value = "收款账号地区吗", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "accountNumber", value = "收款账号", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "accountName", value = "收款账户名称", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "userName", value = "当前用户名", required = true) })
	public DefaultResopnseBean<Object> updateBank(String openingBank, String province, String city, String region,
			String accountNumber, String accountName, String userName) {
		Integer updateBankInt = sysOwnerUserService.updateBank(openingBank, province, city, region, accountNumber,
				accountName, userName);
		return new DefaultResopnseBean<Object>("成功", 200, updateBankInt);
	}

	/**
	 * 查询全部设备列表
	 */

	@RequestMapping(value = "/sys/selectOwerList", method = RequestMethod.GET)
	@ApiOperation(value = "物主端设备列表", notes = "selectOwerList")
	@ACSPermissions(permissions = "user:list")
	public DefaultResopnseBean<List<SysUser>> selectOwerList() {
		List<SysUser> list = sysOwnerUserService.selectOwerList();
		return new DefaultResopnseBean<List<SysUser>>("成功", 200, list);
	}

	/**
	 * 设备列表禁用功能
	 */
	@RequestMapping(value = "/sys/updateOwenByCode", method = RequestMethod.POST)
	@ApiOperation(value = "设备列表禁用功能", notes = "updateOwenByCode")
	@ACSPermissions(permissions = "user:Integer")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "printerCode", value = "打印机Code", required = true) })
	public DefaultResopnseBean<Object> updateOwenByCode(String printerCode) {
		Integer updateOwenByCode = sysOwnerUserService.updateOwenByCode(printerCode);
		return new DefaultResopnseBean<Object>("成功", 200, updateOwenByCode);
	}

	/**
	 * 设备列表单行查询
	 */
	@RequestMapping(value = "/sys/selectOwerByCode", method = RequestMethod.GET)
	@ApiOperation(value = "设备列表单行查询", notes = "selectOwerByCode")
	@ACSPermissions(permissions = "user:SysUser")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "printerCode", value = "打印机Code", required = true) })
	public DefaultResopnseBean<List<SysUser>> selectOwerByCode(String printerCode) {
		SysUser selectOwerByCode = sysOwnerUserService.selectOwerByCode(printerCode);
		return new DefaultResopnseBean<List<SysUser>>("成功", 200, (List<SysUser>) selectOwerByCode);
	}

	/**
	 * 设备管理添加线上管理员遍历
	 */

	@RequestMapping(value = "/sys/selectOnlineAdmin", method = RequestMethod.GET)
	@ApiOperation(value = "遍历设备列表添加线上管理员列表", notes = "selectOnlineAdmin")
	@ACSPermissions(permissions = "user:list")
	public DefaultResopnseBean<List<ZxUser>> selectOnlineAdmin() {
		List<ZxUser> list = zxUserMapperService.selectOnlineAdmin();
		return new DefaultResopnseBean<List<ZxUser>>("成功", 200, list);
	}

	/**
	 * 设备列表添加线上管理员查看功能
	 */
	@RequestMapping(value = "/sys/selectOnlineAdminById", method = RequestMethod.GET)
	@ApiOperation(value = "备列表添加线上管理员查看功能 ", notes = "selectOnlineAdminById")
	@ACSPermissions(permissions = "user:ZxUser")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "用户id", required = true) })
	public DefaultResopnseBean<List<ZxUser>> selectOnlineAdminById(Long id) {
		ZxUser selectOwerById = zxUserMapperService.selectOnlineAdminById(id);
		return new DefaultResopnseBean<List<ZxUser>>("成功", 200, (List<ZxUser>) selectOwerById);
	}

	/**
	 * 
	 * @Title: list
	 * @Description: 物主端订单管理
	 */
	@ApiOperation(value = "所有订单分页接口", notes = "所有订单分页接口")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public DefaultResopnseBean<PageResponseBean<ZxOrder>> list(
			@ApiParam("第几页") @RequestParam(name = "page", required = false) Integer page,
			@ApiParam("每页多少条") @RequestParam(name = "pageSize", required = false) Integer pageSize,
			@ApiParam("设备编码") @RequestParam(name = "printCode", required = false) String printCode,
			@ApiParam("设备物主") @RequestParam(name = "printName", required = false) String printName,
			@ApiParam("律师用户名") @RequestParam(name = "lawyerName", required = false) String lawyerName,
			@ApiParam("订单支付时间1") @RequestParam(name = "time1", required = false) Date time1,
			@ApiParam("订单支付时间2") @RequestParam(name = "time2", required = false) Date time2) {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("page", page);
		param.put("pageSize", pageSize);
		param.put("printCode", printCode);
		param.put("printName", printName);
		param.put("lawyerName", lawyerName);
		param.put("time1", time1);
		param.put("time2", time2);

		return zxOrderService.list(param);
	}

	/**
	 * 
	 * @Title: info
	 * @Description: 物主端订单管理单行查询
	 */
	@RequestMapping(value = "info/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "订单信息", notes = "订单信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "订单id", required = true) })
	public DefaultResopnseBean<ZxOrder> info(@PathVariable(name = "id") Long id) {

		DefaultResopnseBean<ZxOrder> resopnseBean = new DefaultResopnseBean<ZxOrder>();

		ZxOrder data = zxOrderService.orderInfo(id);

		resopnseBean.setData(data);

		return resopnseBean;
	}

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
	 * @Title: update
	 * @Description: 修改设备
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ApiOperation(value = "修改打印机设备", notes = "修改打印机设备")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxPrinterManager", name = "zxPM", value = "设备信息", required = true) })
	@ACSPermissions(permissions = "zx:pm:update")
	public DefaultResopnseBean<Object> update(@RequestBody ZxPrinterManager zxPM) {

		return zxPrinterManagerService.update(zxPM);
	}

	/*
	*//**
		 * 禁用物主用户管理数据
		 */
	/*
	 * @RequestMapping(value="/sys/updateOwnerUser",method=RequestMethod.POST)
	 * 
	 * @ApiOperation(value="禁用物主用户管理数据",notes="物主用户管理")
	 * 
	 * @ACSPermissions(permissions = "user:Integer")
	 * 
	 * @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long",
	 * name = "userId", value = "当前用户组ID", required = true)}) public
	 * DefaultResopnseBean<Object> updateOwnerUser(Long userId){ Integer
	 * updateUserInt=sysOwnerUserService.updateOwnerUser(userId); return new
	 * DefaultResopnseBean<Object>("成功",200,updateUserInt); }
	 *//**
		 * 物主管理条件式查询（模糊查询） name 查询用户组的名字 perms 当前用户组状态（可用，禁用） time1 开始时间 time2 结束时间
		 */
	/*
	 * @RequestMapping(value="/sys/selectOwnerUserDim",method=RequestMethod.POST)
	 * 
	 * @ApiOperation(value="模糊查询物主用户组管理数据",notes="物主组管理")
	 * 
	 * @ACSPermissions(permissions = "role:list")
	 * 
	 * @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType =
	 * "String", name = "name", value = "查询用户组的名字", required = false),
	 * 
	 * @ApiImplicitParam(paramType = "query", dataType = "String", name = "perms",
	 * value = "当前用户组状态（可用，禁用）", required = false),
	 * 
	 * @ApiImplicitParam(paramType = "query", dataType = "Date", name = "time1",
	 * value = "开始时间", required = false),
	 * 
	 * @ApiImplicitParam(paramType = "query", dataType = "Date", name = "time2",
	 * value = "截至时间）", required = false)}) public
	 * DefaultResopnseBean<List<SysUser>> selectOwnerUserDim(String name,String
	 * perms,Date time1,Date time2){ List<SysUser>
	 * list=sysOwnerUserService.selectOwnerUserDim(name, perms, time1, time2);
	 * return new DefaultResopnseBean<List<SysUser>>("成功",200,list); }
	 *//**
		 * 修改物主用户管理数据
		 *//*
			 * @RequestMapping(value="/sys/updateOwnerUserById",method=RequestMethod.POST)
			 * 
			 * @ApiOperation(value="修改后台用户管理数据",notes="后台用户管理")
			 * 
			 * @ACSPermissions(permissions = "user:Integer")
			 * 
			 * @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long",
			 * name = "id", value = "当前用户组ID", required = true),
			 * 
			 * @ApiImplicitParam(paramType = "query", dataType = "String", name =
			 * "userName", value = "用户名", required = true),
			 * 
			 * @ApiImplicitParam(paramType = "query", dataType = "String", name = "salt",
			 * value = "昵称", required = false),
			 * 
			 * @ApiImplicitParam(paramType = "query", dataType = "String", name =
			 * "password", value = "密码", required = true),
			 * 
			 * @ApiImplicitParam(paramType = "query", dataType = "String", name = "email",
			 * value = "邮箱", required = false),
			 * 
			 * @ApiImplicitParam(paramType = "query", dataType = "Boolean", name = "isLock",
			 * value = "状态", required = true),
			 * 
			 * @ApiImplicitParam(paramType = "query", dataType = "String", name = "comment",
			 * value = "备注", required = true),
			 * 
			 * @ApiImplicitParam(paramType = "query", dataType = "Long", name = "roleId",
			 * value = "所属用户组", required = true)}) public DefaultResopnseBean<Object>
			 * updateOwnerUserById(Long id,String userName,String salt,String
			 * password,String email,Boolean isLock, String comment,Long roleId){ Integer
			 * updateUserInt=sysOwnerUserService.updateOwnerUserById(id, userName, salt,
			 * password, email, isLock, comment, roleId); return new
			 * DefaultResopnseBean<Object>("成功",200,updateUserInt); }
			 */

	/**
	 * 
	 * @Title: list
	 * @Description: 消息通知查询
	 */
	
	@RequestMapping(value = "/sys/selectNewsList", method = RequestMethod.GET)
	@ApiOperation(value = "消息通知查询", notes = "消息通知查询")
	@ACSPermissions(permissions = "user:news")
	public DefaultResopnseBean<PageResponseBean<ZxUserPrinterApply>> selectNewsList(
			@ApiParam("第几页") @RequestParam(name = "pageNum", required = false) Integer pageNum,
			@ApiParam("每页多少条数据") @RequestParam(name = "pageSize", required = false) Integer pageSize,
			@ApiParam("用户名") @RequestParam(name = "userName", required = false) String userName,
			@ApiParam("状态") @RequestParam(name = "status", required = false) Integer status
			) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageNum", pageNum);
		params.put("pageSize", pageSize);
		params.put("userName", userName);
		params.put("status", status);
		return zxUserPrinterApplyService.selectNewsList(params);
	}

	/**
	 * 
	 * @Title: addNews
	 * @Description: 接收消息通知
	 */
	@RequestMapping(value = "addNews", method = RequestMethod.POST)
	@ApiOperation(value = "接收消息通知", notes = "接收消息通知")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxPrinterManager", name = "zxPM", value = "设备信息", required = true) })
	@ACSPermissions(permissions = "user:addNews")
	public DefaultResopnseBean<Object> addNews(@RequestBody int Id) {

		return zxUserPrinterApplyService.addNews(Id);
	}
}
