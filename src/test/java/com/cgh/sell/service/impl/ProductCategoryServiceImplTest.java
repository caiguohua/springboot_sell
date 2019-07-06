package com.cgh.sell.service.impl;

import com.cgh.sell.bean.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl productCategoryServiceImpl;

    @Test
    public void findOne() throws Exception{
        ProductCategory productCategory = productCategoryServiceImpl.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception{
        List<ProductCategory> productCategoryList = productCategoryServiceImpl.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception{
        List<ProductCategory> productCategoryList = productCategoryServiceImpl.findByCategoryTypeIn(Arrays.asList(2,3,4));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void save() throws Exception{
        ProductCategory productCategory = new ProductCategory("男生专享",10);
        ProductCategory result = productCategoryServiceImpl.save(productCategory);
        Assert.assertNotNull(result);
    }
}