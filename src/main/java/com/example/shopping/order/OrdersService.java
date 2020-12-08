package com.example.shopping.order;
import com.example.shopping.common.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements IService<Orders, String> {

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

    public String create(Orders resource) {
        return repository.save(resource).getId();
    }
    public List<Orders> saveOrders(List<Orders> orders)
    {
        return repository.saveAll(orders);
    }

    public void update(Orders resource) {
        repository.save(resource);
    }

//    public void updateOrder(List<Orders> resource) {
//                repository.save(resource);
//    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
