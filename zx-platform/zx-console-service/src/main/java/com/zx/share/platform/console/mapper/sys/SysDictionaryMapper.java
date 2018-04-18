package com.zx.share.platform.console.mapper.sys;

import com.zx.share.platform.common.mapper.PlatFormMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fenggang on 18/4/4.
 *
 * @author fenggang
 * @date 18/4/4
 */
@Repository
public interface SysDictionaryMapper extends PlatFormMapper<SysDictionary> {

    List<SysDictionary> selectPage(@Param("type") String type,
                                   @Param("parentId") Long parentId,
                                   @Param("query") String query,
                                   @Param("limit") Integer limit,
                                   @Param("pageSize") Integer pageSize);
    Integer selectPageCount(@Param("type") String type,
                            @Param("parentId") Long parentId,
                            @Param("query") String query);

    List<SysDictionary> selectParamAll(@Param("type") String type,
                                   @Param("parentId") Long parentId,
                                   @Param("query") String query);
}
