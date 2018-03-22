package com.zx.share.platform.vo.wechat.request;

import com.zx.share.platform.common.bean.PageRequestBean;
import io.swagger.annotations.ApiModel;

/**
 * Created by fenggang on 18/3/22.
 *
 * @author fenggang
 * @date 18/3/22
 */
@ApiModel
public class FileQueryBean extends PageRequestBean {

    private String categoryCode;
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
}
