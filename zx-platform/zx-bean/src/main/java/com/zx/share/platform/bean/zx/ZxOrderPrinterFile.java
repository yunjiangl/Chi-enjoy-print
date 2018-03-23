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

    /**
     * 页数
     */
    @Column(name = "file_paper")
    private Integer filePaper;

    /**
     * 打印数量
     */
    @Column(name = "printer_num")
    private Integer printerNum;

    /**
     * 纸张类型
     */
    @Column(name = "paper_type")
    private Long paperType;

    /**
     * 纸张颜色
     */
    @Column(name = "paper_colcor")
    private Long paperColcor;

    /**
     * 纸张使用
     */
    @Column(name = "paper_usage")
    private Long paperUsage;

    private static final long serialVersionUID = 1L;
}