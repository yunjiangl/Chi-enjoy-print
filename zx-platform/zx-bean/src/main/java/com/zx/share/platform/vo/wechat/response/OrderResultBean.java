package com.zx.share.platform.vo.wechat.response;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by fenggang on 18/3/9.
 *
 * @author fenggang
 * @date 18/3/9
 */
@ApiModel
public class OrderResultBean implements Serializable {

    private String orderCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
