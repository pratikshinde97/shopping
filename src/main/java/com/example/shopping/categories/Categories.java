package com.example.shopping.categories;

import com.example.shopping.common.BaseEntity;
import com.example.shopping.products.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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


    private String categoryName;

    @Lob
    private byte[] data;

}
