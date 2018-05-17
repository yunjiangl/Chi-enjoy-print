package com.zx.share.platform.wechat.mapper;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.common.mapper.PlatFormMapper;
import com.zx.share.platform.vo.wechat.request.PrinterQueryBean;
import com.zx.share.platform.vo.wechat.response.PrinterResultBean;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fenggang on 18/3/19.
 *
 * @author fenggang
 * @date 18/3/19
 */
@Repository
public interface PrinterMapper extends PlatFormMapper<ZxPrinterManager> {

    List<PrinterResultBean> all();

    List<PrinterResultBean> page(PrinterQueryBean bean);
    Integer pageCount(PrinterQueryBean bean);
    List<PrinterResultBean> pageTwo( List<String> bean);
    /**
     -     * 根据用户code 查询关联的打印机code
     -     *
     -     */
   List<String> findPCByUserCode(String userCode);

    List<PrinterResultBean> nearby(PrinterQueryBean bean);

//    List<PrinterResultBean> query(PrinterQueryBean bean);
//    Integer queryCount(PrinterQueryBean bean);
//
//    List<PrinterResultBean> my(PrinterQueryBean bean);
//    Integer myCount(PrinterQueryBean bean);

    List<String> attorneyPage(PrinterQueryBean bean);
    Integer attorneyPageCount(PrinterQueryBean bean);

    /**
     * 根据设备物主查询打印机设备
     * @param createId
     * @return
     */
    List<PrinterResultBean> findByName(Long createId);
    
    Integer updateByStatus(@Param("id") long id);
    
    Integer updateByStatus2(@Param("id") long id);
    
    ZxPrinterManager selectByPcode(@Param("Pcode") String Pcode);
    
    Integer insertByCode(@Param("userId") long userId,
    					@Param("pId") long pId,
    					@Param("Ucode") String Ucode,
    					@Param("Pcode") String Pcode);
}
