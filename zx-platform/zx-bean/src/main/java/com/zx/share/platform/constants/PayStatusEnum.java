package com.zx.share.platform.constants;

/**
 * Created by fenggang on 18/3/9.
 * 支付状态枚举
 * @author fenggang
 * @date 18/3/9
 */
public enum PayStatusEnum {

    ZX_PAY_STATUS_XX(1,"");

    public int code;
    public String label;

    PayStatusEnum(int code, String label) {
        this.code = code;
        this.label = label;
    }

    /**
     * 获取状态码描述
     *
     * @param code
     *          状态码
     * @return 状态码描述，如果没有返回空串
     */
    public static String getLabel(int code) {
        String result = "";
        for (PayStatusEnum status : PayStatusEnum.values()) {
            if (status.code == code) {
                result = status.label;
            }
        }
        return result;
    }
}
