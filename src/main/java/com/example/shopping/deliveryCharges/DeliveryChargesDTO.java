package com.example.shopping.deliveryCharges;

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
public class DeliveryChargesDTO implements BasicOperation<DeliveryCharges, DeliveryChargesDTO> {
    private double upto;
    private double deliveryCharges;
    private String id;
    @JsonIgnore
    private DozerBeanMapper mapper = new DozerBeanMapper();

    public DeliveryChargesDTO(DeliveryCharges entity) {
        this.getDTO(entity);
    }

    @Override
    @JsonIgnore
    public DeliveryCharges getEntity(DeliveryCharges entity) {
        if(entity == null) {
            entity = mapper.map(this, DeliveryCharges.class);
        }else {
            mapper.map(this, entity);
        }
        return entity;
    }

    @Override
    @JsonIgnore
    public DeliveryChargesDTO getDTO(DeliveryCharges entity) {
        mapper.map(entity, this);
        return this;
    }
}
