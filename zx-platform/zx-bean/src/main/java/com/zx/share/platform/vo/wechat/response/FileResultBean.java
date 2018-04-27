package com.zx.share.platform.vo.wechat.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by fenggang on 18/3/9.
 *
 * @author fenggang
 * @date 18/3/9
 */
@ApiModel
public class FileResultBean implements Serializable {

    private static final long serialVersionUID = -5964152037114320669L;

    @ApiModelProperty(value = "文件id")
    private Long id;
    @ApiModelProperty(value = "fileCode")
    private String fileCode;
    @ApiModelProperty(value = "文件名")
    private String fileName;
    @ApiModelProperty(value = "分类code")
    private String categoryCode;
    @ApiModelProperty(value = "地址")
    private String fileUrl;
    @ApiModelProperty(value = "页数")
    private Integer fileNum;
    @ApiModelProperty(value = "客户code")
    private String userCode;
    @ApiModelProperty(value = "管理员code")
    private String managerCode;
    @ApiModelProperty(value = "文件摘要")
    private String abstracts;

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getFileNum() {
        return fileNum;
    }

    public void setFileNum(Integer fileNum) {
        this.fileNum = fileNum;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    
    
}