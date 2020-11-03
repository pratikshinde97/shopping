package com.example.shopping.dailysales;

import com.example.shopping.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DAILY_SALES")
@Getter
@Setter
@Access(AccessType.PROPERTY)
public class DailySales extends BaseEntity {

    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount = BigDecimal.ZERO;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "SALE_COUNT")
    private  Integer count;


}
