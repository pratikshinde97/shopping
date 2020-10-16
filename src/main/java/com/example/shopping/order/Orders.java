package com.example.shopping.order;


import com.example.shopping.common.BaseEntity;
import com.example.shopping.products.Products;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@Access(AccessType.PROPERTY)
public class Orders extends BaseEntity {

//    @Column(name = "CUSTOMER_ID")
//    private  String customerId;

//    @Access(AccessType.FIELD)
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy="orders")
//    @JsonBackReference
//    private List<Products> orderItems = new ArrayList<>();

    @Column(name = "TOTAL_AMOUNT")
    private  String totalAmount;

    @Column(name = "ORDER_STATUS")
    private  boolean orderStatus;

    @Column(name = "DATE")
    private  Date date;

}
