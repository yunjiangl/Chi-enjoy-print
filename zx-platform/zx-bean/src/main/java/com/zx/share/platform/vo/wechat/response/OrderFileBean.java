package com.zx.share.platform.vo.wechat.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by fenggang on 18/5/9.
 *
 * @author fenggang
 * @date 18/5/9
 */
@ApiModel
public class OrderFileBean implements Serializable {

    @ApiModelProperty(value = "文件名称")
    private String fileName;
    @ApiModelProperty(value = "文件页数")
    private String filePaper;
    @ApiModelProperty(value = "打印数量")
    private String printerNum;
    @ApiModelProperty(value = "纸张类型")
    private String paperType;
    @ApiModelProperty(value = "颜色")
    private String paperColcor;
    @ApiModelProperty(value = "纸张使用")
    private String paperUsage;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePaper() {
        return filePaper;
    }

    public void setFilePaper(String filePaper) {
        this.filePaper = filePaper;
    }

    public String getPrinterNum() {
        return printerNum;
    }

    public void setPrinterNum(String printerNum) {
        this.printerNum = printerNum;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getPaperColcor() {
        return paperColcor;
    }

    public void setPaperColcor(String paperColcor) {
        this.paperColcor = paperColcor;
    }

    public String getPaperUsage() {
        return paperUsage;
    }

    public void setPaperUsage(String paperUsage) {
        this.paperUsage = paperUsage;
    }
}
