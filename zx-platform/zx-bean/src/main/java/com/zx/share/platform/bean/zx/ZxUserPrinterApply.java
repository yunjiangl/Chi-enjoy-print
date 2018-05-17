package com.zx.share.platform.bean.zx;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.zx.share.platform.bean.IdEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author
 */
@Entity
@Table(name = "zx_user_printer_apply")
@Data
@EqualsAndHashCode(callSuper = false)
public class ZxUserPrinterApply extends IdEntity {

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "printer_id")
	private Long printerId;

	@Column(name = "status")
	private Integer status;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "create_id")
	private Long createId;

	@Column(name = "check_time")
	private Date checkTime;

	@Column(name = "check_id")
	private Long checkId;

	@Transient
	private String userCode;

	@Transient
	private String checkCode;

	@Transient
	private String printerCode;
	
	@Transient
	private ZxUser zxUser;

	private static final long serialVersionUID = 1L;

}