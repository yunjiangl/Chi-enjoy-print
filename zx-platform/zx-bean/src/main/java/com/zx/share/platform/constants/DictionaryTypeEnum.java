package com.zx.share.platform.constants;

/**
 * Created by fenggang on 18/3/9.
 * 订单状态枚举
 * @author fenggang
 * @date 18/3/9
 */
public enum DictionaryTypeEnum {

    ZX_DICTIONARY_TYPE_FILE_A(1,"zx_file_type_a"),
    ZX_DICTIONARY_TYPE_FILE_B(2,"zx_file_type_b");

    public int code;
    public String label;

    DictionaryTypeEnum(int code, String label) {
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
        for (DictionaryTypeEnum status : DictionaryTypeEnum.values()) {
            if (status.code == code) {
                result = status.label;
            }
        }
        return result;
    }
}
