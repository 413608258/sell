package com.lous.sell.service;

import com.lous.sell.dto.OrderDTO;

/**
 * @ClassName : IBuyerService
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-02
 **/
 
public interface IBuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);

}
