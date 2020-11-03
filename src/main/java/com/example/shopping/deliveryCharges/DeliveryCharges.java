package com.example.shopping.deliveryCharges;

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
@Table(name = "DELIVERY_CHARGES")

public class DeliveryCharges extends BaseEntity {

//    @Access(AccessType.FIELD)
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy="category")
//    private List<Product> products=new ArrayList<>();

    @Column(name = "UpTo")
    private double upto;

    @Column(name = "DELIVERY_CHARGES")
    private double deliveryCharges;


}
