package com.lous.sell.service.impl;

import com.lous.sell.dataobject.OrderDetail;
import com.lous.sell.dto.OrderDTO;
import com.lous.sell.enums.OrderStatusEnum;
import com.lous.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("Lous");
        orderDTO.setBuyerAddress("银泰城");
        orderDTO.setBuyerPhone("15012345678");
        orderDTO.setBuyerOpenid("110110");

        //购物车
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(1);
        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(2);

        orderDTO.setOrderDetailList(Arrays.asList(o1, o2));
        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}", result);
        Assert.assertNotNull(result);

    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne("1541141587280531075");
        log.info("[查询单个订单] result={}", result);
        Assert.assertNotEquals(0, result.getOrderDetailList().size());
    }

    @Test
    public void findList() {
        Page<OrderDTO> result = orderService.findList("110110", new PageRequest(0, 10));
        log.info("[查询订单列表] result={}", result.getContent());
        Assert.assertNotEquals(0, result.getContent().size());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne("1541141587280531075");
        OrderDTO result = orderService.cancel(orderDTO);
        //System.out.println("result = " + result);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne("1541141587280531075");
        OrderDTO result = orderService.finish(orderDTO);
        //System.out.println("result = " + result);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("1541141587280531075");
        OrderDTO result = orderService.paid(orderDTO);
        //System.out.println("result = " + result);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}