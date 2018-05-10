package com.zx.share.platform.bean.zx;

import com.zx.share.platform.bean.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by fenggang on 18/5/10.
 *
 * @author fenggang
 * @date 18/5/10
 */
@Entity
@Table(name = "t_user_chat")
@Data
@EqualsAndHashCode(callSuper = false)
public class UserChat extends IdEntity {

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_code")
    private String userCode;
    @Column(name = "chat_user_id")
    private Long chatUserId;
    @Column(name = "chat_user_code")
    private String chatUserCode;
    @Column(name = "chat_time")
    private Date chatTime;

}
