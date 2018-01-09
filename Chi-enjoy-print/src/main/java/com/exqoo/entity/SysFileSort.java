package com.exqoo.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class SysFileSort implements Serializable {
    private Long id;

    /**
     * 上级类别的id，一级类别为0
     */
    private Long parentId;

    /**
     * 文件类别的名字
     */
    private String sortName;

    /**
     * 文件分类的级别（有1 2 3 三个级别）
     */
    private Integer sortLevel;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public Integer getSortLevel() {
        return sortLevel;
    }

    public void setSortLevel(Integer sortLevel) {
        this.sortLevel = sortLevel;
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
        SysFileSort other = (SysFileSort) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getSortName() == null ? other.getSortName() == null : this.getSortName().equals(other.getSortName()))
            && (this.getSortLevel() == null ? other.getSortLevel() == null : this.getSortLevel().equals(other.getSortLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getSortName() == null) ? 0 : getSortName().hashCode());
        result = prime * result + ((getSortLevel() == null) ? 0 : getSortLevel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", sortName=").append(sortName);
        sb.append(", sortLevel=").append(sortLevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}