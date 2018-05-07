package com.zx.share.platform.wechat.mapper;

import com.zx.share.platform.vo.wechat.request.UserAttorneyDomain;
import com.zx.share.platform.vo.wechat.request.UserUpdateBean;
import com.zx.share.platform.vo.wechat.response.AttorneyDetailsBean;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.common.mapper.PlatFormMapper;
import com.zx.share.platform.vo.user.UserRequestBean;
import com.zx.share.platform.vo.user.UserResultBean;

import java.util.List;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
@Repository
public interface UserMapper extends PlatFormMapper<ZxUser> {

    UserResultBean findByUnionId(String unionId);

    UserResultBean findByOpenId(String openId);

    Integer save(UserRequestBean bean);

    Integer update(UserUpdateBean bean);

    Integer deleteAttorney(@Param("code") String code);

    Integer deleteAttorneyDomain(@Param("code") String code);

    Integer saveAttorney(UserUpdateBean bean);

    Integer saveAttorneyDomain(List<UserAttorneyDomain> list);
    Integer updateAttorneyDomain(@Param("code") String code);

    UserDetailsBean findByCode(@Param("code") String code);

    UserDetailsBean findByMobile(@Param("mobile") String mobile);

    AttorneyDetailsBean findByAttorney(@Param("code") String code);

    List<String> findByAttorneyDomains(@Param("code") String code);

    Long findMaxId(@Param("code") String code);

}
