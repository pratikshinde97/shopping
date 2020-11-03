package com.example.shopping.order;


import com.example.shopping.cart.Cart;
import com.example.shopping.common.BaseEntity;
import com.example.shopping.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Orders extends BaseEntity {

    @Column(name = "CUSTOMER_ID")
    private  String customerId;

//    @Access(AccessType.FIELD)
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy="orders")
//    @JsonBackReference
//    private List<Products> orderItems = new ArrayList<>();

    @Column(name = "TOTAL_AMOUNT")
    private  String totalAmount;

    @Column(name = "ORDER_STATUS")
    private  OrderStatus orderStatus;

    @Column(name = "CREATED_DATE")
    private  Date createdDate;

    @Column(name = "COMPLETED_DATE")
    private  Date completedDate;

//    @OneToOne(fetch = FetchType.LAZY,optional = false)
//    @JoinColumn(name = "Id")
//    private Cart cart;

//    @OneToOne(fetch = FetchType.LAZY,optional = false)
//    @JoinColumn(name = "Id")
//    private User customer;

//    @OneToMany(mappedBy ="Cart")
//    private List<Cart> cartId;

//    @OneToMany
//    @JoinColumn(name = "orders_id")
//    private List<Cart> cart = new ArrayList<>();
}
