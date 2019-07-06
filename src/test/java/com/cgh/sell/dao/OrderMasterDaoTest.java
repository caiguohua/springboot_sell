package com.cgh.sell.dao;

import com.cgh.sell.bean.OrderMaster;
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
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String OPENID = "111222";

    @Test
    public void saveTest(){
        OrderMaster o = new OrderMaster();
        o.setOrderId("01");
        o.setBuyerName("庸人自扰");
        o.setBuyerPhone("12345678910");
        o.setBuyerAddress("西邮");
        o.setBuyerOpenid(OPENID);
        o.setOrderAmount(new BigDecimal(2.3));

        OrderMaster result = orderMasterDao.save(o);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception{
        PageRequest request = new PageRequest(0,1);

        Page<OrderMaster> result = orderMasterDao.findByBuyerOpenid(OPENID,request);
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}