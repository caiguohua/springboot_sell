package com.cgh.sell.service;


import com.cgh.sell.bean.SellerInfo;

public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);

}
