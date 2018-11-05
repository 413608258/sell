package com.lous.sell.converter;

import com.alibaba.fastjson.JSON;
import com.lous.sell.dataobject.OrderDetail;
import com.lous.sell.dto.OrderDTO;
import com.lous.sell.enums.ResultEnum;
import com.lous.sell.execption.SellExecption;
import com.lous.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : OrderForm2OrderDTOConverter
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-02
 **/
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = JSON.parseArray(orderForm.getItems(), OrderDetail.class);
        } catch (Exception e) {
            log.error("[对象转换] 错误，itemsString={}", orderForm.getItems());
            throw new SellExecption(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
