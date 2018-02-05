package com.zx.share.platform.bean.zx;

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
@Table(name="zx_user")
@Data
@EqualsAndHashCode(callSuper = false)
public class ZxUser extends IdEntity {
    

    
	private static final long serialVersionUID = 7554327871995326455L;

	@Column(name = "user_code")
	private String userCode;

	@Column(name = "mobile")
    private String mobile;

	@Column(name = "username")
    private String username;

	@Column(name = "password")
    private String password;

	@Column(name = "nickname")
    private String nickname;

    /**
     * 头像
     */
	@Column(name = "portrait")
    private String portrait;

	@Column(name = "register_time")
    private Date registerTime;

	@Column(name = "create_time")
    private Date createTime;

	@Column(name = "update_time")
    private Date updateTime;

    /**
     * 微信返回的openId
     */
	@Column(name = "open_id")
    private String openId;

    /**
     * 微信返回的unionId，这个需绑定开发平台
     */
	@Column(name = "union_id")
    private String unionId;

    /**
     * 用户类型（1-普通用户，2-律师）
     */
	@Column(name = "user_type")
    private Integer userType;

   
}