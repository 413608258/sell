package com.lous.sell.form;

import lombok.Data;

/**
 * @ClassName : CategoryForm
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-06
 **/
 @Data
public class CategoryForm {

    private Integer categoryId;
    /**
     * 类目名称
     */
    private String categoryName;
    /**
     * 类目编号
     */
    private Integer categoryType;
}
