package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.vo.wechat.response.DictionaryResultBean;
import com.zx.share.platform.wechat.mapper.DictionaryMapper;
import com.zx.share.platform.wechat.service.DictionaryService;
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
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public List<DictionaryResultBean> findType(String type, Long parentId) {
        return dictionaryMapper.findTypeList(type,parentId);
    }
}