package com.zx.share.platform.wechat.service;

import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.response.FileResultBean;

/**
 * Created by fenggang on 18/3/9.
 *
 * @author fenggang
 * @date 18/3/9
 */
public interface FileManagerService {

    PageResponseBean<FileResultBean> pageabList(String suffix,String categoryCode, int page, int pageSize);


    PageResponseBean<FileResultBean> pagecdeList(String suffix,String categoryCode, int page, int pageSize);

    FileResultBean details(String code);
}
