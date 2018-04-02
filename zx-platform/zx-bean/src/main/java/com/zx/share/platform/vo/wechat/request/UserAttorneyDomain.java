package com.zx.share.platform.vo.wechat.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by fenggang on 18/3/22.
 *
 * @author fenggang
 * @date 18/3/22
 */
public class UserAttorneyDomain implements Serializable {

    @ApiModelProperty(value = "用户code")
    private String userCode;
    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "领域code")
    private String domainCode;
    @ApiModelProperty(value = "领域id、")
    private Long domainId;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }
}
