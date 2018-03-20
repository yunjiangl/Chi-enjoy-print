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
@Table(name="zx_order")
@Data
@EqualsAndHashCode(callSuper = false)
public class ZxOrder extends IdEntity {

    /**
     * 订单code
     */
    @Column(name = "order_code")
    private String orderCode;
    
    @Column(name = "file_url")
    private String fileUrl;

    /**
     * 订单状态
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 订单编号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 支付id
     */
    @Column(name = "pay_id")
    private Long payId;

    /**
     * 支付code
     */
    @Column(name = "pay_code")
    private String payCode;
    
    @Column(name = "create_time")
    private Date createTime;
    
    @Column(name = "create_id")
    private Long createId;
    
    @Column(name = "update_time")
    private Date updateTime;
    
    @Column(name = "update_id")
    private Long updateId;

    /**
     * 打印机id
     */
    @Column(name = "printer_id")
    private Long printerId;

    /**
     * 打印机code
     */
    @Column(name = "printer_code")
    private String printerCode;

    /**
     * 订单人code
     */
    @Column(name = "order_user_code")
    private String orderUserCode;
    
    @Column(name = "order_user_id")
    private Long orderUserId;

    @Column(name = "order_amount")
    private Double amount;

    @Column(name = "remark")
    private String remark;

    private static final long serialVersionUID = 1L;
}