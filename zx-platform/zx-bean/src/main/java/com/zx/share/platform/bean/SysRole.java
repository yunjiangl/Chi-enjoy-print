package com.zx.share.platform.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author 
 */
@Table(name="sys_role")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRole implements Serializable {
    /**
     * 注解
     */
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "id")
    private Long id;

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