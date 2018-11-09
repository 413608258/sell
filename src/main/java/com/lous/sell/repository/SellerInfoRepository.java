package com.lous.sell.repository;

import com.lous.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName : SellerInfoRepository
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-06
 **/
 
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
