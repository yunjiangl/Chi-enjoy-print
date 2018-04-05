package com.zx.share.platform.bean.zx;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.zx.share.platform.bean.IdEntity;
import com.zx.share.platform.bean.sys.SysDictionary;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="zx_file_manager_ab")
@Data
@EqualsAndHashCode(callSuper = false)
public class ZxFileManagerAB extends IdEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "file_code")
	private String fileCode;
	
	/**
	 * 文件名
	 */
	@Column(name = "file_name")
	private String fileName;
	
	/**
	 * 文件分类Id
	 */
	@Column(name = "category_id")
	private Long categoryId;
	
	/**
	 * 文件地址
	 */
	@Column(name = "file_url")
	private String fileUrl;
	
	/**
	 * 文件y页数
	 */
	@Column(name = "file_num")
	private int fileNum;
	
	/**
	 * 摘要
	 */
	@Column(name = "abstracts")
	private String abstracts;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "create_id")
	private int createId;
	
	@Column(name = "update_time")
	private Date updateTime;
	
	@Column(name = "update_id")
	private int updateId;
	
	@Transient
	private SysDictionary sysDictionary;
}
