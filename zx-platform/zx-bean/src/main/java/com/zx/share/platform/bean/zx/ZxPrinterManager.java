package com.zx.share.platform.bean.zx;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import com.zx.share.platform.bean.IdEntity;
import com.zx.share.platform.bean.sys.SysUser;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author
 */
@Entity
@Table(name = "zx_printer_manager")
@Data
@EqualsAndHashCode(callSuper = false)
public class ZxPrinterManager extends IdEntity {

	private static final long serialVersionUID = -8281307186982140914L;

	@NotEmpty
	@Column(name = "printer_code")
	private String printerCode;

	@Column(name = "name")
	private String name;

	/**
	 * 经度
	 */
	@NotEmpty
	@Column(name = "longitude")
	private Double longitude;

	@NotEmpty
	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "province")
	private String province;

	@Column(name = "city")
	private String city;

	@Column(name = "area")
	private String area;

	@Column(name = "address")
	private String address;

	@Column(name = "remark")
	private String remark;

	@Column(name = "create_id")
	private Long createId;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "update_id")
	private Long updateId;

	@Column(name = "update_time")
	private Date updateTime;

	/**
	 * 线下管理员名字
	 */
	@Column(name = "manager_name")
	private String managerName;

	/**
	 * 线下管理员联系电话
	 */
	@Column(name = "manager_phone")
	private String managerPhone;
	
	/**
	 * 设备状态
	 */
	@Column(name = "status")
	private Boolean status;

	@Transient
	private ZxUser zxUser;
	
	@Transient
	private ZxUserPrinter zxUserPrinter;
	
	@Transient
	private SysUser sysUser;
}