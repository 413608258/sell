package com.lous.sell.controller;

import com.lly835.bestpay.model.PayResponse;
import com.lous.sell.dto.OrderDTO;
import com.lous.sell.enums.ResultEnum;
import com.lous.sell.execption.SellException;
import com.lous.sell.service.IOrderService;
import com.lous.sell.service.IPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @ClassName : PayController
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-05
 **/
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IPayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl, Map<String, Object> map){
        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.发起支付
        PayResponse payResponse = payService.cteate(orderDTO);
        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);
        return new ModelAndView("pay/create", map);
    }
    //微信异步通知
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){
        payService.notify(notifyData);

        return new ModelAndView("pay/success");
    }
}
