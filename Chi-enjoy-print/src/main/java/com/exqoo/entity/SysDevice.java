package com.exqoo.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class SysDevice implements Serializable {
    private Long deviceId;

    /**
     * 设备编号
     */
    private String deviceCode;

    /**
     * 设备地址
     */
    private String deviceAddress;

    /**
     * 设备详细地址
     */
    private String deviceDetailedAddress;

    /**
     * 线下管理员
     */
    private String offlineAdmin;

    /**
     * 线下管理员联系电话
     */
    private String adminPhoneNum;

    /**
     * 设备状态
     */
    private Byte status;

    /**
     * 设备的位置
     */
    private String position;

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
        SysDevice other = (SysDevice) that;
        return (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getDeviceCode() == null ? other.getDeviceCode() == null : this.getDeviceCode().equals(other.getDeviceCode()))
            && (this.getDeviceAddress() == null ? other.getDeviceAddress() == null : this.getDeviceAddress().equals(other.getDeviceAddress()))
            && (this.getDeviceDetailedAddress() == null ? other.getDeviceDetailedAddress() == null : this.getDeviceDetailedAddress().equals(other.getDeviceDetailedAddress()))
            && (this.getOfflineAdmin() == null ? other.getOfflineAdmin() == null : this.getOfflineAdmin().equals(other.getOfflineAdmin()))
            && (this.getAdminPhoneNum() == null ? other.getAdminPhoneNum() == null : this.getAdminPhoneNum().equals(other.getAdminPhoneNum()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getDeviceCode() == null) ? 0 : getDeviceCode().hashCode());
        result = prime * result + ((getDeviceAddress() == null) ? 0 : getDeviceAddress().hashCode());
        result = prime * result + ((getDeviceDetailedAddress() == null) ? 0 : getDeviceDetailedAddress().hashCode());
        result = prime * result + ((getOfflineAdmin() == null) ? 0 : getOfflineAdmin().hashCode());
        result = prime * result + ((getAdminPhoneNum() == null) ? 0 : getAdminPhoneNum().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deviceId=").append(deviceId);
        sb.append(", deviceCode=").append(deviceCode);
        sb.append(", deviceAddress=").append(deviceAddress);
        sb.append(", deviceDetailedAddress=").append(deviceDetailedAddress);
        sb.append(", offlineAdmin=").append(offlineAdmin);
        sb.append(", adminPhoneNum=").append(adminPhoneNum);
        sb.append(", status=").append(status);
        sb.append(", position=").append(position);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}