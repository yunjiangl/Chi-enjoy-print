package com.zx.share.platform.bean.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zx.share.platform.bean.IdEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author 
 */
@Entity
@Table(name="sys_role")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRole extends IdEntity {

    /**
     * 角色名称
     */
	@Column(name = "name")
    private String name;

    /**
     * 备注
     */
	@Column(name = "remark")
    private String remark;

    /**
     * 角色标识
     */
	@Column(name = "perms")
    private String perms;

    /**
     * 创建时间
     */
	@Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
	@Column(name = "modify_time")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

  
}