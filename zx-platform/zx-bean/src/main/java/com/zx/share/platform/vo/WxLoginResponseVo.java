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
    private String sex;
	@ApiModelProperty("头像url")
    private String headImageUrl;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
}
