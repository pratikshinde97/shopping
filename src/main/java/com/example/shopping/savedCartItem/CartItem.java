//package com.example.shopping.savedCartItem;
//
//import com.example.shopping.common.BaseEntity;
//import com.example.shopping.products.Product;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "CART_ITEM")
//@Getter
//@Setter
//public class CartItem extends BaseEntity {
////    @Access(AccessType.FIELD)
////    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy="cart")
////    private List<Products> products = new ArrayList<>();
//
//
////    @ManyToOne
////    @JoinColumn(name = "CART_ID")
////    private Cart cart;
//
//    @ManyToOne
//    @JoinColumn(name = "PRODUCT_ID")
//    private Product product;
//
//    @Column(name = "QUANTITY")
//    private int quantity;
//
//    @Column(name = "TOTAL_PRICE")
//    private double totalPrice;
//
//
//}
