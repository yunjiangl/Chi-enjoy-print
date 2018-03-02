package com.zx.share.platform.util.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by fenggang on 18/2/1.
 *
 * @author fenggang
 * @date 18/2/1
 */
@ApiModel
public class DefaultResopnseBean<T> implements Serializable {

	private static final long serialVersionUID = -344174876853376813L;

	@ApiModelProperty(value = "返回文本信息（只有当code==200时才为空）")
	private String message ;
	@ApiModelProperty(value = "异常信息")
	private String exception ;
	@ApiModelProperty(value = "返回编码（200代表登录且返回数据成功")
	private Integer code = 200;
	@ApiModelProperty(value = "返回数据结果集")
	private T data;

	public void jsonFill(Integer code,String message){
		this.message = message;
		this.code = code;
	}
	public static DefaultResopnseBean<?> clone(String message,Integer code,Object object){
		return new DefaultResopnseBean<>(message, code, object);
	}

	public DefaultResopnseBean(String message, Integer code, T object) {
		super();
		this.message = message;
		this.code = code;
		this.data = object;
	}

	public static DefaultResopnseBean<?> clone(String message,Integer code,Object object,String exception){
		return new DefaultResopnseBean<>(message, code, object,exception);
	}

	public DefaultResopnseBean(String message, Integer code, T object,String exception) {
		super();
		this.message = message;
		this.code = code;
		this.data = object;
		this.exception = exception;
	}

	public DefaultResopnseBean() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
}
