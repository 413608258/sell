package com.lous.sell.service;

import com.lous.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @ClassName : ICategoryService
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-01
 **/
 
public interface ICategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
