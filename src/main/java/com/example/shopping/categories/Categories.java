package com.example.shopping.categories;

import com.example.shopping.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CATEGORIES")
@Access(AccessType.PROPERTY)

public class Categories extends BaseEntity {

//    @Access(AccessType.FIELD)
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy="category")
//    private List<Products> products=new ArrayList<>();

//    @Access(AccessType.FIELD)
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy="categories")
//    private List<Images> images=new ArrayList<>();

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Lob
    @Column(name = "file", columnDefinition = "LONGBLOB")
    private byte[] picByte;


}
