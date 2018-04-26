package com.zx.share.platform.console.api.modules.app.controller;
import com.zx.share.platform.console.api.common.utils.R;
import com.zx.share.platform.console.api.modules.app.annotation.AuthIgnore;
import com.zx.share.platform.console.api.modules.app.annotation.Login;
import com.zx.share.platform.console.api.modules.app.annotation.LoginUser;
import com.zx.share.platform.console.api.modules.user.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * APP测试接口
 *
 * @author czx
 * @email object_czx@163.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/app")
public class ApiTestController {

    /**
     * 获取用户信息
     */
    @Login
    @GetMapping("userInfo")
    public R userInfo(@LoginUser UserEntity user){
        return R.ok().put("user", user);
    }

    /**
     * 获取用户ID
     */
    @Login
    @GetMapping("userId")
    public R userInfo(@RequestAttribute("userId") Integer userId){
        return R.ok().put("userId", userId);
    }

    /**
     * 忽略Token验证测试
     */
    @AuthIgnore
    @GetMapping("notToken")
    public R notToken(){
        return R.ok().put("apply", "无需token也能访问。。。");
    }

}
