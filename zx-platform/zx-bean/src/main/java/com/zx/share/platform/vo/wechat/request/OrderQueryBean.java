package com.zx.share.platform.vo.wechat.request;

import com.zx.share.platform.common.bean.PageRequestBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by fenggang on 18/3/19.
 *
 * @author fenggang
 * @date 18/3/19
 */
@ApiModel
public class OrderQueryBean extends PageRequestBean {

    @ApiModelProperty(value = "订单类型")
    private Integer orderType;
    @ApiModelProperty(value = "用户类型")
    private Integer userType;

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}