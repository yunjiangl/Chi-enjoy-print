package com.zx.share.platform.bean.zx;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zx.share.platform.bean.IdEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 
 */
@Entity
@Table(name="zx_order_pay")
@Data
@EqualsAndHashCode(callSuper = false)
public class ZxOrderPay extends IdEntity {
    
    @Column(name = "pay_code")
    private String payCode;
    
    @Column(name = "pay_status")
    private Integer payStatus;
    
    @Column(name = "order_id")
    private Long orderId;
    
    @Column(name = "order_code")
    private String orderCode;
    
    @Column(name = "pay_time")
    private Date payTime;
    
    @Column(name = "create_time")
    private Date createTime;
    
    @Column(name = "create_id")
    private Long createId;
    
    @Column(name = "update_time")
    private Date updateTime;
    
    @Column(name = "update_id")
    private Long updateId;

    private static final long serialVersionUID = 1L;
}