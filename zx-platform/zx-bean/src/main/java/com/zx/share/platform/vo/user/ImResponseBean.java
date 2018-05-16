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
    private String userName;
    private String userPortrait;
    private String attorneyCode;
    private Long attorneyId;
    private String attorneyPortrait;
    private String attorneyName;
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

    public String getUserPortrait() {
        return userPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait;
    }

    public String getAttorneyCode() {
        return attorneyCode;
    }

    public void setAttorneyCode(String attorneyCode) {
        this.attorneyCode = attorneyCode;
    }

    public Long getAttorneyId() {
        return attorneyId;
    }

    public void setAttorneyId(Long attorneyId) {
        this.attorneyId = attorneyId;
    }

    public String getAttorneyPortrait() {
        return attorneyPortrait;
    }

    public void setAttorneyPortrait(String attorneyPortrait) {
        this.attorneyPortrait = attorneyPortrait;
    }

    public String getAttorneyName() {
        return attorneyName;
    }

    public void setAttorneyName(String attorneyName) {
        this.attorneyName = attorneyName;
    }
}
