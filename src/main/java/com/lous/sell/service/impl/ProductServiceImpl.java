package com.lous.sell.service.impl;


import com.lous.sell.dataobject.ProductInfo;
import com.lous.sell.enums.ProductStatusEnum;
import com.lous.sell.repository.ProductInfoRepository;
import com.lous.sell.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : ProductServiceImpl
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-01
 **/
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> finAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
