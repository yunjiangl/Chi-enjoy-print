package com.zx.share.platform.console.api.modules.order.dao;

import com.zx.share.platform.bean.zx.ZxOrderPrinterFile;
import com.zx.share.platform.common.mapper.PlatFormMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by fenggang on 18/5/21.
 *
 * @author fenggang
 * @date 18/5/21
 */
@Repository
@Mapper
public interface ZxOrderPrinterFileMapper extends PlatFormMapper<ZxOrderPrinterFile> {
}
