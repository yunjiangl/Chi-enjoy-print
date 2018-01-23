package com.zx.share.platform.zxbean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author
 */
@Table(name = "sys_order")
public class SysOrder implements Serializable {
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "order_id")
	private Long orderId;

	/**
	 * 律师服务费用
	 */
	@Column(name = "service_fee")
	private BigDecimal serviceFee;

	/**
	 * 打印费用
	 */
	@Column(name = "print_fee")
	private BigDecimal printFee;

	/**
	 * 支付方式（0：微信支付 1：其他）
	 */
	@Column(name = "pay_method")
	private String payMethod;

	/**
	 * 支付状态（0：未支付 1：支付）
	 */
	@Column(name = "status")
	private Byte status;

	/**
	 * 支付时间
	 */
	@Column(name = "pay_date")
	private Date payDate;

	/**
	 * 订单的客户
	 */
	@Column(name = "client_id")
	private Long clientId;

	/**
	 * 设备的id
	 */
	@Column(name = "device_id")
	private Long deviceId;

	/**
	 * 律师的id
	 */
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 文件纸张类型,默认A4
	 */
	@Column(name = "file_size")
	private String fileSize;

	/**
	 * 文件打印的颜色（0：黑白 1：彩色）
	 */
	@Column(name = "file_color")
	private Byte fileColor;

	/**
	 * 文件的单双面（0：单面 1：双面）
	 */
	@Column(name = "file_plural")
	private Byte filePlural;

	/**
	 * 文件的id
	 */
	@Column(name = "file_id")
	private Long fileId;

	/**
	 * 订单编号
	 */
	@Column(name = "order_code")
	private String orderCode;

	/**
	 * 打印份数
	 */
	@Column(name = "print_count")
	private int printCount;

	@Transient
	private BigDecimal payMoney;

	@Transient
	private SysDevice sysDevice;

	@Transient
	private SysFile sysFile;

	@Transient
	private SysUser sysUser;

	@Transient
	private SysClient sysClient;

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public SysDevice getSysDevice() {
		return sysDevice;
	}

	public void setSysDevice(SysDevice sysDevice) {
		this.sysDevice = sysDevice;
	}

	public SysFile getSysFile() {
		return sysFile;
	}

	public void setSysFile(SysFile sysFile) {
		this.sysFile = sysFile;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public SysClient getSysClient() {
		return sysClient;
	}

	public void setSysClient(SysClient sysClient) {
		this.sysClient = sysClient;
	}

	private static final long serialVersionUID = 1L;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}

	public BigDecimal getPrintFee() {
		return printFee;
	}

	public void setPrintFee(BigDecimal printFee) {
		this.printFee = printFee;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public Byte getFileColor() {
		return fileColor;
	}

	public void setFileColor(Byte fileColor) {
		this.fileColor = fileColor;
	}

	public Byte getFilePlural() {
		return filePlural;
	}

	public void setFilePlural(Byte filePlural) {
		this.filePlural = filePlural;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public int getPrintCount() {
		return printCount;
	}

	public void setPrintCount(int printCount) {
		this.printCount = printCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((fileColor == null) ? 0 : fileColor.hashCode());
		result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
		result = prime * result + ((filePlural == null) ? 0 : filePlural.hashCode());
		result = prime * result + ((fileSize == null) ? 0 : fileSize.hashCode());
		result = prime * result + ((orderCode == null) ? 0 : orderCode.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((payDate == null) ? 0 : payDate.hashCode());
		result = prime * result + ((payMethod == null) ? 0 : payMethod.hashCode());
		result = prime * result + printCount;
		result = prime * result + ((printFee == null) ? 0 : printFee.hashCode());
		result = prime * result + ((serviceFee == null) ? 0 : serviceFee.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((sysClient == null) ? 0 : sysClient.hashCode());
		result = prime * result + ((sysDevice == null) ? 0 : sysDevice.hashCode());
		result = prime * result + ((sysFile == null) ? 0 : sysFile.hashCode());
		result = prime * result + ((sysUser == null) ? 0 : sysUser.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		SysOrder other = (SysOrder) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (fileColor == null) {
			if (other.fileColor != null)
				return false;
		} else if (!fileColor.equals(other.fileColor))
			return false;
		if (fileId == null) {
			if (other.fileId != null)
				return false;
		} else if (!fileId.equals(other.fileId))
			return false;
		if (filePlural == null) {
			if (other.filePlural != null)
				return false;
		} else if (!filePlural.equals(other.filePlural))
			return false;
		if (fileSize == null) {
			if (other.fileSize != null)
				return false;
		} else if (!fileSize.equals(other.fileSize))
			return false;
		if (orderCode == null) {
			if (other.orderCode != null)
				return false;
		} else if (!orderCode.equals(other.orderCode))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (payDate == null) {
			if (other.payDate != null)
				return false;
		} else if (!payDate.equals(other.payDate))
			return false;
		if (payMethod == null) {
			if (other.payMethod != null)
				return false;
		} else if (!payMethod.equals(other.payMethod))
			return false;
		if (printCount != other.printCount)
			return false;
		if (printFee == null) {
			if (other.printFee != null)
				return false;
		} else if (!printFee.equals(other.printFee))
			return false;
		if (serviceFee == null) {
			if (other.serviceFee != null)
				return false;
		} else if (!serviceFee.equals(other.serviceFee))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (sysClient == null) {
			if (other.sysClient != null)
				return false;
		} else if (!sysClient.equals(other.sysClient))
			return false;
		if (sysDevice == null) {
			if (other.sysDevice != null)
				return false;
		} else if (!sysDevice.equals(other.sysDevice))
			return false;
		if (sysFile == null) {
			if (other.sysFile != null)
				return false;
		} else if (!sysFile.equals(other.sysFile))
			return false;
		if (sysUser == null) {
			if (other.sysUser != null)
				return false;
		} else if (!sysUser.equals(other.sysUser))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SysOrder [orderId=" + orderId + ", serviceFee=" + serviceFee + ", printFee=" + printFee + ", payMethod="
				+ payMethod + ", status=" + status + ", payDate=" + payDate + ", clientId=" + clientId + ", deviceId="
				+ deviceId + ", userId=" + userId + ", fileSize=" + fileSize + ", fileColor=" + fileColor
				+ ", filePlural=" + filePlural + ", fileId=" + fileId + ", orderCode=" + orderCode + ", printCount="
				+ printCount + ", sysDevice=" + sysDevice + ", sysFile=" + sysFile + ", sysUser=" + sysUser
				+ ", sysClient=" + sysClient + "]";
	}

}