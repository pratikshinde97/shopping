package com.example.shopping.order;

import com.example.shopping.common.BaseEntity;
import com.example.shopping.temperoryOrders.TemporaryOrders;
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
public class Orders extends BaseEntity {

    @OneToMany(
            cascade = CascadeType.MERGE,
            orphanRemoval = true
    )
    private List<TemporaryOrders> order = new ArrayList<>();


//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "pc_fid", referencedColumnName = "id")
//    List < TemporaryOrders > orders = new ArrayList < > ();


//    @OneToMany(mappedBy="order")
//    private Set<TemporaryOrders> orders;

//    @Column(name = "ORDERS")
//    private Set<TemporaryOrders> orders;

    @Column(name = "ORDER_STATUS")
    @Enumerated(EnumType.STRING)
    private  OrderStatus orderStatus;

    @Column(name = "CREATED_DATE")
    private  Date createdDate;

    @Column(name = "COMPLETED_DATE")
    private  Date completedDate;

    @Column(name = "TOTAL_PRICE")
    private double totalPrice;

    @Column(name = "GRAND_TOTAL")
    private double grandTotal;

    @Column(name = "TAX_TOTAL")
    private double taxTotal;

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
