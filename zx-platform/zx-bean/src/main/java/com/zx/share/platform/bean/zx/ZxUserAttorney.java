/**
 * 
 */
package com.zx.share.platform.bean.zx;

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
@Table(name = "zx_user_attorney")
@Data
@EqualsAndHashCode(callSuper = false)
public class ZxUserAttorney extends IdEntity {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "user_code")
	private String userCode;
	@Column(name = "work_year")
	private String workYear;
	@Column(name = "work_org")
	private String workOrg;
	@Column(name = "work_num")
	private String workNum;
	@Column(name = "domain")
	private String domain;
	@Column(name = "identity_card_img")
	private String identityCardImg;
	@Column(name = "attorney_card_img")
	private String attorneyCardImg;
	@Column(name = "check_img")
	private String checkImg;
}
