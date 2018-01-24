package com.zx.share.platform.exception;

import com.zx.share.platform.constants.ErrorsEnum;

/**
 * 当登录无效时，使用该异常
 *
 * Created by fenggang on 7/28/17.
 */
public class NeedLoginException extends BusinessException {

  private static final long serialVersionUID = 1L;



  public NeedLoginException() {
    super();
  }

  /**
   * 构造函数
   *
   * @param code：错误码
   * @param codeLabel：错误码说明
   */
  public NeedLoginException(int code, String codeLabel) {
    setCode(code);
    setLabel(codeLabel);
  }

  /**
   * 构造函数
   *
   * @param code：错误码
   * @param codeLabel：错误码说明
   * @param message：异常说明
   */
  public NeedLoginException(int code, String codeLabel, String message) {
    setCode(code);
    setLabel(codeLabel);
  }

  /**
   * 构造函数
   *
   * @param code：错误码
   * @param codeLabel：错误码说明
   * @param message：异常说明
   * @param cause
   */
  public NeedLoginException(int code, String codeLabel, String message, Throwable cause) {
    setCode(code);
    setLabel(codeLabel);
  }

  /**
   * 构造函数
   *
   * @param error：错误码
   */
  public NeedLoginException(ErrorsEnum error) {
    setCode(error.code);
    setLabel(error.label);
  }

  /**
   * 构造函数
   *
   * @param error：错误码
   * @param message：异常说明
   */
  public NeedLoginException(ErrorsEnum error, String message) {
    setCode(error.code);
    setLabel(error.label);
  }

  /**
   * 构造函数
   *
   * @param error：错误码
   * @param message：异常说明
   * @param cause
   */
  public NeedLoginException(ErrorsEnum error, String message, Throwable cause) {
    setCode(error.code);
    setLabel(error.label);
  }


}
