package com.zx.share.platform.constants;

/**
 * Created by fenggang on 18/3/9.
 * 支付type类型枚举
 * @author fenggang
 * @date 18/3/9
 */
public enum PayTypeEnum {

    ZX_PAY_TYPE_WECHAT("微信支付","wechat");

    public String label;
    public String code;

    PayTypeEnum(String label, String code) {
        this.code = code;
        this.label = label;
    }


}
