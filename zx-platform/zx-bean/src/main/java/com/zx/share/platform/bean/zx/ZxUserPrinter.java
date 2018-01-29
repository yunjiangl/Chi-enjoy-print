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
@Table(name="zx_user_printer")
@Data
@EqualsAndHashCode(callSuper = false)
public class ZxUserPrinter extends IdEntity {
   
	private static final long serialVersionUID = -4863158811052787518L;

	@Column(name = "zx_user_id")
	private Long zxUserId;

	@Column(name = "zx_printer_id")
    private Long zxPrinterId;

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

   
}