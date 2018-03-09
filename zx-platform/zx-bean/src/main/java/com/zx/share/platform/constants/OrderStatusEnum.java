package com.zx.share.platform.constants;

/**
 * Created by fenggang on 18/3/9.
 * 订单状态枚举
 * @author fenggang
 * @date 18/3/9
 */
public enum OrderStatusEnum {

    ZX_ORDER_STATUS_XX(1,"");

    public int code;
    public String label;

    OrderStatusEnum(int code, String label) {
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
        for (OrderStatusEnum status : OrderStatusEnum.values()) {
            if (status.code == code) {
                result = status.label;
            }
        }
        return result;
    }
}
