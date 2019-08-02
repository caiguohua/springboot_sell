package com.cgh.sell.dao;

import com.cgh.sell.bean.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerInfoDao extends JpaRepository<SellerInfo,String> {
    SellerInfo findByOpenid(String openid);
}
