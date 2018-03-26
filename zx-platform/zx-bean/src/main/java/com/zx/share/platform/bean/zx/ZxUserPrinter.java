package com.zx.share.platform.bean.zx;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zx.share.platform.bean.IdEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author
 */
@Entity
@Table(name = "zx_user_printer")
@Data
@EqualsAndHashCode(callSuper = false)
public class ZxUserPrinter extends IdEntity {

	private static final long serialVersionUID = -4863158811052787518L;
	
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "printer_id")
	private Long printerId;

	@Column(name = "status")
	private Integer status;

	@Column(name = "check_time")
	private Date checkTime;

	@Column(name = "check_id")
	private Long checkId;

	@Column(name = "user_code")
	private String userCode;

	@Column(name = "printer_code")
	private String printerCode;

	@Column(name = "check_code")
	private String checkCode;

	@Column(name = "create_id")
	private Long createId;

	@Column(name = "create_time")
	private Date createTime;

}