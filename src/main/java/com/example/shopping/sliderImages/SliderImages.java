package com.example.shopping.sliderImages;

import com.example.shopping.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SLIDER_IMAGES")

public class SliderImages extends BaseEntity {

//    @Access(AccessType.FIELD)
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy="category")
//    private List<Product> products=new ArrayList<>();

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Lob
    @Column(name = "photo", columnDefinition="LONGBLOB")
    private byte[] data;

}
