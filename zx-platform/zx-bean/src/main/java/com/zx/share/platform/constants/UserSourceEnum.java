package com.zx.share.platform.constants;

/**
 * Created by fenggang on 18/3/26.
 *
 * @author fenggang
 * @date 18/3/26
 */
public enum UserSourceEnum {

    ZX_USER_SOURCE_WECHAT(10,"wechat");

    public Integer code;
    public String label;

    UserSourceEnum(Integer code, String label) {
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
        for (UserSourceEnum status : UserSourceEnum.values()) {
            if (status.code == code) {
                result = status.label;
            }
        }
        return result;
    }
}
