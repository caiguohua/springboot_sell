package com.cgh.sell.service;

import com.cgh.sell.bean.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> catrgoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
