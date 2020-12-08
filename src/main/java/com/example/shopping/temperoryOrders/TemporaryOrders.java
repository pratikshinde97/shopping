package com.example.shopping.temperoryOrders;

import com.example.shopping.common.BaseEntity;
import com.example.shopping.order.Orders;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import javax.persistence.*;

@Entity
@Table(name = "TEMPORARY_ORDERS")
@Getter
@Setter
public
class TemporaryOrders extends BaseEntity {

    @Column(name = "CUSTOMER_ID")
    private  String customerId;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Access(AccessType.FIELD)
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
    @JsonBackReference
    private Orders order;



}
