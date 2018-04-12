package com.zx.share.platform.console.service.sys.impl;

import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.common.bean.PageRequestBean;
import com.zx.share.platform.console.mapper.sys.SysDictionaryMapper;
import com.zx.share.platform.console.service.sys.SysDictionaryService;
import com.zx.share.platform.util.StringUtil;
import com.zx.share.platform.util.response.PageResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public PageResponseBean<SysDictionary> selecPage(String type, Long parentId, String query, Integer page, Integer pageSize) {
        PageRequestBean pageBean = new PageRequestBean();
        pageBean.setPage(page);
        pageBean.setPageSize(pageSize);
        if (StringUtil.isNotBlank(type)) {
            type = type + "%";
        }
        Integer count = sysDictionaryMapper.selectPageCount(type, parentId, query);
        List<SysDictionary> list = sysDictionaryMapper.selectPage(type, parentId, query, pageBean.getCurrentSize(), pageBean.getPageSize());
        PageResponseBean<SysDictionary> pageResponseBean = new PageResponseBean<>(pageBean, count);
        pageResponseBean.setContent(list);
        return pageResponseBean;
    }

    @Override
    public List<SysDictionary> selectParamAll(String type, Long parentId, String query) {
        if (StringUtil.isNotBlank(type)) {
            type = type + "%";
        }
        return sysDictionaryMapper.selectParamAll(type, parentId, query);
    }

    @Override
    public SysDictionary findId(Long id) {
        SysDictionary sysDictionary = sysDictionaryMapper.selectByPrimaryKey(id);
        return this.recursive(sysDictionary);
    }

    @Override
    public int save(SysDictionary sysDictionary) {
        if (StringUtil.isNotBlank(sysDictionary.getId())) {
            sysDictionaryMapper.updateByPrimaryKeySelective(sysDictionary);
        }
        return sysDictionaryMapper.insertUseGeneratedKeys(sysDictionary);
    }

    private SysDictionary recursive(SysDictionary sysDictionary) {
        List<SysDictionary> list = sysDictionaryMapper.selectParamAll(sysDictionary.getType(),null,null);
        Set<Long> ids = new HashSet<>();
        ids = this._getLongs(ids,sysDictionary);
        sysDictionary.setDictionaryList(this.getSysDictionaryeBean(list,0l,ids));
        return sysDictionary;
    }

    private Set<Long> _getLongs(Set<Long> set,SysDictionary sysDictionary){
        set.add(sysDictionary.getId());
        if(sysDictionary.getParentId()==0){
            return set;
        }
        set.add(sysDictionary.getParentId());
        SysDictionary bean = sysDictionaryMapper.selectByPrimaryKey(sysDictionary.getParentId());
        return this._getLongs(set,bean);
    }

    private List<SysDictionary> getSysDictionaryeBean(List<SysDictionary> list,Long pId,Set<Long> ids){
        List<SysDictionary> result = new ArrayList<>();
        if(list!=null && !list.isEmpty()){
            for (SysDictionary beanSys : list) {
                if(beanSys.getParentId().equals(pId) || pId.equals(beanSys.getParentId())){
                    if(ids.contains(beanSys.getId())){
                        beanSys.setSelected("selected");
                    }
                    beanSys.setDictionaryList(getSysDictionaryeBean(list, beanSys.getId(),ids));
                    result.add(beanSys);
                }
            }
        }
        return result;
    }
}
