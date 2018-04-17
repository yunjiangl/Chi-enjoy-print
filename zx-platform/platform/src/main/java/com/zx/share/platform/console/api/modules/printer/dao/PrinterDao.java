package com.zx.share.platform.console.api.modules.printer.dao;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.console.api.modules.sys.dao.BaseDao;
import com.zx.share.platform.console.api.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by fenggang on 18/4/17.
 *
 * @author fenggang
 * @date 18/4/17
 */
@Mapper
public interface PrinterDao extends BaseDao<ZxPrinterManager> {
}
