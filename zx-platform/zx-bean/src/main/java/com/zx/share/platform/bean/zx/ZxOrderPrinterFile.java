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
@Table(name="zx_order_printer_file")
@Data
@EqualsAndHashCode(callSuper = false)
public class ZxOrderPrinterFile extends IdEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 订单code
     */
    @Column(name = "order_code")
    private String orderCode;

    /**
     * 文件id
     */
    @Column(name = "file_id")
    private Long fileId;

    /**
     * 文件code
     */
    @Column(name = "file_code")
    private String fileCode;

    /**
     * 文件类型
     */
    @Column(name = "file_type")
    private String fileType;
    
    @Column(name = "create_time")
    private Date createTime;
    
    @Column(name = "create_id")
    private Long createId;

    private static final long serialVersionUID = 1L;
}