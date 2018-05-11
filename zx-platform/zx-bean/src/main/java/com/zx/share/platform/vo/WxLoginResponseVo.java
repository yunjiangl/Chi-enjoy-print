package com.zx.share.platform.vo;

import com.zx.share.platform.bean.zx.ZxUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


@ApiModel
public class WxLoginResponseVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2215108177069764671L;
	@ApiModelProperty(value="用户Code")
    private String userCode;
	@ApiModelProperty(value="token")
    private String accessToken;
    @ApiModelProperty("手机号")
    private String mobile;
	@ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("性别")
    private Integer grad;
    @ApiModelProperty("年龄")
    private Integer age;
	@ApiModelProperty("头像url")
    private String headImageUrl;
	@ApiModelProperty("用户类型（1-普通用户，2-律师）")
	private Integer userType;
    @ApiModelProperty("用户状态（1-微信刚登陆，2-绑定手机号）")
    private Integer userStatus;
    private String openId;
    private Integer isLock;

    public WxLoginResponseVo() {
    }

    public WxLoginResponseVo(ZxUser user) {
        this.userCode = user.getUserCode();
        this.nickName = user.getNickname();
        this.mobile=user.getMobile();
    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getGrad() {
        return grad;
    }

    public void setGrad(Integer grad) {
        this.grad = grad;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }
}
