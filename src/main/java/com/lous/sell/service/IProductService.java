package com.lous.sell.service;

import com.lous.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @ClassName : IProductService
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-01
 **/
 
public interface IProductService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> finAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    //减库存
}
