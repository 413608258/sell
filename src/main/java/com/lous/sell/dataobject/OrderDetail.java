package com.lous.sell.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 订单详情
 * </p>
 *
 * @author Loushuai
 * @since 2018-11-01
 */
@Entity
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String detailId;
    private String orderId;
    private String productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品价格
     */
    private BigDecimal productPrice;
    /**
     * 商品数量
     */
    private Integer productQuantity;
    /**
     * 商品小图
     */
    private String productIcon;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


    public String getDetailId() {
        return detailId;
    }

    public OrderDetail setDetailId(String detailId) {
        this.detailId = detailId;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderDetail setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getProductId() {
        return productId;
    }

    public OrderDetail setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public OrderDetail setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public OrderDetail setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
        return this;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public OrderDetail setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
        return this;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public OrderDetail setProductIcon(String productIcon) {
        this.productIcon = productIcon;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public OrderDetail setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public OrderDetail setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public static final String DETAIL_ID = "detail_id";

    public static final String ORDER_ID = "order_id";

    public static final String PRODUCT_ID = "product_id";

    public static final String PRODUCT_NAME = "product_name";

    public static final String PRODUCT_PRICE = "product_price";

    public static final String PRODUCT_QUANTITY = "product_quantity";

    public static final String PRODUCT_ICON = "product_icon";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    @Override
    public String toString() {
        return "OrderDetail{" +
        ", detailId=" + detailId +
        ", orderId=" + orderId +
        ", productId=" + productId +
        ", productName=" + productName +
        ", productPrice=" + productPrice +
        ", productQuantity=" + productQuantity +
        ", productIcon=" + productIcon +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
