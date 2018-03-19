package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.util.AesCbcUtil;
import com.zx.share.platform.vo.WeChatOAuthVo;
import com.zx.share.platform.vo.WeChatUserInfoVo;
import com.zx.share.platform.vo.WxAppletAuthVo;
import com.zx.share.platform.wechat.service.WeChatLoginService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by xmc1993 on 17/3/23.
 */
@Service
public class WeChatLoginServiceImpl implements WeChatLoginService {

    private static final Logger logger = LoggerFactory.getLogger(WeChatLoginServiceImpl.class);
    private final static String WE_CHAT_OAUTH_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";//第三方app OAuth地址
    private final static String USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";
    private final static String WX_APPLET_OAUTH_URL = "https://api.weixin.qq.com/sns/jscode2session";//微信小程序 OAuth地址

    @Override
    public WeChatOAuthVo getAccessToken(String appId, String secret, String grantType, String code) {
        String url = WE_CHAT_OAUTH_URL + "?appid=" + appId + "&secret=" + secret + "&grant_type=" + grantType + "&code=" + code;

        URI uri = URI.create(url);
        HttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(uri);
        WeChatOAuthVo authVo = new WeChatOAuthVo();

        HttpResponse response;
        try {
            response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();

                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
                StringBuilder sb = new StringBuilder();

                for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
                    sb.append(temp);
                }

                JSONObject object = new JSONObject(sb.toString().trim());

                String accessToken;
                try {
                    accessToken = object.getString("access_token");
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("第三方微信登录授权失败");
                    logger.error(object.toString());
                    return null;
                }
                authVo.setAccessToken(accessToken);
                authVo.setExpiresIn(object.getInt("expires_in"));
                authVo.setRefreshToken(object.getString("refresh_token"));
                authVo.setOpenId(object.getString("openid"));
                authVo.setScope(object.getString("scope"));
                try {
                    authVo.setUnionId(object.getString("unionid"));
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("第三方微信登录获取微信用户信息失败");
                    logger.error(object.toString());
                    //return null;
                }

                return authVo;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }


    @Override
    public WeChatUserInfoVo getUserInfo(String accessToken, String openId) {

        String uri = USER_INFO_URL + "?access_token=" + accessToken + "&openid=" + openId;
        HttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(URI.create(uri));
        try {
            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                StringBuilder builder = new StringBuilder();
                for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
                    builder.append(temp);
                }
                JSONObject object = new JSONObject(builder.toString().trim());

                String unionId=null;
                try {
                    unionId = object.getString("unionid");
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("第三方微信登录获取微信用户信息失败");
                    logger.error(object.toString());
                    //return null;
                }

                WeChatUserInfoVo weChatUserInfoVo = new WeChatUserInfoVo();
                weChatUserInfoVo.setUnionId(unionId);
                weChatUserInfoVo.setNickName(object.getString("nickname"));
                weChatUserInfoVo.setCity(object.getString("city"));
                weChatUserInfoVo.setProvince(object.getString("province"));
                weChatUserInfoVo.setCountry(object.getString("country"));
                weChatUserInfoVo.setSex(object.getInt("sex"));
                weChatUserInfoVo.setOpenId(object.getString("openid"));
                weChatUserInfoVo.setHeadImgUrl(object.getString("headimgurl"));
                return weChatUserInfoVo;
            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public WxAppletAuthVo getAppletSessionKey(String appId, String secret, String jsCode, String grantType) {
        String url = WX_APPLET_OAUTH_URL + "?appid=" + appId + "&secret=" + secret + "&grant_type=" + grantType + "&js_code=" + jsCode;

        URI uri = URI.create(url);
        HttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(uri);
        WxAppletAuthVo authVo = new WxAppletAuthVo();

        HttpResponse response;
        try {
            response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();

                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
                StringBuilder sb = new StringBuilder();

                for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
                    sb.append(temp);
                }

                JSONObject object = new JSONObject(sb.toString().trim());

                //获取Auth信息
                String sessionKey;
                try {
                    sessionKey = object.getString("session_key");
                } catch (Exception e) {//如果返回的结果不存在session_key那么说明返回结果错误
                    e.printStackTrace();
                    logger.error("小程序微信登录授权失败");
                    logger.error(object.toString());
                    return null;
                }
                authVo.setSessionKey(sessionKey);
                authVo.setOpenId(object.getString("openid"));

                return authVo;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public WeChatUserInfoVo getAppletUserInfo(String encryptedData, String iv, String sessionKey) {
        WeChatUserInfoVo weChatUserInfoVo = new WeChatUserInfoVo();

        // 2、对encryptedData加密数据进行AES解密
        try {
            String result = AesCbcUtil.decrypt(encryptedData, sessionKey, iv, "UTF-8");
            if (null != result && result.length() > 0) {

                JSONObject userInfoJSON = new JSONObject(result);

                weChatUserInfoVo.setNickName(userInfoJSON.getString("nickName"));
                weChatUserInfoVo.setCity(userInfoJSON.getString("city"));
                weChatUserInfoVo.setProvince(userInfoJSON.getString("province"));
                weChatUserInfoVo.setCountry(userInfoJSON.getString("country"));
                weChatUserInfoVo.setSex(userInfoJSON.getInt("gender"));
                weChatUserInfoVo.setOpenId(userInfoJSON.getString("openId"));
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("第三方微信登录获取微信用户信息失败");
                    logger.error(userInfoJSON.toString());
                    //return null;
                }
                weChatUserInfoVo.setHeadImgUrl(userInfoJSON.getString("avatarUrl"));

                return weChatUserInfoVo;
            }
        } catch (Exception e) {
            logger.error("解析加密用户信息失败");
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public String getGroupId(String encryptedData, String iv, String sessionKey) {
        logger.info(String.format("Get group id with encrypted data %s, iv %s, sessionKey %s", encryptedData, iv, sessionKey));
        // 2、对encryptedData加密数据进行AES解密
        try {
            String result = AesCbcUtil.decrypt(encryptedData, sessionKey, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                JSONObject json = new JSONObject(result);
                return json.getString("openGId");
            }
        } catch (Exception e) {
            logger.error("解析加密群信息失败");
            e.printStackTrace();
        }
        return null;
    }

}
