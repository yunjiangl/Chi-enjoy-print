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
@Table(name="sys_dictionary")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysDictionary extends IdEntity {

    /**
     * 类型
     */
	@Column(name = "type")
    private String type;

    /**
     * 编码
     */
	@Column(name = "code")
    private String code;

    /**
     * 名称
     */
	@Column(name = "name")
    private String name;

    /**
     * 值
     */
	@Column(name = "value")
    private String value;

    /**
     * 父级
     */
	@Column(name = "parent_id")
    private Long parentId;

    /**
     * 排序
     */
	@Column(name = "sort")
    private Integer sort;

    /**
     * 备注
     */
	@Column(name = "remark")
    private String remark;

    /**
     * 状态（1-使用，2-不使用）
     */
	@Column(name = "status")
    private Integer status;

    /**
     * 创建时间
     */
	@Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
	@Column(name = "create_id")
    private Long createId;

    /**
     * 修改时间
     */
	@Column(name = "update_time")
    private Date updateTime;

    /**
     * 修改人
     */
	@Column(name = "update_id")
    private Integer updateId;

    private static final long serialVersionUID = 1L;

   
}