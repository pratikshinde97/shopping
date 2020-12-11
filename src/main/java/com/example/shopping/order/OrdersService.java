package com.example.shopping.order;
import com.example.shopping.common.IService;
import oracle.sql.DATE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class OrdersService{

    private final OrdersRepository repository;

    public OrdersService(OrdersRepository repository) {
        this.repository = repository;
    }

    public Page<Orders> findAll(Pageable pageRequest) {
        return repository.findAll(pageRequest);

    }

    public Orders findById(String id) {

       return  repository.findById(id).orElse(null);
    }
    @Transactional
    public String create(Orders resource) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Date date=new Date();
        resource.setOrderStatus(OrderStatus.NEW);
        resource.setCreatedDate(date);
        return repository.save(resource).getId();
    }
    public List<Orders> saveOrders(List<Orders> orders)
    {
        return repository.saveAll(orders);
    }

    public void update(String id,OrderStatus status) {
        Orders orders=new Orders();
        orders= repository.findById(id).get();
        orders.setOrder(orders.getOrder());
        orders.setTotalPrice(orders.getTotalPrice());
        orders.setOrderStatus(status);
        orders.setCreatedDate(orders.getCreatedDate());
        orders.setCompletedDate(orders.getCompletedDate());
        orders.setId(orders.getId());
        orders.setGrandTotal(orders.getGrandTotal());
        orders.setTaxTotal(orders.getTaxTotal());
       repository.save(orders);

    }

//    public void updateOrder(List<Orders> resource) {
//                repository.save(resource);
//    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
