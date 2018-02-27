package com.zx.share.platform.wechat.api.pay.util;

import com.alibaba.fastjson.JSONObject;
import com.lorne.core.framework.utils.http.HttpUtils;
import com.zx.share.platform.wechat.api.pay.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeixinUtils {


    //    /**
//     * 统一下单
//     *
//     * @param name      商品名称
//     * @param total_fee 价格（单位：分）
//     * @param ip        ip
//     */
    public static Map<String, Object> payUnifiedorder(WxConfig config, String name, String detail, int total_fee, String ip, String out_trade_no, String openid, String trade_type) {

        UnifiedorderPayReqData unifiedorderPayReqData = new UnifiedorderPayReqData(config.getKey(),
                config.getAppId(), config.getMchId(), "", name, detail, "",
                out_trade_no, "", total_fee, ip, "", "", "",
                config.getNotifyUrl(), trade_type, "", openid);
        String postDataXML = unifiedorderPayReqData.toXml();
        LogUtils.logResult("请求统一下单参数", postDataXML);
        try {
            String res = HttpUtils.postXml(HttpApiUrl.PAY_UNFIFIEDORDER,
                    postDataXML);
            LogUtils.logResult("响应统一下单参数", res);
            Map<String, Object> map = XMLParser.getMapFromXML(res);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * 提交刷卡支付
     *
     * @param config     支付配置文件
     * @param authCode   支付码
     * @param deviceInfo 设备号
     * @param body       商品描述
     * @param outTradeNo 商户订单号
     * @param ip         ip地址
     * @param totalFee   订单金额
     * @return 支付结果
     */
    public static Map<String, Object> payMicropay(WxConfig config, String authCode, String deviceInfo, String body, String outTradeNo, String ip, int totalFee) {
        MicroPayReqData mPayReqData = new MicroPayReqData(
                config.getAppId(), config.getMchId(), authCode, config.getKey(), deviceInfo, body, outTradeNo, totalFee, ip
        );
        String postDataXML = mPayReqData.toXml();
        LogUtils.logResult("请求统一下单参数", postDataXML);
        try {
            String res = HttpUtils.postXml(HttpApiUrl.PAY_MICROPAY,
                    postDataXML);
            LogUtils.logResult("响应统一下单参数", res);
            Map<String, Object> map = XMLParser.getMapFromXML(res);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Map<String, Object> refund(WxConfig config, String out_trade_no, String out_refund_no, int total_fee, int refund_fee) {
        RefundReqData reqData = new RefundReqData(config.getKey(), config.getAppId(), config.getMchId(), out_trade_no, out_refund_no, total_fee, refund_fee, config.getMchId());
        String postDataXML = reqData.toXml();
        LogUtils.logResult("请求申请退款", postDataXML);
        try {
            HttpsRequest httpsRequest = new HttpsRequest(config);
            String res = httpsRequest.sendPost(HttpApiUrl.PAY_REFUND_API, postDataXML);
            LogUtils.logResult("响应申请退款", res);
            Map<String, Object> map = XMLParser.getMapFromXML(res);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Map<String, Object> closeOrder(WxConfig config, String out_trade_no) {
        CloseOrderReqData reqData = new CloseOrderReqData(config.getKey(), config.getAppId(), config.getMchId(), out_trade_no);
        String postDataXML = reqData.toXml();
        LogUtils.logResult("请求关闭订单", postDataXML);
        try {
            String res = HttpUtils.postXml(HttpApiUrl.PAY_CLOSE_ORDER_API,
                    postDataXML);
            LogUtils.logResult("响应关闭订单", res);
            Map<String, Object> map = XMLParser.getMapFromXML(res);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Map<String, Object> transfers(WxConfig config, String partner_trade_no, String openid, String check_name,
                                                String re_user_name, int amount, String desc, String spbill_create_ip) {
        TransfersReqData reqData = new TransfersReqData(config.getKey(), config.getAppId(), config.getMchId(), partner_trade_no, openid, check_name, re_user_name, amount, desc, spbill_create_ip);
        String postDataXML = reqData.toXml();
        LogUtils.logResult("请求企业付款订单", postDataXML);
        try {
            HttpsRequest httpsRequest = new HttpsRequest(config);
            String res = httpsRequest.sendPost(HttpApiUrl.PAY_PROMOTION_TRANSFERS, postDataXML);
            LogUtils.logResult("响应企业付款订单", res);

            Map<String, Object> map = XMLParser.getMapFromXML(res);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> refundQuery(WxConfig config, String out_trade_no) {
        RefundQueryReqData reqData = new RefundQueryReqData(config.getKey(), config.getAppId(), config.getMchId(), out_trade_no);
        String postDataXML = reqData.toXml();
        LogUtils.logResult("请求查询退款订单", postDataXML);
        try {
            String res = HttpUtils.postXml(HttpApiUrl.PAY_REFUND_QUERY_API,
                    postDataXML);
            LogUtils.logResult("响应查询退款订单", res);

            Map<String, Object> map = XMLParser.getMapFromXML(res);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> payOrderquery(WxConfig config, String out_trade_no) {
        ScanPayQueryReqData scanPayQueryReqData = new ScanPayQueryReqData(config, null,
                out_trade_no);
        String postDataXML = scanPayQueryReqData.toXml();
        LogUtils.logResult("请求查询订单", postDataXML);
        try {
            String res = HttpUtils
                    .postXml(HttpApiUrl.PAY_QUERY_API, postDataXML);
            LogUtils.logResult("响应查询订单", res);

            Map<String, Object> map = XMLParser.getMapFromXML(res);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> jscode2session(WxConfig config, String jsCode) {
        String url = HttpApiUrl.JSCODE_SESSION_API + "?appid=" + config.getAppId() + "&secret=" + config.getAppSecret() + "&js_code=" + jsCode + "&grant_type=authorization_code";
        Map<String, Object> map = null;
        String res = HttpUtils.get(url);
        LogUtils.logResult("获取sessionKey与opendId订单", res);
        try {
            map = JSONObject.parseObject(res);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }


    public static Map<String, Object> getAccessToken(WxConfig config) {
        String url = String.format(HttpApiUrl.PAY_ACCESS_TOKEN, config.getAppId(), config.getAppSecret());
        Map<String, Object> map = null;
        String res = HttpUtils.get(url);
        LogUtils.logResult("获取ACCESS_TOKEN", res);
        try {
            map = JSONObject.parseObject(res);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }

    public static Map<String, Object> pushMsg(String accessToken, String touser, String templateId, String formId, List<TemplateMsg> value) {
        String url = String.format(HttpApiUrl.SEND_MSG, accessToken);

        Map<String, Object> data = new HashMap<>();
        data.put("touser", touser);
        data.put("template_id", templateId);
        data.put("form_id", formId);
        Map<String, Object> msgs = new HashMap<>();
        for (int i = 0; i < value.size(); i++) {
            TemplateMsg msg = value.get(i);
            msgs.put("keyword" + (i + 1), msg);
        }
        data.put("data", msgs);
        String json = new JSONObject(data).toJSONString();
        System.out.println(json);
        String res = HttpUtils.postJson(url, json);
        LogUtils.logResult("发送模板消息", res);
        Map<String, Object> map = null;
        try {
            map = JSONObject.parseObject(res);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }


}
