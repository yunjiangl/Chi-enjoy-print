package com.zx.share.platform.bean.sys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.zx.share.platform.bean.IdEntity;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author 
 */
@Entity
@Table(name="sys_user")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser extends IdEntity {


    /**
     * 账号
     */
	@Column(name = "username")
    private String username;

    /**
     * 密码
     */
	@Column(name = "password")
    private String password;

    /**
     * 盐
     */
	@Column(name = "salt")
    private String salt;

    /**
     * 真实姓名
     */
	@Column(name = "real_name")
    private String realName;

    /**
     * 性别  1 男  0 女
     */
	@Column(name = "sex")
    private Boolean sex;

    /**
     * 手机号
     */
	@Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 邮箱
     */
	@Column(name = "email")
    private String email;

    /**
     * 账号是否锁定，1：锁定，0未锁定
     */
	@Column(name = "is_lock")
    private Boolean isLock;

    /**
     * 账号是否删除，1：删除，0未删除
     */
	@Column(name = "is_del")
    private Boolean isDel;

    /**
     * 是否是超级管理员
     */
	@Column(name = "is_admin")
    private Boolean isAdmin;

    /**
     * 最近一次登录时间
     */
	@Column(name = "login_time")
    private Date loginTime;

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