package com.example.shopping.images;

import com.example.shopping.categories.Categories;
import com.example.shopping.common.BaseEntity;
import com.example.shopping.products.Products;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "IMAGES")
@Access(AccessType.PROPERTY)

public class Images extends BaseEntity {
//    @Access(AccessType.FIELD)
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    @JoinColumn(name = "PRODUCT_ID", nullable = false)
//    @JsonBackReference
//    private Products products;

//    @Access(AccessType.FIELD)
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    @JoinColumn(name = "CATEGORIES_ID", nullable = false)
//    @JsonBackReference
//    private Categories categories;

    @Column(name="FILE_NAME")
    private String fileName;
    @Column(name="FILE_TYPE")
    private String fileType;
    @Lob
    @Column(name="DATA",nullable=false, columnDefinition="mediumblob")
    private byte[] data;

    public Images(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

}