package com.zx.share.platform.util;

import java.util.Date;

/**
 * Created by fenggang on 18/3/26.
 * 编码统一生成器
 * @author fenggang
 * @date 18/3/26
 */
public class CodeBuilderUtil {

    /**
     * 用户唯一标识  来源2位+地区编号4位+7位id
     * @param source
     * @param areaNum
     * @param id
     * @return
     */
    public static synchronized String userCode(String source,String areaNum,String id){
        int idLeng = 7-id.length();
        id=padding(idLeng)+id;
        return source+areaNum+id;
    }

    /**
     * 文件编码 类型编码8位+8位id
     * @param dictionaryCode
     * @param id
     * @return
     */
    public static synchronized String fileCode(String dictionaryCode,String id){
        int idLeng = 8-id.length();
        id=padding(idLeng)+id;
        return dictionaryCode+id;
    }

    /**
     * 类型编码 类型4位+4位id
     * @param type
     * @param id
     * @return
     */
    public static synchronized String dictionaryCode(String type,String id){
        int idLeng = 4-id.length();
        id=padding(idLeng)+id;
        return type+id;
    }

    /**
     * 打印机code  来源2位+用户code15位+7位id
     * @param source
     * @param userCode
     * @param id
     * @return
     */
    public static synchronized String printerCode(String source,String userCode,String id){
        int idLeng = 7-id.length();
        id=padding(idLeng)+id;
        return source+userCode+id;
    }

    /**
     * 订单code 用户code15位+时间11位+4随机码
     * @param userCode
     * @return
     */
    public static synchronized String orderCOde(String userCode){
        String date = DateUtil.DATE_FORMAT_TIME.format(new Date());
        String randomCode = random(1000,9999);
        return userCode+date+randomCode;
    }

    private static String padding(Integer num){
        if(num==0){
            return "";
        }
        StringBuffer result = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            result.append("0");
        }
        return result.toString();
    }

    private static String random(int min,int max){
        long randomNum = Math.round(Math.random()*(max-min)+min);
        return randomNum+"";
    }
}
