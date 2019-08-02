package com.cgh.sell.bean;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 订单详情
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
//@Table(name = "order_detail")
public class OrderDetail {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String detailId;

    @JoinColumn(unique = false)
    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;
}
