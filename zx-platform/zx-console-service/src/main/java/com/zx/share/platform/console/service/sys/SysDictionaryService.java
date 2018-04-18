package com.zx.share.platform.console.service.sys;

import com.zx.share.platform.util.response.PageResponseBean;

import java.util.List;

/**
 * Created by fenggang on 18/4/4.
 *
 * @author fenggang
 * @date 18/4/4
 */
public interface SysDictionaryService {

    PageResponseBean<SysDictionary> selecPage(String type,Long parentId,String query, Integer page,Integer pageSize);

    List<SysDictionary> selectParamAll(String type,Long parentId,String query);

    SysDictionary findId(Long id);

    int save(SysDictionary sysDictionary);
}
