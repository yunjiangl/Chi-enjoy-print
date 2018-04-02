package com.zx.share.platform.vo.wechat.request;

import com.zx.share.platform.common.bean.PageRequestBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by fenggang on 18/3/22.
 *
 * @author fenggang
 * @date 18/3/22
 */
@ApiModel
public class FileQueryBean extends PageRequestBean {


    @ApiModelProperty(value = "类型code")
    private String categoryCode;
    @ApiModelProperty(value = "查询类容")
    private String query;
    @ApiModelProperty(value = "后缀")
    private String suffix;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
