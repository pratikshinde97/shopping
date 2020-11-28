package com.example.shopping.cart;

import com.example.shopping.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CART")
@Getter
@Setter
@Access(AccessType.PROPERTY)
public class Cart extends BaseEntity {
//    @Access(AccessType.FIELD)
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy="cart")
//    private List<Products> products = new ArrayList<>();


//
//    @OneToMany(mappedBy = "Cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
//    private List<CartItem> cartItem=new ArrayList<>();

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ID")
//    @JsonIgnore
//    private User customer;


//    @OneToOne
//    @JoinColumn(name = "customer_id")
//    @JsonIgnore
//    private User customer;

//    @ManyToOne
//    @JoinColumn(name = "CART_ID")
//    private Cart cart;


    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "TOTAL_PRICE")
    private double totalPrice;

    @Column(name = "GRAND_TOTAL")
    private double grandTotal;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "COMPLETED_DATE")
    private  Date completeDate;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "TAX_TOTAL")
    private double taxTotal;

}
