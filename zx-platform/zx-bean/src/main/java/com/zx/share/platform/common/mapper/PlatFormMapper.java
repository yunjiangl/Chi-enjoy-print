package com.zx.share.platform.common.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by fenggang on 1/25/18.
 *
 * @author fenggang
 * @date 1/25/18
 */
public interface PlatFormMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
