package com.zx.share.platform.bean.sys;

import org.h2.api.DatabaseEventListener;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fenggang on 18/4/18.
 *
 * @author fenggang
 * @date 18/4/18
 */
public class SysUserLogin implements Serializable {

    private static final long serialVersionUID = -7289340357434763868L;
    private Long id;
    private Long userId;
    private Integer userType;
    private String loginIp;
    private Date loginTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
