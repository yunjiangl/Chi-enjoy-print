package com.zx.share.platform.wechat.service;

import com.zx.share.platform.vo.wechat.response.DictionaryResultBean;

import java.util.List;

/**
 * Created by fenggang on 18/3/9.
 *
 * @author fenggang
 * @date 18/3/9
 */
public interface DictionaryService {

    /**
     * 根据类型父级id查询
     * @param type
     * @param parentId
     * @return
     */
    List<DictionaryResultBean> findType(String type,Long parentId);

    List<DictionaryResultBean> lista();

    List<DictionaryResultBean> listb();
}
