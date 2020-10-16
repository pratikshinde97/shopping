package com.example.shopping.categories;

import com.example.shopping.common.BasicOperation;
import com.example.shopping.images.Images;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;
import org.dozer.DozerBeanMapper;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CategoriesDTO implements BasicOperation<Categories, CategoriesDTO> {
private  String categoryName;
    private List<String> categoriesImages;
    private List<Images> images;
    private String id;

    @JsonIgnore
    private DozerBeanMapper mapper = new DozerBeanMapper();

    public CategoriesDTO(Categories entity) {
        this.getDTO(entity);
    }

    @Override
    @JsonIgnore
    public Categories getEntity(Categories entity) {
        if(entity == null) {
            entity = mapper.map(this, Categories.class);
        }else {
            mapper.map(this, entity);
        }
        return entity;
    }

    @Override
    @JsonIgnore
    public CategoriesDTO getDTO(Categories entity) {
        mapper.map(entity, this);
        return this;
    }
}
