package com.zx.share.platform.wechat.api.controller.zx;

import com.zx.share.platform.common.bean.SessionConfig;
import com.zx.share.platform.common.bean.UserCache;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.vo.wechat.request.UserUpdateBean;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;
import com.zx.share.platform.wechat.api.controller.BaseController;
import com.zx.share.platform.wechat.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
@Api(value = "/user", produces = "application/json", description = "用户接口")
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @RequestMapping(value = "/details/info", method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<UserDetailsBean> info(HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<UserDetailsBean> resopnseBean = new DefaultResopnseBean<>();
        UserCache user = (UserCache) request.getAttribute(SessionConfig.DEFAULT_REQUEST_DRUG_USER);
        if (user == null) {
            resopnseBean.jsonFill(ErrorsEnum.SYSTEM_NOT_LOGIN);
        }
        String code = user.getUserCode();
        resopnseBean.setData(userService.details(code));
        return resopnseBean;
    }

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<UserDetailsBean> details(@ApiParam("用户code") @RequestParam("code") String code,
                                                        HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<UserDetailsBean> resopnseBean = new DefaultResopnseBean<>();
        resopnseBean.setData(userService.details(code));
        return resopnseBean;
    }

    @ApiOperation(value = "用户信息修改", notes = "用户信息修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<Object> update(@ApiParam("微信号") @RequestParam("wechatId") String wechatId,
                                              @ApiParam("手机号") @RequestParam("mobile") String mobile,
                                              @ApiParam("头像") @RequestParam("portrait") String portrait,
                                              @ApiParam("年龄") @RequestParam("age") Integer age,
                                              @ApiParam("性别（男，女）") @RequestParam("gen") String gen,
                                              @ApiParam("省") @RequestParam("province") String province,
                                              @ApiParam("市") @RequestParam("city") String city,
                                              @ApiParam("区") @RequestParam("area") String area,
                                              @ApiParam("地址") @RequestParam("address") String address,
                                              @ApiParam("用户code") @RequestParam("userCode") String userCode, HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
        UserCache user = (UserCache) request.getAttribute(SessionConfig.DEFAULT_REQUEST_DRUG_USER);
        if (user == null) {
            resopnseBean.jsonFill(ErrorsEnum.SYSTEM_NOT_LOGIN);
        }
        UserUpdateBean updateBean = new UserUpdateBean();
        updateBean.setAddress(address);
        updateBean.setUserCode(userCode);
        updateBean.setWechatId(wechatId);
        updateBean.setAge(age);
        updateBean.setMobile(mobile);
        updateBean.setCity(city);
        updateBean.setPortrait(portrait);
        updateBean.setProvince(province);
        updateBean.setArea(area);
        updateBean.setGen(gen);

        userService.updateUser(updateBean);

        return resopnseBean;
    }

    @ApiOperation(value = "律师信息修改", notes = "律师信息修改")
    @RequestMapping(value = "/attorney/update", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<Object> attorneyUpdat(@ApiParam("微信号") @RequestParam("wechatId") String wechatId,
                                                     @ApiParam("用户code") @RequestParam("userCode") String userCode,
                                                     @ApiParam("手机号") @RequestParam("mobile") String mobile,
                                                     @ApiParam("头像") @RequestParam("portrait") String portrait,
                                                     @ApiParam("性别（男，女）") @RequestParam("gen") String gen,
                                                     @ApiParam("年龄") @RequestParam("age") Integer age,
                                                     @ApiParam("省") @RequestParam("province") String province,
                                                     @ApiParam("市") @RequestParam("city") String city,
                                                     @ApiParam("区") @RequestParam("area") String area,
                                                     @ApiParam("地址") @RequestParam("address") String address,
                                                     @ApiParam("审核图片") @RequestParam("checkImg") String checkImg,
                                                     @ApiParam("资格证图片") @RequestParam("attorneyCardImg") String attorneyCardImg,
                                                     @ApiParam("身份证图片") @RequestParam("identityCardImg") String identityCardImg,
                                                     @ApiParam("执业证号") @RequestParam("workNum") String workNum,
                                                     @ApiParam("执业机构") @RequestParam("workOrg") String workOrg,
                                                     @ApiParam("执业年限") @RequestParam("workYear") String workYear,
                                                     @ApiParam("领域（多个领域之间用英文逗号分隔）") @RequestParam("domains") String domains, HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
        UserCache user = (UserCache) request.getAttribute(SessionConfig.DEFAULT_REQUEST_DRUG_USER);
        if (user == null) {
            resopnseBean.jsonFill(ErrorsEnum.SYSTEM_NOT_LOGIN);
        }
        UserUpdateBean updateBean = new UserUpdateBean();
        updateBean.setAddress(address);
       // updateBean.setUserCode(user.getUserCode());
        updateBean.setUserCode(userCode);
        updateBean.setWechatId(wechatId);
        updateBean.setAge(age);
        updateBean.setGen(gen);
        updateBean.setMobile(mobile);
        updateBean.setCity(city);
        updateBean.setPortrait(portrait);
        updateBean.setProvince(province);
        updateBean.setArea(area);
        updateBean.setCheckImg(checkImg);
        updateBean.setAttorneyCardImg(attorneyCardImg);
        updateBean.setIdentityCardImg(identityCardImg);
        updateBean.setWorkNum(workNum);
        updateBean.setWorkYear(workYear);
        updateBean.setWorkOrg(workOrg);
        updateBean.setDomains(domains);
        userService.update(updateBean);
        return resopnseBean;
    }

}
