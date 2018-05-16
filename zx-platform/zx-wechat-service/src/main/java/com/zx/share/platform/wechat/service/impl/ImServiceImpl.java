package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.bean.zx.UserChat;
import com.zx.share.platform.bean.zx.UserChatMsg;
import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.user.ImRequestBean;
import com.zx.share.platform.vo.user.ImResponseBean;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;
import com.zx.share.platform.wechat.mapper.ImMapper;
import com.zx.share.platform.wechat.service.ImService;
import com.zx.share.platform.wechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by fenggang on 18/5/10.
 *
 * @author fenggang
 * @date 18/5/10
 */
@Service
public class ImServiceImpl implements ImService {

    @Autowired
    private ImMapper imMapper;
    @Autowired
    private UserService userService;


    @Override
    public PageResponseBean<ImResponseBean> page(ImRequestBean bean) {
        Integer count = imMapper.pageCount(bean);
        List<ImResponseBean> list = imMapper.page(bean);
        PageResponseBean<ImResponseBean> responseBean = new PageResponseBean<>(bean,count);
        responseBean.setContent(list);
        return responseBean;
    }

    @Override
    public Integer add(String code, String userCode,String text) {

        UserDetailsBean attorney = userService.details(code);

        UserDetailsBean user = userService.details(userCode);
        UserChat userChat = new UserChat();
        userChat.setChatTime(new Date());
        userChat.setChatUserCode(attorney.getUserCode());
        userChat.setUserCode(user.getUserCode());
        userChat.setUserId(user.getId());
        userChat.setChatUserId(attorney.getId());
        UserChatMsg msg = new UserChatMsg();
        msg.setChatTime(new Date());
        msg.setChatUserCode(attorney.getUserCode());
        msg.setUserCode(user.getUserCode());
        msg.setUserId(user.getId());
        msg.setChatUserId(attorney.getId());
        msg.setMsg(text);
        try{
            imMapper.insert(userChat);
        }catch (Exception e){
            e.printStackTrace();
        }

        return imMapper.insertMsg(msg);
    }
}
