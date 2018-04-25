package com.zx.share.platform.vo.wechat.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fenggang on 18/3/20.
 *  律师
 * @author fenggang
 * @date 18/3/20
 */
@ApiModel
public class AttorneyDetailsBean implements Serializable {

    @ApiModelProperty(value = "领域集合")
    private List<String> domainList;

    @ApiModelProperty(value = "名称")
    private String workYear;

    @ApiModelProperty(value = "名称")
    private String workOrg;

    @ApiModelProperty(value = "名称")
    private String workNum;

    @ApiModelProperty(value = "名称")
    private String identityCardImg;

    @ApiModelProperty(value = "名称")
    private String attorneyCardImg;

    @ApiModelProperty(value = "名称")
    private String checkImg;

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
    }

    public String getWorkOrg() {
        return workOrg;
    }

    public void setWorkOrg(String workOrg) {
        this.workOrg = workOrg;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    public String getIdentityCardImg() {
        return identityCardImg;
    }

    public void setIdentityCardImg(String identityCardImg) {
        this.identityCardImg = identityCardImg;
    }

    public String getAttorneyCardImg() {
        return attorneyCardImg;
    }

    public void setAttorneyCardImg(String attorneyCardImg) {
        this.attorneyCardImg = attorneyCardImg;
    }

    public String getCheckImg() {
        return checkImg;
    }

    public void setCheckImg(String checkImg) {
        this.checkImg = checkImg;
    }

    public List<String> getDomainList() {
        return domainList;
    }

    public void setDomainList(List<String> domainList) {
        this.domainList = domainList;
    }
}
