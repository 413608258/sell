package com.lous.sell.repository;

import com.lous.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;
    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1324567");
        orderMaster.setBuyerName("Lous");
        orderMaster.setBuyerPhone("123456798");
        orderMaster.setBuyerAddress("西湖区");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(BigDecimal.valueOf(10));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0, 10);

        Page<OrderMaster> result = repository.findByBuyerOpenid("110110", request);
        System.out.println(result.getContent());
        Assert.assertNotEquals(0, result.getContent().size());
    }
}