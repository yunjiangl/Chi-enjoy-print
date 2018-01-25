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
@Table(name="sys_permission")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysPermission extends IdEntity {


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
	@Column(name = "parent_id")
    private Long parentId;

    /**
     * 父节点名称
     */
	@Column(name = "parent_name")
    private String parentName;

    /**
     * 父节点id列表串，用/分割
     */
	@Column(name = "parent_ids")
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
	@Column(name = "is_lock")
    private Boolean isLock;

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