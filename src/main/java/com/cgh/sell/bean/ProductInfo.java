package com.cgh.sell.bean;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

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

    public ProductInfo() {
    }

    public ProductInfo( String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
    }
}
