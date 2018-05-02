package com.zx.share.platform.wechat.mapper;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.common.mapper.PlatFormMapper;
import com.zx.share.platform.vo.wechat.request.FileQueryBean;
import com.zx.share.platform.vo.wechat.response.FileResultBean;

import java.util.List;

/**
 * Created by fenggang on 18/3/9.
 *
 * @author fenggang
 * @date 18/3/9
 */
public interface FileManagerMapper extends PlatFormMapper<ZxFileManagerAB> {

    List<FileResultBean> pageListab(FileQueryBean queryBean);
    Integer pageCountab(FileQueryBean queryBean);

    List<FileResultBean> pageListcde(FileQueryBean queryBean);
    Integer pageCountcde(FileQueryBean queryBean);

    FileResultBean detailsab(String code);
    FileResultBean detailscde(String code);
    
    int deleteFile(Long[] ids);
}
