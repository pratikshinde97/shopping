package com.example.shopping.products;

import com.example.shopping.categories.Categories;
import com.example.shopping.common.BaseEntity;
import com.example.shopping.images.Images;
//import com.example.shopping.order.Orders;
import com.example.shopping.order.Orders;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
@Access(AccessType.PROPERTY)
public class Products extends BaseEntity {

//    @Access(AccessType.FIELD)
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true ,fetch = FetchType.LAZY, mappedBy="products")
//    private List<Images> images=new ArrayList<>();

//    @Access(AccessType.FIELD)
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID",nullable = false)
//    @JsonBackReference
//    private Categories category;

//    @Access(AccessType.FIELD)
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
//    @JsonBackReference
//    private Orders orders;




//    @Column(name = "IMAGE_ID")
//    private String imageId;

//    @Column(name="CATEGORY_ID")
//    private  String categoryId;

    @Column(name="PRODUCT_NAME")
    private  String productName;

    @Column(name="PRODUCT_PRICE")
    private  double productPrice;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "photo_id")
    private String photoId;

    @Column(name = "document")
    private String document;

//    @Column(name="PRODUCT_CATEGORY")
//    private  String productCategory;

 }
