package com.zx.share.platform.console.api.modules.apply.dao;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.bean.zx.ZxUserPrinterApply;
import com.zx.share.platform.console.api.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by fenggang on 18/4/26.
 *
 * @author fenggang
 * @date 18/4/26
 */
@Mapper
public interface ApplyDao extends BaseDao<ZxUserPrinterApply> {
}
