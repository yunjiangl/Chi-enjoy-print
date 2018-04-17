package com.zx.share.platform.console.api.modules.user.controller;

import java.util.List;
import java.util.Map;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.console.api.modules.user.entity.UserEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zx.share.platform.console.api.modules.user.service.UserService;
import com.zx.share.platform.console.api.common.utils.PageUtils;
import com.zx.share.platform.console.api.common.utils.Query;
import com.zx.share.platform.console.api.common.utils.R;




/**
 * 用户
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		query.isPaging(true);
		List<ZxUser> userList = userService.queryList(query);
		int total = userService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	public R info(@PathVariable("userId") Long userId){
		ZxUser user = userService.queryObject(userId);
		
		return R.ok().put("user", user);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
//	@RequiresPermissions("user:user:save")
	public R save(@RequestBody ZxUser user){
		userService.save(user);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
//	@RequiresPermissions("user:user:update")
	public R update(@RequestBody ZxUser user){
		userService.update(user);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
//	@RequiresPermissions("user:user:delete")
	public R delete(@RequestBody Long[] userIds){
		userService.deleteBatch(userIds);
		
		return R.ok();
	}
	
}
