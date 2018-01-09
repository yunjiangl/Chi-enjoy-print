package com.exqoo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class SysUser implements Serializable {
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 与微信相关的opeanId
     */
    private String opeanid;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 所在地
     */
    private String location;

    /**
     * 工作年限
     */
    private String workingLife;

    /**
     * 机构
     */
    private String org;

    /**
     * 擅长领域id
     */
    private Long areasOfExpertiseId;

    /**
     * 证书url
     */
    private String certificateUrl;

    /**
     * 用户的性别（0：男 1：女）
     */
    private Byte sex;

    /**
     * 用户的上次登陆ip
     */
    private String ip;

    /**
     * 备注
     */
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOpeanid() {
        return opeanid;
    }

    public void setOpeanid(String opeanid) {
        this.opeanid = opeanid;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

   

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Long getAreasOfExpertiseId() {
        return areasOfExpertiseId;
    }

    public void setAreasOfExpertiseId(Long areasOfExpertiseId) {
        this.areasOfExpertiseId = areasOfExpertiseId;
    }

    public String getCertificateUrl() {
        return certificateUrl;
    }

    public void setCertificateUrl(String certificateUrl) {
        this.certificateUrl = certificateUrl;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

	public String getWorkingLife() {
		return workingLife;
	}

	public void setWorkingLife(String workingLife) {
		this.workingLife = workingLife;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areasOfExpertiseId == null) ? 0 : areasOfExpertiseId.hashCode());
		result = prime * result + ((certificateUrl == null) ? 0 : certificateUrl.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((opeanid == null) ? 0 : opeanid.hashCode());
		result = prime * result + ((org == null) ? 0 : org.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((wechat == null) ? 0 : wechat.hashCode());
		result = prime * result + ((workingLife == null) ? 0 : workingLife.hashCode());
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
		SysUser other = (SysUser) obj;
		if (areasOfExpertiseId == null) {
			if (other.areasOfExpertiseId != null)
				return false;
		} else if (!areasOfExpertiseId.equals(other.areasOfExpertiseId))
			return false;
		if (certificateUrl == null) {
			if (other.certificateUrl != null)
				return false;
		} else if (!certificateUrl.equals(other.certificateUrl))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (opeanid == null) {
			if (other.opeanid != null)
				return false;
		} else if (!opeanid.equals(other.opeanid))
			return false;
		if (org == null) {
			if (other.org != null)
				return false;
		} else if (!org.equals(other.org))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (wechat == null) {
			if (other.wechat != null)
				return false;
		} else if (!wechat.equals(other.wechat))
			return false;
		if (workingLife == null) {
			if (other.workingLife != null)
				return false;
		} else if (!workingLife.equals(other.workingLife))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", mobile=" + mobile + ", status=" + status + ", createTime=" + createTime + ", opeanid=" + opeanid
				+ ", wechat=" + wechat + ", location=" + location + ", workingLife=" + workingLife + ", org=" + org
				+ ", areasOfExpertiseId=" + areasOfExpertiseId + ", certificateUrl=" + certificateUrl + ", sex=" + sex
				+ ", ip=" + ip + ", remarks=" + remarks + "]";
	}

   
   

   
}