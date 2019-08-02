package com.cgh.sell.bean;

import com.cgh.sell.enums.ProductStatusEnum;
import com.cgh.sell.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "product_info")
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;

    @Column
    private String productName;

    @Column
    private BigDecimal productPrice;

    @Column
    private Integer productStock;

    @Column
    private String productDescription;

    @Column
    private String productIcon;

    @Column
    private Integer productStatus;

    @Column
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }


}
