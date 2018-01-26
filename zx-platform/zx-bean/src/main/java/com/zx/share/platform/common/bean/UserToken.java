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
public class UserToken implements Serializable {

	private Integer status;
	private String name;
	private String permissions;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

}
