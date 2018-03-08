package com.zx.share.platform.wechat.mapper;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.common.mapper.PlatFormMapper;
import com.zx.share.platform.vo.user.UserRequestBean;
import com.zx.share.platform.vo.user.UserResultBean;
import org.springframework.stereotype.Repository;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
@Repository
public interface UserMapper extends PlatFormMapper<ZxPrinterManager> {

    UserResultBean findByUnionId(String unionId);

    Integer save(UserRequestBean bean);

    Integer update(UserRequestBean bean);

}
