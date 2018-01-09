package com.exqoo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 
 */
@Table(name = "sys_client")
public class SysClient implements Serializable {
	
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "client_id")
    private Long clientId;

    /**
     * 客户的名字
     */
	@Column(name = "client_name")
    private String clientName;

	
	@Column(name = "open_id")
    private Integer openId;

    /**
     * 用户联系电话
     */
	@Column(name = "client_phone")
    private String cilentPhone;

    private static final long serialVersionUID = 1L;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getOpenId() {
        return openId;
    }

    public void setOpenId(Integer openId) {
        this.openId = openId;
    }

    public String getCilentPhone() {
        return cilentPhone;
    }

    public void setCilentPhone(String cilentPhone) {
        this.cilentPhone = cilentPhone;
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
        SysClient other = (SysClient) that;
        return (this.getClientId() == null ? other.getClientId() == null : this.getClientId().equals(other.getClientId()))
            && (this.getClientName() == null ? other.getClientName() == null : this.getClientName().equals(other.getClientName()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getCilentPhone() == null ? other.getCilentPhone() == null : this.getCilentPhone().equals(other.getCilentPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClientId() == null) ? 0 : getClientId().hashCode());
        result = prime * result + ((getClientName() == null) ? 0 : getClientName().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getCilentPhone() == null) ? 0 : getCilentPhone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", clientId=").append(clientId);
        sb.append(", clientName=").append(clientName);
        sb.append(", openId=").append(openId);
        sb.append(", cilentPhone=").append(cilentPhone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}