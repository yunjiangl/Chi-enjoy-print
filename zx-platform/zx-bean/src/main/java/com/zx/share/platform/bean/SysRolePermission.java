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
@Table(name="sys_role_permission")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRolePermission implements Serializable {
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "id")
    private Long id;

    /**
     * 角色ID
     */
    @NotEmpty
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 权限id
     */
    @NotEmpty
    @Column(name = "permission_id")
    private Long permissionId;

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