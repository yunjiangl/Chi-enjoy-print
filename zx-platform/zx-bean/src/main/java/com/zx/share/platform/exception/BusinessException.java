package com.zx.share.platform.exception;

import com.zx.share.platform.constants.ErrorsEnum;

/**
 * <pre>
 * 业务异常，处理业务抛出的异常
 * 错误码和错误码说明，需要指定
 * </pre>
 * 
 * @author fenggang
 */
public class BusinessException extends Exception {
  private static final long serialVersionUID = -4310721413425427596L;
  /**
   * 错误码
   */
  private int code = ErrorsEnum.SYSTEM_ERROR.code;
  /**
   * 错误码的说明
   */
  private String label = ErrorsEnum.SYSTEM_ERROR.label;

  public BusinessException() {
    super();
  }

  /**
   * 构造函数
   * 
   * @param code：错误码
   * @param codeLabel：错误码说明
   */
  public BusinessException(int code, String codeLabel) {
    super(codeLabel);
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
  public BusinessException(int code, String codeLabel, String message) {
    super(message);
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
  public BusinessException(int code, String codeLabel, String message, Throwable cause) {
    super(message, cause);
    setCode(code);
    setLabel(codeLabel);
  }

  /**
   * 构造函数
   * 
   * @param error：错误码
   */
  public BusinessException(ErrorsEnum error) {
    setCode(error.code);
    setLabel(error.label);
  }

  /**
   * 构造函数
   * 
   * @param error：错误码
   * @param message：异常说明
   */
  public BusinessException(ErrorsEnum error, String message) {
    super(message);
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
  public BusinessException(ErrorsEnum error, String message, Throwable cause) {
    super(message, cause);
    setCode(error.code);
    setLabel(error.label);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

}
