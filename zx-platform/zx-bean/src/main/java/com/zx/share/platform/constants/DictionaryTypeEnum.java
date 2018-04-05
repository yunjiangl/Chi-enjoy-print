package com.zx.share.platform.constants;

/**
 * Created by fenggang on 18/3/9.
 * 字典type类型枚举
 * @author fenggang
 * @date 18/3/9
 */
public enum DictionaryTypeEnum {

    ZX_DICTIONARY_TYPE_FILE_A("a文件分类","zx_file_type_a"),
    ZX_DICTIONARY_TYPE_FILE_B("b文件分类","zx_file_type_b"),
    ZX_DICTIONARY_TYPE_FILE_C("c文件分类","zx_file_type_c"),
    ZX_DICTIONARY_TYPE_FILE_D("d文件分类","zx_file_type_d"),
    ZX_DICTIONARY_TYPE_FILE_E("e文件分类","zx_file_type_e"),
    ZX_DICTIONARY_TYPE_ATTORNEY_DOMAIN("律师领域","zx_attorney_domain"),
    ZX_DICTIONARY_ORDER_EARNINGS("收益","zx_order_earnings"),
    ZX_DICTIONARY_PRINTER_PAPER_TYPE("纸张类型","zx_printer_paper_type"),
    ZX_DICTIONARY_PRINTER_PAPER_COLOUR("纸张颜色","zx_printer_paper_colour"),
    ZX_DICTIONARY_PAINTER_PAPER_USE("纸张使用","zx_printer_paper_use");

    public String label;
    public String code;

    DictionaryTypeEnum(String label, String code) {
        this.code = code;
        this.label = label;
    }


}
