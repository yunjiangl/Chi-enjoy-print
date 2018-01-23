package com.zx.share.platform.zxbean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 
 */
@Table(name = "sys_income")
public class SysIncome implements Serializable {
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "id")
    private Long id;

    /**
     * A类文件收益百分比
     */
	@Column(name = "a_income")
    private Double aIncome;

    /**
     * B类文件收益百分比
     */
	@Column(name = "b_income")
    private Double bIncome;

    /**
     * C类文件收益百分比
     */
	@Column(name = "c_income")
    private Double cIncome;

    /**
     * D类文件收益百分比
     */
	@Column(name = "d_income")
    private Double dIncome;

    /**
     * E类文件收益
     */
	@Column(name = "e_income")
    private Double eIncome;

    /**
     * 黑白页收费
     */
	@Column(name = "black")
    private BigDecimal black;

    /**
     * 彩色也收费
     */
	@Column(name = "color")
    private BigDecimal color;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getaIncome() {
        return aIncome;
    }

    public void setaIncome(Double aIncome) {
        this.aIncome = aIncome;
    }

    public Double getbIncome() {
        return bIncome;
    }

    public void setbIncome(Double bIncome) {
        this.bIncome = bIncome;
    }

    public Double getcIncome() {
        return cIncome;
    }

    public void setcIncome(Double cIncome) {
        this.cIncome = cIncome;
    }

    public Double getdIncome() {
        return dIncome;
    }

    public void setdIncome(Double dIncome) {
        this.dIncome = dIncome;
    }

    public Double geteIncome() {
        return eIncome;
    }

    public void seteIncome(Double eIncome) {
        this.eIncome = eIncome;
    }

    public BigDecimal getBlack() {
        return black;
    }

    public void setBlack(BigDecimal black) {
        this.black = black;
    }

    public BigDecimal getColor() {
        return color;
    }

    public void setColor(BigDecimal color) {
        this.color = color;
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
        SysIncome other = (SysIncome) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getaIncome() == null ? other.getaIncome() == null : this.getaIncome().equals(other.getaIncome()))
            && (this.getbIncome() == null ? other.getbIncome() == null : this.getbIncome().equals(other.getbIncome()))
            && (this.getcIncome() == null ? other.getcIncome() == null : this.getcIncome().equals(other.getcIncome()))
            && (this.getdIncome() == null ? other.getdIncome() == null : this.getdIncome().equals(other.getdIncome()))
            && (this.geteIncome() == null ? other.geteIncome() == null : this.geteIncome().equals(other.geteIncome()))
            && (this.getBlack() == null ? other.getBlack() == null : this.getBlack().equals(other.getBlack()))
            && (this.getColor() == null ? other.getColor() == null : this.getColor().equals(other.getColor()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getaIncome() == null) ? 0 : getaIncome().hashCode());
        result = prime * result + ((getbIncome() == null) ? 0 : getbIncome().hashCode());
        result = prime * result + ((getcIncome() == null) ? 0 : getcIncome().hashCode());
        result = prime * result + ((getdIncome() == null) ? 0 : getdIncome().hashCode());
        result = prime * result + ((geteIncome() == null) ? 0 : geteIncome().hashCode());
        result = prime * result + ((getBlack() == null) ? 0 : getBlack().hashCode());
        result = prime * result + ((getColor() == null) ? 0 : getColor().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", aIncome=").append(aIncome);
        sb.append(", bIncome=").append(bIncome);
        sb.append(", cIncome=").append(cIncome);
        sb.append(", dIncome=").append(dIncome);
        sb.append(", eIncome=").append(eIncome);
        sb.append(", black=").append(black);
        sb.append(", color=").append(color);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}