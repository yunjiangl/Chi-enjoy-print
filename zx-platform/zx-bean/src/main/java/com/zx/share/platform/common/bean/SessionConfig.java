package com.zx.share.platform.common.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 与session相关的配置信息。
 *
 *
 * @author fenggang
 * @date 7/28/17
 */
public class SessionConfig {

  public static final String DEFAULT_OPERATOR_REQUEST_ATTRIBUTE_NAME = "ZX_WEB_OPERATOR";
  public static final String DEFAULT_SESSION_COOKIE_NAME = "ZX_WEB_SESS_ID";
  public static final String DEFAULT_REQUEST_DRUG_USER = "ZX_WEB_REQUEST_DRUG_USER";

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
