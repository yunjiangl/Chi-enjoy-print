package com.zx.share.platform.vo.wechat.response;

import io.swagger.annotations.ApiModel;

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

    private String fileCode;
    private String filePage;

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    public String getFilePage() {
        return filePage;
    }

    public void setFilePage(String filePage) {
        this.filePage = filePage;
    }
}
