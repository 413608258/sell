package com.lous.sell.service.impl;

import com.alibaba.fastjson.JSON;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lous.sell.dto.OrderDTO;
import com.lous.sell.enums.ResultEnum;
import com.lous.sell.execption.SellExecption;
import com.lous.sell.service.IPayService;
import com.lous.sell.utils.MathUril;
import javafx.scene.layout.BorderStroke;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @ClassName : PayServiceImpl
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-05
 **/
@Service
@Slf4j
public class PayServiceImpl implements IPayService {

    private static final String ORDER_NAME = "微信点餐订单";

    @Autowired
    private BestPayServiceImpl bestPayService;
    @Autowired
    private OrderServiceImpl orderService;

    @Override
    public PayResponse cteate(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("[微信支付] reques={}", payRequest);

        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("[微信支付] reponse={}", payResponse);
        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyData) {
        //1.验证签名
        //2.支付状态
        //3.支付金额
        //4.支付人(下单人 == 支付人)看业务需求
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("微信支付] 异步通知，payResponse={}", JSON.toJSONString(payResponse));

        //查看订单
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());

        //判断订单是否存在
        if (orderDTO == null) {
            log.info("");//TODO
            throw new SellExecption(ResultEnum.ORDER_NOT_EXIST);
        }
        //判断金额是否一致( 0.10  0.1)
        if (!MathUril.equals(payResponse.getOrderAmount(), orderDTO.getOrderAmount().doubleValue())) {
            log.info("微信支付异步金额校验不通过");//可加详细信息
            throw new SellExecption(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }
        orderService.paid(orderDTO);

        return payResponse;
    }
    //微信退款
    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        return null;
    }
}
