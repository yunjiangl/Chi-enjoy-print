package com.zx.share.platform.vo.wechat.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

/**
 * Created by fenggang on 18/3/19.
 *
 * @author fenggang
 * @date 18/3/19
 */
@ApiModel
public class OrderSaveBean implements Serializable {
    private static final long serialVersionUID = -8800221558232404995L;

    private String orderCode;
    private String customerCode;
    private String printerCode;
    private String attorneyCode;
    private String fileCodes;
    private Long paperType;
    private Integer printerNum;
    private Long paperColcor;
    private Long paperUsage;
    private Double serviceAmout;
    private Long fileType; // 文件的类型，4为ab类文件，5为cde类文件 

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getPrinterCode() {
        return printerCode;
    }

    public void setPrinterCode(String printerCode) {
        this.printerCode = printerCode;
    }

    public String getAttorneyCode() {
        return attorneyCode;
    }

    public void setAttorneyCode(String attorneyCode) {
        this.attorneyCode = attorneyCode;
    }

    public String getFileCodes() {
        return fileCodes;
    }

    public void setFileCodes(String fileCodes) {
        this.fileCodes = fileCodes;
    }

    public Long getPaperType() {
        return paperType;
    }

    public void setPaperType(Long paperType) {
        this.paperType = paperType;
    }

    public Integer getPrinterNum() {
        return printerNum;
    }

    public void setPrinterNum(Integer printerNum) {
        this.printerNum = printerNum;
    }

    public Long getPaperColcor() {
        return paperColcor;
    }

    public void setPaperColcor(Long paperColcor) {
        this.paperColcor = paperColcor;
    }

    public Long getPaperUsage() {
        return paperUsage;
    }

    public void setPaperUsage(Long paperUsage) {
        this.paperUsage = paperUsage;
    }

    public Double getServiceAmout() {
        return serviceAmout;
    }

    public void setServiceAmout(Double serviceAmout) {
        this.serviceAmout = serviceAmout;
    }

	public Long getFileType() {
		return fileType;
	}

	public void setFileType(Long fileType) {
		this.fileType = fileType;
	}
    
    
}
