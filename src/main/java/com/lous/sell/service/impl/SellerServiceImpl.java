package com.lous.sell.service.impl;

import com.lous.sell.dataobject.SellerInfo;
import com.lous.sell.repository.SellerInfoRepository;
import com.lous.sell.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : SellerServiceImpl
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-06
 **/
@Service
public class SellerServiceImpl implements ISellerService {

    @Autowired
    private SellerInfoRepository repository;
    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        SellerInfo sellerInfo = repository.findByOpenid(openid);
        return sellerInfo;
    }
}
