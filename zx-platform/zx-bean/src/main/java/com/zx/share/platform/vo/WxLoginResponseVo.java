package com.zx.share.platform.vo;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.util.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


@ApiModel
public class WxLoginResponseVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2215108177069764671L;
	@ApiModelProperty(value="用户id")
    private Long id;
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
    @ApiModelProperty("是否绑定手机号（2-绑定，1-未绑定）")
	private Integer binding = 2;

    public WxLoginResponseVo() {
    }

    public WxLoginResponseVo(ZxUser user) {
        this.id = user.getId();
        this.nickName = user.getNickname();
        this.mobile=user.getMobile();
        this.binding = StringUtil.isBlank(user.getMobile())?1:2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getBinding() {
        return binding;
    }

    public void setBinding(Integer binding) {
        this.binding = binding;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
