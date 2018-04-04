package com.zx.share.platform.bean.zx;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.zx.share.platform.bean.IdEntity;
import com.zx.share.platform.bean.sys.SysUser;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author
 */
@Entity
@Table(name = "zx_order")
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
	private Double orderAmount;

	/**
	 * 律师id
	 */
	@Column(name = "attorney_id")
	private Long attorneyId;

	/**
	 * 律师code
	 */
	@Column(name = "attorney_code")
	private String attorneyCode;

	/**
	 * 支付类型（微信=wechat）
	 */
	@Column(name = "pay_type")
	private String payType;

	/**
	 * 服务费
	 */
	@Column(name = "service_amount")
	private Double serviceAmount;

	@Column(name = "printer_amount")
	private Double printerAmount;

	@Column(name = "remark")
	private String remark;

	@Column(name = "service_amount")
	private Double serviceAmount;
	@Column(name = "printer_amount")
	private Double printerAmount;
	@Column(name = "pay_type")
	private Integer payType;
	@Column(name = "attorney_id")
	private Long attorneyId;
	@Column(name = "attorney_code")
	private String attorneyCode;

	private static final long serialVersionUID = 1L;

	@Transient
	private ZxUser zxUser;

	@Transient
	private ZxUser lawyer;

	@Transient
	private SysUser sysUser;

	@Transient
	private ZxPrinterManager zxPrinterManager;

	@Transient
	private ZxOrderPrinterFile zxOrderPrinterFile;

	@Transient
	private ZxFileManagerAB zxFileManagerAB;

	@Transient
	private ZxFileManagerCDE zxFileManagerCDE;
}