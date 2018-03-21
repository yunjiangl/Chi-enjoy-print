package com.zx.share.platform.vo.wechat.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by fenggang on 18/3/20.
 *
 * @author fenggang
 * @date 18/3/20
 */
@ApiModel
public class UserDetailsBean implements Serializable {

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

    @ApiModelProperty("律师信息")
    private AttorneyDetailsBean attorney;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
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

    public AttorneyDetailsBean getAttorney() {
        return attorney;
    }

    public void setAttorney(AttorneyDetailsBean attorney) {
        this.attorney = attorney;
    }
}