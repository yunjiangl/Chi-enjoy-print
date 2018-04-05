package com.zx.share.platform.console.service.sys.impl;

import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.common.bean.PageRequestBean;
import com.zx.share.platform.console.mapper.sys.SysDictionaryMapper;
import com.zx.share.platform.console.service.sys.SysDictionaryService;
import com.zx.share.platform.util.response.PageResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by fenggang on 18/4/4.
 *
 * @author fenggang
 * @date 18/4/4
 */
@Service
public class SysDictionaryServiceImpl implements SysDictionaryService {

    @Autowired
    private SysDictionaryMapper sysDictionaryMapper;

    @Override
    public PageResponseBean<SysDictionary> selecPage(String type,Long parentId,String query, Integer page,Integer pageSize) {
        Integer count = sysDictionaryMapper.selectPageCount(type,parentId,query);
        PageRequestBean pageBean = new PageRequestBean();
        pageBean.setPage(page);
        pageBean.setPageSize(pageSize);;
        List<SysDictionary> list = sysDictionaryMapper.selectPage(type,parentId,query,pageBean.getCurrentSize(),pageBean.getPageSize());
        PageResponseBean<SysDictionary> pageResponseBean = new PageResponseBean<>(pageBean,count);
        pageResponseBean.setContent(list);
        return pageResponseBean;
    }

    @Override
    public List<SysDictionary> selectParamAll(String type, Long parentId, String query) {
        return sysDictionaryMapper.selectParamAll(type,parentId,query);
    }
}
