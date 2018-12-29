package com.lous.sell.service;

import com.lous.sell.dto.OrderDTO;

/**
 * @ClassName : IPushMessageService
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-12-27
 **/
 
public interface IPushMessageService {

    /**
     *
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
