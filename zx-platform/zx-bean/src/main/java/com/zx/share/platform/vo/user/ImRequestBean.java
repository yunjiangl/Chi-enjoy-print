package com.zx.share.platform.vo.user;

import com.zx.share.platform.common.bean.PageRequestBean;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by fenggang on 18/5/10.
 *
 * @author fenggang
 * @date 18/5/10
 */
@ApiModel
public class ImRequestBean extends PageRequestBean {

    private Integer userType;
    private String userCode;

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
