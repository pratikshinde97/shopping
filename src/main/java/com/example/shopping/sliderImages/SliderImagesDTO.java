package com.example.shopping.sliderImages;

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
public class SliderImagesDTO implements BasicOperation<SliderImages, SliderImagesDTO> {
    private  String name;

    private  byte[] data;
    private String id;

    @JsonIgnore
    private DozerBeanMapper mapper = new DozerBeanMapper();

    public SliderImagesDTO(SliderImages entity) {
        this.getDTO(entity);
    }

    @Override
    @JsonIgnore
    public SliderImages getEntity(SliderImages entity) {
        if(entity == null) {
            entity = mapper.map(this, SliderImages.class);
        }else {
            mapper.map(this, entity);
        }
        return entity;
    }

    @Override
    @JsonIgnore
    public SliderImagesDTO getDTO(SliderImages entity) {
        mapper.map(entity, this);
        return this;
    }
}
