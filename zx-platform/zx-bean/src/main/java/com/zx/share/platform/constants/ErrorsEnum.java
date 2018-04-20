package com.zx.share.platform.constants;

/**
 * Created by fenggang on 1/24/18.
 *
 * @author fenggang
 * @date 1/24/18
 */
public enum ErrorsEnum {

    // 0-200 系统级
    SUCCESS(200, "操作成功"),
    // 自定义错误，可以修改label
    SYSTEM_CUSTOM_ERROR(300, "自定义错误"),
    SYSTEM_DATA_ERROR(301, "数据异常"),
    SYSTEM_DATA_NOT_FOUND(302, "数据不存在"),
    SYSTEM_REQUEST_PARAM_ERROR(303, "请求参数错误"),
    SYSTEM_REQUEST_URL_ERROR(304, "请求路径错误"),

    //未登录状态，正常返回数据
    SYSTEM_NOT_LOGIN(400, "登录已失效"),
    //未登录
    SYSTEM_NOT_LOGIN_STATUS(600,"登录已失效"),
    SYSTEM_USER_STUTUS_LONGIN(602,"该账户已冻结,请联系管理员"),
    SYSTEM_USER_ERROR_LONGIN(603,"用户名或密码错误"),

    //getPermissions
    SYSTEM_USER_PERMISSIONS(650,"权限不足"),
    //用户已注册
    SYSTEM_USER_ERROR_STATUS(700,"发短信是判断用户是否存在"),
    //
    SYSTEM_ERROR(500, "系统错误"),
    SYSTEM_UPDATE_ERROR(501, "数据更新失败"),
    SYSTEM_BUSINESS_ERROR(502, "系统繁忙,请您稍后再试");

    public int code;
    public String label;

    ErrorsEnum(int code, String label) {
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
        for (ErrorsEnum status : ErrorsEnum.values()) {
            if (status.code == code) {
                result = status.label;
            }
        }
        return result;
    }
}
