package com.lous.sell.controller;

import com.lous.sell.dto.OrderDTO;
import com.lous.sell.enums.ResultEnum;
import com.lous.sell.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @ClassName : SellerOrderController
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-06
 **/
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                             @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                             Map<String, Object> map){
        PageRequest request = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("order/list1", map);
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId, Map<String, Object> map){
        OrderDTO orderDTO = null;
        try {
            orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("[卖家端取消订单] 异常{}", e);

            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");
    }
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map){
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (Exception e) {
            log.error("[卖家端查询订单详情]异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("orderDTO", orderDTO);

        return new ModelAndView("order/detail", map);
    }
    @GetMapping("/finish")
    public ModelAndView finished(@RequestParam("orderId") String orderId,
                                 Map<String, Object> map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (Exception e) {
            log.error("[卖家端完结订单]异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");
    }
}
