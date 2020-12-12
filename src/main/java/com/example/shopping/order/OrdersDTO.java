package com.example.shopping.order;

import com.example.shopping.common.BasicOperation;

import com.example.shopping.order.Orders;
import com.example.shopping.temperoryOrders.TemporaryOrders;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;
import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrdersDTO implements BasicOperation<Orders, OrdersDTO> {
    private List<TemporaryOrders> order = new ArrayList<>();
    private  OrderStatus orderStatus;
    private String id;

    private Date createdDate;
    private  Date completedDate;
    private double totalPrice;
    private double grandTotal;
    private double taxTotal;

    @JsonIgnore
    private DozerBeanMapper mapper = new DozerBeanMapper();

    public OrdersDTO(Orders entity) {
        this.getDTO(entity);
    }

    @Override
    @JsonIgnore
    public Orders getEntity(Orders entity) {
        if(entity == null) {
            entity = mapper.map(this, Orders.class);
        }else {
            mapper.map(this, entity);
        }
        return entity;
    }

    @Override
    @JsonIgnore
    public OrdersDTO getDTO(Orders entity) {
        mapper.map(entity, this);
        return this;
    }
}
