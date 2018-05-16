package com.zx.share.platform.wechat.mapper;


import com.zx.share.platform.bean.zx.UserChat;
import com.zx.share.platform.bean.zx.UserChatMsg;
import com.zx.share.platform.common.mapper.PlatFormMapper;
import com.zx.share.platform.vo.user.ImRequestBean;
import com.zx.share.platform.vo.user.ImResponseBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fenggang on 18/5/10.
 *
 * @author fenggang
 * @date 18/5/10
 */
@Repository
public interface ImMapper extends PlatFormMapper<UserChat> {

    List<ImResponseBean> page(ImRequestBean bean);
    Integer pageCount(ImRequestBean bean);

    Integer insertMsg(UserChatMsg bean);
}
