package com.zx.share.platform.vo.user;

import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

/**
 * Created by fenggang on 18/5/7.
 *
 * @author fenggang
 * @date 18/5/7
 */
public class LoginRequesVo implements Serializable {

    private String mobile;
    private String pwd;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
