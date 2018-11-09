package com.lous.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName : ProductForm
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-06
 **/
 @Data
public class ProductForm {

    private String productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 单价
     */
    private BigDecimal productPrice;
    /**
     * 库存
     */
    private Integer productStock;
    /**
     * 描述
     */
    private String productDescription;
    /**
     * 小图
     */
    private String productIcon;
    /**
     * 类目编号
     */
    private Integer categoryType;
}
