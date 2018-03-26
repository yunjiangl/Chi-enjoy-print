package com.zx.share.platform.constants;

/**
 * Created by fenggang on 18/3/9.
 * 订单状态枚举
 * @author fenggang
 * @date 18/3/9
 */
public enum DictionaryTypeEnum {

    ZX_DICTIONARY_TYPE_FILE_A(1001,"zx_file_type_a"),
    ZX_DICTIONARY_TYPE_FILE_B(1002,"zx_file_type_b"),
    ZX_DICTIONARY_TYPE_FILE_C(1003,"zx_file_type_c"),
    ZX_DICTIONARY_TYPE_FILE_D(1004,"zx_file_type_d"),
    ZX_DICTIONARY_TYPE_FILE_E(1005,"zx_file_type_e"),
    ZX_DICTIONARY_TYPE_ATTORNEY_DOMAIN(3,"zx_attorney_domain");

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
