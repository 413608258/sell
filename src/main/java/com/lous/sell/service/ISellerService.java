package com.lous.sell.service;

import com.lous.sell.dataobject.SellerInfo;

/**
 * @ClassName : ISellerService
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-06
 **/
 
public interface ISellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
