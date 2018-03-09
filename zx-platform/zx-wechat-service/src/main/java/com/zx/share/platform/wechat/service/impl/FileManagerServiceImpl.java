package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.response.FileResultBean;
import com.zx.share.platform.wechat.mapper.FileManagerMapper;
import com.zx.share.platform.wechat.service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fenggang on 18/3/9.
 *
 * @author fenggang
 * @date 18/3/9
 */
@Service
public class FileManagerServiceImpl implements FileManagerService {

    @Autowired
    private FileManagerMapper fileManagerMapper;

    @Override
    public PageResponseBean<FileResultBean> pageList(String suffix, String categoryCode, int page, int pageSize) {
        return null;
    }
}
