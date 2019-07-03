package com.cgh.sell.service;

import com.cgh.sell.dao.ProductCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    @Autowired
    ProductCategoryDao productCategoryDao;
}
