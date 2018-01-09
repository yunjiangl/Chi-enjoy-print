	package com.exqoo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysOrder other = (SysOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getServiceFee() == null ? other.getServiceFee() == null : this.getServiceFee().equals(other.getServiceFee()))
            && (this.getPrintFee() == null ? other.getPrintFee() == null : this.getPrintFee().equals(other.getPrintFee()))
            && (this.getPayMethod() == null ? other.getPayMethod() == null : this.getPayMethod().equals(other.getPayMethod()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPayDate() == null ? other.getPayDate() == null : this.getPayDate().equals(other.getPayDate()))
            && (this.getClientId() == null ? other.getClientId() == null : this.getClientId().equals(other.getClientId()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getFileSize() == null ? other.getFileSize() == null : this.getFileSize().equals(other.getFileSize()))
            && (this.getFileColor() == null ? other.getFileColor() == null : this.getFileColor().equals(other.getFileColor()))
            && (this.getFilePlural() == null ? other.getFilePlural() == null : this.getFilePlural().equals(other.getFilePlural()))
            && (this.getFileId() == null ? other.getFileId() == null : this.getFileId().equals(other.getFileId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getServiceFee() == null) ? 0 : getServiceFee().hashCode());
        result = prime * result + ((getPrintFee() == null) ? 0 : getPrintFee().hashCode());
        result = prime * result + ((getPayMethod() == null) ? 0 : getPayMethod().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPayDate() == null) ? 0 : getPayDate().hashCode());
        result = prime * result + ((getClientId() == null) ? 0 : getClientId().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getFileSize() == null) ? 0 : getFileSize().hashCode());
        result = prime * result + ((getFileColor() == null) ? 0 : getFileColor().hashCode());
        result = prime * result + ((getFilePlural() == null) ? 0 : getFilePlural().hashCode());
        result = prime * result + ((getFileId() == null) ? 0 : getFileId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", serviceFee=").append(serviceFee);
        sb.append(", printFee=").append(printFee);
        sb.append(", payMethod=").append(payMethod);
        sb.append(", status=").append(status);
        sb.append(", payDate=").append(payDate);
        sb.append(", clientId=").append(clientId);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", userId=").append(userId);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", fileColor=").append(fileColor);
        sb.append(", filePlural=").append(filePlural);
        sb.append(", fileId=").append(fileId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}