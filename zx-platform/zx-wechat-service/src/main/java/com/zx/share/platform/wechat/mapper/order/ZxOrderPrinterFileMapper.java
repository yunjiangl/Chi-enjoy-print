package com.zx.share.platform.wechat.mapper.order;

import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxOrderPrinterFile;
import com.zx.share.platform.common.mapper.PlatFormMapper;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * @author fenggang
 */
@Repository
public interface ZxOrderPrinterFileMapper extends PlatFormMapper<ZxOrderPrinterFile> {

    List<ZxOrderPrinterFile> getOrderFile(String code);
    
}