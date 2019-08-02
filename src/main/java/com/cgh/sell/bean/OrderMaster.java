package com.cgh.sell.bean;

import com.cgh.sell.enums.OrderStatusEnum;
import com.cgh.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 买家信息
 */
@Entity
@Data
@DynamicUpdate
@DynamicInsert
public class OrderMaster {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    //买家微信
    private String buyerOpenid;

    private BigDecimal orderAmount;

    //订单状态,默认为0新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态，默认为0未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;
}
