package com.zx.share.platform.wechat.api.config;

import com.zx.share.platform.common.bean.UrlPatternConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 与session-url相关的配置信息。
 *
 *
 * @author fenggang
 * @date 7/28/17
 */
@ConfigurationProperties(prefix = "session")
@Component
public class UrlInterceptorConfig {

  private Long expiration;
  private UrlPatternConfig validationUrls;

  public Long getExpiration() {
    return expiration;
  }

  public void setExpiration(Long expiration) {
    this.expiration = expiration;
  }

  public UrlPatternConfig getValidationUrls() {
    return validationUrls;
  }

  public void setValidationUrls(UrlPatternConfig validationUrls) {
    this.validationUrls = validationUrls;
  }

}
