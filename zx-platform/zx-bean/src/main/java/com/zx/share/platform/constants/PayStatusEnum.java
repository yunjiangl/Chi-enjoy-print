package com.zx.share.platform.constants;

/**
 * Created by fenggang on 18/3/9.
 * 支付状态枚举
 * @author fenggang
 * @date 18/3/9
 */
public enum PayStatusEnum {

    ZX_PAY_STATUS_SUCCESS(1,"支付成功"),
    ZX_PAY_STATUS_REFUND(2,"转入退款"),
    ZX_PAY_STATUS_NOTPAY(3,"未支付"),
    ZX_PAY_STATUS_CLOSED(4,"已关闭"),
    ZX_PAY_STATUS_REVOKED(5,"已撤销"),
    ZX_PAY_STATUS_USERPAYING(6,"用户支付中"),
    ZX_PAY_STATUS_PAYERROR(7,"支付失败(其他原因，如银行返回失败)");

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
