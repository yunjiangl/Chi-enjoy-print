package com.zx.share.platform.vo.wechat.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

/**
 * Created by fenggang on 18/3/22.
 *
 * @author fenggang
 * @date 18/3/22
 */
@ApiModel
public class UserUpdateBean implements Serializable {

    @ApiModelProperty(value = "")
    private Long userId;
    @ApiModelProperty(value = "")
    private String userCode;
    @ApiModelProperty(value = "")
    private String wechatId;
    @ApiModelProperty(value = "")
    private String mobile;
    @ApiModelProperty(value = "")
    private String portrait;
    @ApiModelProperty(value = "")
    private Integer age;
    @ApiModelProperty(value = "")
    private String province;
    @ApiModelProperty(value = "")
    private String city;
    @ApiModelProperty(value = "")
    private String area;
    @ApiModelProperty(value = "")
    private String address;
    @ApiModelProperty(value = "")
    private String checkImg;
    @ApiModelProperty(value = "")
    private String attorneyCardImg;
    @ApiModelProperty(value = "")
    private String identityCardImg;
    @ApiModelProperty(value = "")
    private String workNum;
    @ApiModelProperty(value = "")
    private String workOrg;
    @ApiModelProperty(value = "")
    private String workYear;
    @ApiModelProperty(value = "")
    private String domains;
    @ApiModelProperty(value = "")
    private String unionId;
    @ApiModelProperty(value = "")
    private String openId;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCheckImg() {
        return checkImg;
    }

    public void setCheckImg(String checkImg) {
        this.checkImg = checkImg;
    }

    public String getAttorneyCardImg() {
        return attorneyCardImg;
    }

    public void setAttorneyCardImg(String attorneyCardImg) {
        this.attorneyCardImg = attorneyCardImg;
    }

    public String getIdentityCardImg() {
        return identityCardImg;
    }

    public void setIdentityCardImg(String identityCardImg) {
        this.identityCardImg = identityCardImg;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    public String getWorkOrg() {
        return workOrg;
    }

    public void setWorkOrg(String workOrg) {
        this.workOrg = workOrg;
    }

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
    }

    public String getDomains() {
        return domains;
    }

    public void setDomains(String domains) {
        this.domains = domains;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
