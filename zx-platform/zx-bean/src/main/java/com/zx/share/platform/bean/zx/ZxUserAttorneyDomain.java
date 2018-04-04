/**
 * 
 */
package com.zx.share.platform.bean.zx;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zx.share.platform.bean.IdEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 曹聚丰
 *
 */
@Entity
@Table(name = "zx_user_attorney_domain")
@Data
@EqualsAndHashCode(callSuper = false)
public class ZxUserAttorneyDomain extends IdEntity{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "user_code")
	private String userCode;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "domain_id")
	private Long domainId;
	@Column(name = "domain_code")
	private String domainCode;

}
