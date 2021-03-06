package com.example.shopping.categories;

import com.example.shopping.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CATEGORIES")

public class Categories extends BaseEntity {

//    @Access(AccessType.FIELD)
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy="category")
//    private List<Product> products=new ArrayList<>();

    @NotNull
    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @NotNull
    @Lob
    @Column(name = "photo", columnDefinition="LONGBLOB")
    private byte[] data;

    @Column(name = "CGST")
    private double cgst;

    @Column(name = "SGST")
    private double sgst;

}
