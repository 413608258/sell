package com.lous.sell.repository;

import com.lous.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567890");
        orderDetail.setOrderId("11111111");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("1111112");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(BigDecimal.valueOf(9));
        orderDetail.setProductQuantity(2);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> result = repository.findByOrderId("11111111");
        System.out.println(result);
        Assert.assertNotEquals(0, result.size());
    }
}