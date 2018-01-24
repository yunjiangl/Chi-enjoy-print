package com.zx.share.platform.wechat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @author
 */
@Table(name = "sys_device")
public class SysDevice implements Serializable {
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "device_id")
	private Long deviceId;

	/**
	 * 设备编号
	 */
	@Column(name = "device_code")
	private String deviceCode;

	/**
	 * 设备地址
	 */
	@Column(name = "device_address")
	private String deviceAddress;

	/**
	 * 设备详细地址
	 */
	@Column(name = "device_detailed_address")
	private String deviceDetailedAddress;

	/**
	 * 线下管理员
	 */
	@Column(name = "offline_admin")
	private String offlineAdmin;

	/**
	 * 线下管理员联系电话
	 */
	@Column(name = "admin_phone_num")
	private String adminPhoneNum;

	/**
	 * 设备状态
	 */
	@Column(name = "status")
	private Byte status;

	/**
	 * 设备的位置
	 */
	@Column(name = "position")
	private String position;

	@Column(name = "create_date")
	private Date createDate;
	
	@Transient
	private SysUser sysUser;
	
	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	private static final long serialVersionUID = 1L;

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getDeviceAddress() {
		return deviceAddress;
	}

	public void setDeviceAddress(String deviceAddress) {
		this.deviceAddress = deviceAddress;
	}

	public String getDeviceDetailedAddress() {
		return deviceDetailedAddress;
	}

	public void setDeviceDetailedAddress(String deviceDetailedAddress) {
		this.deviceDetailedAddress = deviceDetailedAddress;
	}

	public String getOfflineAdmin() {
		return offlineAdmin;
	}

	public void setOfflineAdmin(String offlineAdmin) {
		this.offlineAdmin = offlineAdmin;
	}

	public String getAdminPhoneNum() {
		return adminPhoneNum;
	}

	public void setAdminPhoneNum(String adminPhoneNum) {
		this.adminPhoneNum = adminPhoneNum;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminPhoneNum == null) ? 0 : adminPhoneNum.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((deviceAddress == null) ? 0 : deviceAddress.hashCode());
		result = prime * result + ((deviceCode == null) ? 0 : deviceCode.hashCode());
		result = prime * result + ((deviceDetailedAddress == null) ? 0 : deviceDetailedAddress.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((offlineAdmin == null) ? 0 : offlineAdmin.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysDevice other = (SysDevice) obj;
		if (adminPhoneNum == null) {
			if (other.adminPhoneNum != null)
				return false;
		} else if (!adminPhoneNum.equals(other.adminPhoneNum))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (deviceAddress == null) {
			if (other.deviceAddress != null)
				return false;
		} else if (!deviceAddress.equals(other.deviceAddress))
			return false;
		if (deviceCode == null) {
			if (other.deviceCode != null)
				return false;
		} else if (!deviceCode.equals(other.deviceCode))
			return false;
		if (deviceDetailedAddress == null) {
			if (other.deviceDetailedAddress != null)
				return false;
		} else if (!deviceDetailedAddress.equals(other.deviceDetailedAddress))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (offlineAdmin == null) {
			if (other.offlineAdmin != null)
				return false;
		} else if (!offlineAdmin.equals(other.offlineAdmin))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SysDevice [deviceId=" + deviceId + ", deviceCode=" + deviceCode + ", deviceAddress=" + deviceAddress
				+ ", deviceDetailedAddress=" + deviceDetailedAddress + ", offlineAdmin=" + offlineAdmin
				+ ", adminPhoneNum=" + adminPhoneNum + ", status=" + status + ", position=" + position + ", createDate="
				+ createDate + ", sysUser=" + sysUser + "]";
	}

	

}