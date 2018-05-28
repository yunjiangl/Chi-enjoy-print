package com.zx.share.platform.console.api.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CreationHelper;

import java.util.List;

/**
 * Created by Nominal on 2018/5/25 0025.
 * 微博：@Mr丶Li_Anonym
 */
public  class ExpostExcel {
    public static HSSFWorkbook wb=null;
    public static HSSFSheet hssfShee=null;
    public static HSSFCell cell=null;
    public static HSSFRow row=null;
    public static HSSFCellStyle style=null;
    public static void hssfRow(String sheet, List<String> head) {
        // 第一步，创建一个webbook，对应一个Excel文件

        wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        hssfShee = wb.createSheet(sheet);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        row = hssfShee.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        style = wb.createCellStyle();
        HSSFDataFormat format= wb.createDataFormat();
        style.setDataFormat(
                format.getFormat("yyyy-MM-dd  hh:mm:ss")
        );
        for (int i = 0; i < head.size(); i++) {
            if (i==2||i==9){
                cell = row.createCell((short) i);
                cell.setCellValue(head.get(i));
                cell.setCellStyle(style);
            }else {
                cell = row.createCell((short) i);
                cell.setCellValue(head.get(i));
            }

        }

    }
}
