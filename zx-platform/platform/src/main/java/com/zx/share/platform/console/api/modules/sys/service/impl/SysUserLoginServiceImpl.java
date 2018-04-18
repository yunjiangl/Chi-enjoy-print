package com.zx.share.platform.console.api.modules.sys.service.impl;

import com.zx.share.platform.bean.sys.SysUserLogin;
import com.zx.share.platform.console.api.modules.sys.service.SysUserLoginService;
import com.zx.share.platform.console.api.modules.user.dao.SysUserLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fenggang on 18/4/18.
 *
 * @author fenggang
 * @date 18/4/18
 */
@Service
public class SysUserLoginServiceImpl implements SysUserLoginService {

    @Autowired
    private SysUserLoginDao sysUserLoginDao;

    @Override
    public void update(SysUserLogin userLogin) {
        SysUserLogin sysUserLogin = sysUserLoginDao.queryObject(userLogin.getUserId());
        if(sysUserLogin==null){
            sysUserLoginDao.save(userLogin);
        }else{
            userLogin.setId(sysUserLogin.getId());
            sysUserLoginDao.update(userLogin);
        }
    }
}
