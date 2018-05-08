package com.zx.share.platform.wechat.api.controller.zx;

import com.alibaba.fastjson.JSON;
import com.zx.share.platform.common.bean.SessionConfig;
import com.zx.share.platform.common.bean.UserCache;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.wechat.api.controller.BaseController;
import com.zx.share.platform.wechat.service.ZxOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
@Api(value = "/pay", produces = "application/json", description = "支付接口")
@Controller
@RequestMapping("/pay")
public class PayController extends BaseController {

    @Autowired
    private ZxOrderService zxOrderService;

    @ApiOperation(value = "支付下单接口", notes = "支付下单接口")
    @RequestMapping(value = "/account",method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<Map<String,Object>> accountPay(@ApiParam("订单code")@RequestParam("code") String code, HttpServletRequest request, HttpServletResponse response){
        servletPath = request.getServletPath();
        DefaultResopnseBean<Map<String,Object>> resopnseBean = new DefaultResopnseBean<>();
//        UserCache user = (UserCache)request.getAttribute(SessionConfig.DEFAULT_REQUEST_DRUG_USER);
//        if(user==null){
//            resopnseBean.jsonFill(ErrorsEnum.SYSTEM_NOT_LOGIN);
//            return resopnseBean;
//        }
        Map<String,Object> map = zxOrderService.payUnifiedorder(code,"测试","oCdck0Y35dqWOzGfI36fmbUkXLKE","111.85.159.16");

        resopnseBean.setData(map);
        return resopnseBean;
    }

    @ApiOperation(value = "自动支付后回调接口", notes = "支付后回调接口")
    @RequestMapping(value = "/automation/callback")
    @ResponseBody
    public DefaultResopnseBean<Object> automation(HttpServletRequest request, HttpServletResponse response){
        servletPath = request.getServletPath();
        response.setContentType("text/html");
        response.setCharacterEncoding("gb2312");
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            request.getInputStream();
            String line = "";
            br = new BufferedReader(new InputStreamReader(
                    request.getInputStream()));
            while ((line = br.readLine()) != null) {
                sb.append(line);
                logger.info("回调数据：【{}】", line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sb != null && sb.toString().trim().length() > 0) {
            try {
                //TODO 解析支付回调数据

            } catch (Exception e) {
                e.printStackTrace();
                logger.debug("获转码回调返回数据失败");

            }
        }
        return null;
    }



    @ApiOperation(value = "手动支付后回调接口", notes = "支付后回调接口")
    @RequestMapping(value = "/manual/callback")
    @ResponseBody
    public DefaultResopnseBean<Object> manual(HttpServletRequest request, HttpServletResponse response){
        servletPath = request.getServletPath();

        return null;
    }
}
