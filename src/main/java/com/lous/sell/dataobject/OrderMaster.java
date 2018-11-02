package com.lous.sell.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author Loushuai
 * @since 2018-11-01
 */
@Entity
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String orderId;
    /**
     * 买家姓名
     */
    private String buyerName;
    /**
     * 买家电话
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    /**
     * 买家微信openid
     */
    private String buyerOpenid;
    /**
     * 订单总金额
     */
    private BigDecimal buyerAmount;
    /**
     * 订单装填,默认0新下单
     */
    private Integer orderStatus;
    /**
     * 支付状态,默认0未支付
     */
    private Integer payStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


    public String getOrderId() {
        return orderId;
    }

    public OrderMaster setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public OrderMaster setBuyerName(String buyerName) {
        this.buyerName = buyerName;
        return this;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public OrderMaster setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
        return this;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public OrderMaster setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
        return this;
    }

    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    public OrderMaster setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid;
        return this;
    }

    public BigDecimal getBuyerAmount() {
        return buyerAmount;
    }

    public OrderMaster setBuyerAmount(BigDecimal buyerAmount) {
        this.buyerAmount = buyerAmount;
        return this;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public OrderMaster setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public OrderMaster setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public OrderMaster setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public OrderMaster setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public static final String ORDER_ID = "order_id";

    public static final String BUYER_NAME = "buyer_name";

    public static final String BUYER_PHONE = "buyer_phone";

    public static final String BUYER_ADDRESS = "buyer_address";

    public static final String BUYER_OPENID = "buyer_openid";

    public static final String BUYER_AMOUNT = "buyer_amount";

    public static final String ORDER_STATUS = "order_status";

    public static final String PAY_STATUS = "pay_status";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    @Override
    public String toString() {
        return "OrderMaster{" +
        ", orderId=" + orderId +
        ", buyerName=" + buyerName +
        ", buyerPhone=" + buyerPhone +
        ", buyerAddress=" + buyerAddress +
        ", buyerOpenid=" + buyerOpenid +
        ", buyerAmount=" + buyerAmount +
        ", orderStatus=" + orderStatus +
        ", payStatus=" + payStatus +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
