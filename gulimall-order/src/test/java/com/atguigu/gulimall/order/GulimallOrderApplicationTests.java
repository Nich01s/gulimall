package com.atguigu.gulimall.order;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.atguigu.gulimall.order.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallOrderApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    public void contextLoads() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setNote("订单测试...");
        orderService.save(orderEntity);
        System.out.println("保存成功...");
    }

}
