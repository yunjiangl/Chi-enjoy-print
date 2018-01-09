package com.exqoo.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class SysAreasOfExpertise implements Serializable {
    private Long areasOfExpertiseId;

    /**
     * 擅长领域名字
     */
    private String areasOfExpertiseName;

    private static final long serialVersionUID = 1L;

    public Long getAreasOfExpertiseId() {
        return areasOfExpertiseId;
    }

    public void setAreasOfExpertiseId(Long areasOfExpertiseId) {
        this.areasOfExpertiseId = areasOfExpertiseId;
    }

    public String getAreasOfExpertiseName() {
        return areasOfExpertiseName;
    }

    public void setAreasOfExpertiseName(String areasOfExpertiseName) {
        this.areasOfExpertiseName = areasOfExpertiseName;
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
        SysAreasOfExpertise other = (SysAreasOfExpertise) that;
        return (this.getAreasOfExpertiseId() == null ? other.getAreasOfExpertiseId() == null : this.getAreasOfExpertiseId().equals(other.getAreasOfExpertiseId()))
            && (this.getAreasOfExpertiseName() == null ? other.getAreasOfExpertiseName() == null : this.getAreasOfExpertiseName().equals(other.getAreasOfExpertiseName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAreasOfExpertiseId() == null) ? 0 : getAreasOfExpertiseId().hashCode());
        result = prime * result + ((getAreasOfExpertiseName() == null) ? 0 : getAreasOfExpertiseName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", areasOfExpertiseId=").append(areasOfExpertiseId);
        sb.append(", areasOfExpertiseName=").append(areasOfExpertiseName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}