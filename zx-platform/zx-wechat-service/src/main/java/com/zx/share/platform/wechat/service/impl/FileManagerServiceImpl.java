package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.request.FileQueryBean;
import com.zx.share.platform.vo.wechat.response.FileResultBean;
import com.zx.share.platform.wechat.mapper.FileManagerMapper;
import com.zx.share.platform.wechat.service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public PageResponseBean<FileResultBean> pageabList(String suffix, String categoryCode, int page, int pageSize,String query) {
        FileQueryBean queryBean = new FileQueryBean();
        queryBean.setPage(page);
        queryBean.setPageSize(pageSize);
        queryBean.setCategoryCode(categoryCode);
        queryBean.setQuery(query);
        queryBean.setSuffix(suffix);

        List<FileResultBean> resultBeans = fileManagerMapper.pageListab(queryBean);
        Integer count = fileManagerMapper.pageCountab(queryBean);

        PageResponseBean<FileResultBean> pageResponseBean = new PageResponseBean<>(queryBean,count);
        pageResponseBean.setContent(resultBeans);
        return pageResponseBean;
    }

    @Override
    public PageResponseBean<FileResultBean> pagecdeList(String suffix, String categoryCode, int page, int pageSize,String query) {
        FileQueryBean queryBean = new FileQueryBean();
        queryBean.setPage(page);
        queryBean.setPageSize(pageSize);
        queryBean.setCategoryCode(categoryCode);
        queryBean.setQuery(query);
        queryBean.setSuffix(suffix);

        List<FileResultBean> resultBeans = fileManagerMapper.pageListcde(queryBean);
        Integer count = fileManagerMapper.pageCountcde(queryBean);

        PageResponseBean<FileResultBean> pageResponseBean = new PageResponseBean<>(queryBean,count);
        pageResponseBean.setContent(resultBeans);
        return pageResponseBean;
    }

    @Override
    public FileResultBean details(String code) {
        FileResultBean resultBean = null;
        String suffix = code.substring(2,3);
        if("a".equals(suffix.toLowerCase()) || "b".equals(suffix.toLowerCase())){
            resultBean = fileManagerMapper.detailsab(code);
        }else{
            resultBean = fileManagerMapper.detailscde(code);
        }
        return resultBean;
    }
}
