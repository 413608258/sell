package com.lous.sell.service.impl;

import com.lous.sell.dto.OrderDTO;
import com.lous.sell.service.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessageService;
    @Autowired
    private IOrderService orderService;

    @Test
    public void orderStatus(){
        OrderDTO orderDTO = orderService.findOne("1541141926382169015");
        pushMessageService.orderStatus(orderDTO);
    }
}