package com.example.shopping.products;

import com.example.shopping.common.BasicOperation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dozer.DozerBeanMapper;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements BasicOperation<Product,ProductDTO> {

    private  String productName;
    private  double actualPrice;
    private  double mrp;
    private  double salePrice;

    private byte[] file1;
    private byte[] file2;
    private byte[] file3;
    private byte[] file4;
    private  String categoryId;
    private String id;


    @JsonIgnore
    private DozerBeanMapper mapper = new DozerBeanMapper();

    public ProductDTO(Product entity) {
        this.getDTO(entity);
    }

    @Override
    @JsonIgnore
    public Product getEntity(Product product) {
        if(product == null) {
            product = mapper.map(this, Product.class);
        }else {
            mapper.map(this, product);
        }
        return product;
    }

    @Override
    @JsonIgnore

    public ProductDTO getDTO(Product product) {
        mapper.map(product, this);
        return this;
    }
}
