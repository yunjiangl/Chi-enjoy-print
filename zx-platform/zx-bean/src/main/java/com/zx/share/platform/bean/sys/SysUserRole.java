package com.zx.share.platform.bean.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.zx.share.platform.bean.IdEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author 
 */
@Entity
@Table(name="sys_user_role")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserRole extends IdEntity {

    /**
     * 用户ID
     */
    @NotEmpty
    @Column(name = "user_id")
    private Long userId;

    /**
     * 角色ID
     */
    @NotEmpty
    @Column(name = "role_id")
    private Long roleId;

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