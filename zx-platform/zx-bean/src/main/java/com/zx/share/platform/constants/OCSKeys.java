package com.zx.share.platform.constants;

/**
 * OCS Cache中存储的数据所用的Key的前缀.
 * 
 * @author fenggang
 */
public class OCSKeys {

  /**
   * 默认的访问Token的HTTP请求头的名字
   */
  public static final String ACCESS_TOKEN_HEADER_NAME = "X-Access-Token";
  /**
   * 客户端版本号
   */
  public static final String ACCESS_TOKEN_CLIENT_VERSION = "X-Client-Version";
  /**
   * 客户端设备型号
   */
  public static final String ACCESS_TOKEN_CLIENT_DEVICE = "X-Client-Device";
  /**
   * 客户端设备版本
   */
  public static final String ACCESS_TOKEN_CLIENT_TYPE = "X-Client-Type";
  /**
   * 客户端设备唯一标示
   */
  public static final String ACCESS_TOKEN_CLIENT_TOKEN = "X-Client-Token";

  /**
   * <pre>
   * ZX_TOKEN 缓存用户的key
   * 用法是: String key = ZX_TOKEN_USER_ + 123;
   * </pre>
   */
  public static final String ZX_TOKEN_USER_KEY = "ZX_TOKEN_USER_";

  /**
   * ZX_TOKEN用户过期时间(单位:秒，30天)
   */
  public static final int ZX_TOKEN_USER_EXP_KEY = 60 * 60 * 24 * 30;

  /**
   * ZX_TOKEN用户更改手机号key
   */
  public static final String ZX_USER_UPDATE_TEL_CODE_KEY = "ZX_USER_UPDATE_TEL_CODE_KEY_";
  
  /**
   * ZX_TOKEN用户忘记密码key
   */
  public static final String ZX_USER_FORGET_PWD_CODE_KEY = "ZX_USER_FORGET_PWD_CODE_KEY_";
  
  /**
   * ZX_TOKEN用户注册验证码key
   */
  public static final String ZX_USER_REGISTER_CODE_KEY = "ZX_USER_REGISTER_CODE_KEY_";

  /**
   * ZX_TOKEN用户注册验证码过期时间(单位:秒，5分)
   */
  public static final int ZX_USER_REGISTER_CODE_TIME_KEY = 60 * 5;
  
  /**
   * ZX_TOKEN用户登录验证码key
   */
  public static final String ZX_USER_LOGIN_CODE_KEY = "ZX_USER_LOGIN_CODE_KEY_";
  /**
   * ZX_TOKEN用户登录验证码过期时间(单位:秒，5分)
   */
  public static final int ZX_USER_LOGIN_CODE_TIME_KEY = 60 * 5;

  public static final String ZX_USRE_FORGET_PASSWORD_CODE_KEY = "ZX_USRE_FORGET_PASSWORD_CODE_KEY_";
  

  /**
   * ZX_TOKEN用户注册过期时间(单位:秒，30天)
   */
  public static final int ZX_USER_REGISTER_TIME_KEY = 60 * 60 * 24 * 30;

}
