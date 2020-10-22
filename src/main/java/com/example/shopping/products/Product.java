package com.example.shopping.products;

import com.example.shopping.cart.CartItem;
import com.example.shopping.categories.Categories;
import com.example.shopping.common.BaseEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseEntity {

//    @Access(AccessType.FIELD)
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID",nullable = false)
//    @JsonBackReference
//    private Categories category;

//    @Access(AccessType.FIELD)
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
//    @JsonBackReference
//    private Cart cart;

//    @Access(AccessType.FIELD)
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
//    @JsonBackReference
//    private Orders orders;
//

//    @Column(name = "IMAGE_ID")
//    private String imageId;

//    @Column(name="CATEGORY_ID")
//    private  String categoryId;

//    @OneToMany(mappedBy = "PRODUCT", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<CartItem> cartItemList;


    @Column(name="PRODUCT_NAME")
    private  String productName;

    @Column(name="PRODUCT_PRICE")
    private  double productPrice;

    @Lob
    private byte[] file1;

    @Lob
    private byte[] file2;

    @Lob
    private byte[] file3;

    @Lob
    private byte[] file4;

    @Column(name="CATEGORY_ID")
    private  String categoryId;

 }
