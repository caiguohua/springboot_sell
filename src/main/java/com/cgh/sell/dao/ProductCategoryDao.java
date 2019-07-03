package com.cgh.sell.dao;

import com.cgh.sell.bean.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {
}
