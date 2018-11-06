package com.lous.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.lous.sell.dto.OrderDTO;

/**
 * @ClassName : IPayService
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-05
 **/
 
public interface IPayService {

    PayResponse cteate(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
