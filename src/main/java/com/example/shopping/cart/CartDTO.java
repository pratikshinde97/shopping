package com.example.shopping.cart;


import com.example.shopping.common.BasicOperation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.dozer.DozerBeanMapper;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CartDTO implements BasicOperation<Cart, CartDTO> {
    private String categoryName;

    private String id;
    private String customerId;
    private String productId;
    private  int quantity;
//    private  double totalPrice;
//    private  double grandTotal;
//    private  double taxTotal;
//    private double cgst;
//    private double sgst;

    @JsonIgnore
    private DozerBeanMapper mapper = new DozerBeanMapper();

    public CartDTO(Cart entity) {
        this.getDTO(entity);
    }

    @Override
    @JsonIgnore
    public Cart getEntity(Cart entity) {
        if (entity == null) {
            entity = mapper.map(this, Cart.class);
        } else {
            mapper.map(this, entity);
        }
        return entity;
    }

    @Override
    @JsonIgnore
    public CartDTO getDTO(Cart entity) {
        mapper.map(entity, this);
        return this;
    }
}