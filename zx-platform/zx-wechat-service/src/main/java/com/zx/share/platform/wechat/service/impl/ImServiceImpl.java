package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.user.ImRequestBean;
import com.zx.share.platform.vo.user.ImResponseBean;
import com.zx.share.platform.wechat.mapper.ImMapper;
import com.zx.share.platform.wechat.service.ImService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fenggang on 18/5/10.
 *
 * @author fenggang
 * @date 18/5/10
 */
@Service
public class ImServiceImpl implements ImService {

    @Autowired
    private ImMapper imMapper;

    @Override
    public PageResponseBean<ImResponseBean> page(ImRequestBean bean) {
        Integer count = imMapper.pageCount(bean);
        List<ImResponseBean> list = imMapper.page(bean);
        PageResponseBean<ImResponseBean> responseBean = new PageResponseBean<>(bean,count);
        responseBean.setContent(list);
        return responseBean;
    }
}
