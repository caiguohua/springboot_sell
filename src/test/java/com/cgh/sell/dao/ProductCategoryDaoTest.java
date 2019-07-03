package com.cgh.sell.dao;

import com.cgh.sell.bean.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

//    @Test
//    public void findOneTest(){
//        ProductCategory productCategory = productCategoryDao.findOne(1);
//        System.out.println(productCategory.toString());
//    }

      @Test
    public void saveTest(){

        ProductCategory productCategory = productCategoryDao.findOne(3);
          System.out.println(productCategory.toString());
       productCategory.setCategoryType(11);

//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryName("女生最爱");
//        productCategory.setCategoryType(3);
        productCategoryDao.save(productCategory);
    }

}