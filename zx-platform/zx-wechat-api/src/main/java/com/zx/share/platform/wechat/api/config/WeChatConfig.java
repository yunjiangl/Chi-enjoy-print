package com.zx.share.platform.wechat.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
@ConfigurationProperties(prefix = "wechat")
@Component
public class WeChatConfig {

    private String loginAppId;
    private String loginAppSecret;

    public String getLoginAppId() {
        return loginAppId;
    }

    public void setLoginAppId(String loginAppId) {
        this.loginAppId = loginAppId;
    }

    public String getLoginAppSecret() {
        return loginAppSecret;
    }

    public void setLoginAppSecret(String loginAppSecret) {
        this.loginAppSecret = loginAppSecret;
    }
}
