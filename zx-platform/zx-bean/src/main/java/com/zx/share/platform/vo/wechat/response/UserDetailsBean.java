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
    private String gen;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("头像url")
    private String portrait;
    @ApiModelProperty("openId")
    private String openId;
    @ApiModelProperty("微信号")
    private String weChatId;
    @ApiModelProperty("省份")
    private String province;
    @ApiModelProperty("城市")
    private String city;
    @ApiModelProperty("地区")
    private String area;
    @ApiModelProperty("用户类型（1-普通用户，2-律师）")
    private Integer userType;
    @ApiModelProperty("用户状态（1-微信刚登陆，2-绑定手机号）")
    private Integer userStatus;

    @ApiModelProperty("律师信息")
    private AttorneyDetailsBean attorney;

    private String password;
    private Long id;
    private Integer isLock;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getWeChatId() {
        return weChatId;
    }

    public void setWeChatId(String weChatId) {
        this.weChatId = weChatId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

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

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }
}
