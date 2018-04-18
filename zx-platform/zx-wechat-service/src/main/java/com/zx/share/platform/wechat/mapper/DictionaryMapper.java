package com.zx.share.platform.wechat.mapper;

import com.zx.share.platform.common.mapper.PlatFormMapper;
import com.zx.share.platform.vo.wechat.response.DictionaryResultBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fenggang on 18/3/9.
 *
 * @author fenggang
 * @date 18/3/9
 */
@Repository
public interface DictionaryMapper extends PlatFormMapper<SysDictionary> {

    /**
     *
     * @param type
     * @param parentId
     * @return
     */
    List<DictionaryResultBean> findTypePIdList(@Param("type") String type, @Param("parentId") Long parentId);


    List<DictionaryResultBean> findTypeList(@Param("type") String type);
}
