package com.zx.share.platform.common.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created by fenggang on 1/24/18.
 *
 * @author fenggang
 * @date 1/24/18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserCache implements Serializable {

	private Long id;
	private String userCode;
	private Integer status;
	private Integer userType;
	private String name;
	private String permissions;


}
