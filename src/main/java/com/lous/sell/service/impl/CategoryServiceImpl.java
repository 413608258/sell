package com.lous.sell.service.impl;

import com.lous.sell.dataobject.ProductCategory;
import com.lous.sell.repository.ProductCategoryRepository;
import com.lous.sell.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : CategoryServiceImpl
 * @Description : 类目
 *
 * @author : Loushuai
 * @since : 2018-11-01
 **/
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
