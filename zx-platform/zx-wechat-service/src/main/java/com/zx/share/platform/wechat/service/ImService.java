package com.zx.share.platform.wechat.service;

import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.user.ImRequestBean;
import com.zx.share.platform.vo.user.ImResponseBean;

/**
 * Created by fenggang on 18/5/10.
 *
 * @author fenggang
 * @date 18/5/10
 */
public interface ImService {

    PageResponseBean<ImResponseBean> page(ImRequestBean bean);

    Integer add(String code,String userCode);
}
