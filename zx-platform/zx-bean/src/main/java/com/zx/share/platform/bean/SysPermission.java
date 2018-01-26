package com.zx.share.platform.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author 
 */
@Table(name="sys_permission")
public class SysPermission implements Serializable {
    /**
     * 主键
     */
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "id")
    private Long id;

    /**
     * 资源名称
     */
	@Column(name = "name")
    private String name;

    /**
     * 资源类型：0,1,2(目录,菜单or按钮)
     */
	@Column(name = "type")
    private String type;

    /**
     * 访问url地址
     */
	@Column(name = "url")
    private String url;

    /**
     * 权限代码字符串
     */
	@Column(name = "perms")
    private String perms;

    /**
     * 父节点id
     */
	@Column(name = "parentId")
    private Long parentId;

    /**
     * 父节点名称
     */
	@Column(name = "parentName")
    private String parentName;

    /**
     * 父节点id列表串，用/分割
     */
	@Column(name = "parentIds")
    private String parentIds;

    /**
     * 图标
     */
	@Column(name = "icon")
    private String icon;

    /**
     * 排序号
     */
	@Column(name = "sort")
    private Long sort;

    /**
     * 账号是否锁定，1：锁定，0未锁定
     */
	@Column(name = "isLock")
    private Boolean isLock;

    /**
     * 创建时间
     */
	@Column(name = "createTime")
    private Date createTime;

    /**
     * 更新时间
     */
	@Column(name = "modifyTime")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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
        SysPermission other = (SysPermission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getPerms() == null ? other.getPerms() == null : this.getPerms().equals(other.getPerms()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getParentName() == null ? other.getParentName() == null : this.getParentName().equals(other.getParentName()))
            && (this.getParentIds() == null ? other.getParentIds() == null : this.getParentIds().equals(other.getParentIds()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getIsLock() == null ? other.getIsLock() == null : this.getIsLock().equals(other.getIsLock()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getPerms() == null) ? 0 : getPerms().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getParentName() == null) ? 0 : getParentName().hashCode());
        result = prime * result + ((getParentIds() == null) ? 0 : getParentIds().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getIsLock() == null) ? 0 : getIsLock().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", url=").append(url);
        sb.append(", perms=").append(perms);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentName=").append(parentName);
        sb.append(", parentIds=").append(parentIds);
        sb.append(", icon=").append(icon);
        sb.append(", sort=").append(sort);
        sb.append(", isLock=").append(isLock);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}