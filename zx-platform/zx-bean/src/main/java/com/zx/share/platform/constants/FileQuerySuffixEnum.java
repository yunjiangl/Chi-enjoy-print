package com.zx.share.platform.constants;

/**
 * Created by fenggang on 18/3/9.
 *
 * @author fenggang
 * @date 18/3/9
 */
public enum FileQuerySuffixEnum {

    ZX_FILE_QUERY_SUFFIX_A(1,"ab"), ZX_FILE_QUERY_SUFFIX_B(2,"ab"),
    ZX_FILE_QUERY_SUFFIX_C(3,"cde"), ZX_FILE_QUERY_SUFFIX_D(4,"cde"),
    ZX_FILE_QUERY_SUFFIX_E(5,"cde");

    public int code;
    public String label;

    FileQuerySuffixEnum(int code, String label) {
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
        for (FileQuerySuffixEnum status : FileQuerySuffixEnum.values()) {
            if (status.code == code) {
                result = status.label;
            }
        }
        return result;
    }
}
