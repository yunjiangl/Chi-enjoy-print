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

    public List<String> getDomainList() {
        return domainList;
    }

    public void setDomainList(List<String> domainList) {
        this.domainList = domainList;
    }
}
