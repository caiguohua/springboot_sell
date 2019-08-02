package com.cgh.sell.bean;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 类目
 * 2019-07-02 10：46
 * cgh
 */

/**
 * 在Hibernate中可以利用@DynamicInsert和@DynamicUpdate生成动态SQL语句，即在插入和修改数据的时候,语句中只包括要插入或者修改的字段。
 *
 *    当然还有其他的方式达到这种效果，比如使用session为我们提供的merge方法，也是可以的。
 *
 *    @Data 包含get set 构造方法 tostring 等方法。
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Data
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    @Column
    private String categoryName;

    @Column
    private Integer categoryType;


    private Date createTime;

    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
