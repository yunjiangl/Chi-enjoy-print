package com.zx.share.platform.vo.user;

import java.io.Serializable;

/**
 * Created by fenggang on 18/5/7.
 *
 * @author fenggang
 * @date 18/5/7
 */
public class ImResponseBean implements Serializable {

    private String userCode;
    private Long userId;
    private String portrait;
    private String userName;
    private String time;

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

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
