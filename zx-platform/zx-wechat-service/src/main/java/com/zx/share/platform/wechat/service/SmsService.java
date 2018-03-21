package com.zx.share.platform.wechat.service;

/**
 * Created by fenggang on 18/3/7.
 *
 * @author fenggang
 * @date 18/3/7
 */
public interface SmsService {

    void smsTest() throws Exception;

    /**
     * 验证码发送
     * @param templateCode 短信模板code
     * @param mobiles  电话号码，多个号码用英文逗号分隔
     * @param signName  签名
     * @param templateParam  参数，格式为json（{"name":"Tom", "code":"123"}"）
     * @return  boolean
     * @throws Exception
     */
    boolean smsCode(String templateCode, String mobiles, String signName, String templateParam) throws Exception;
}
