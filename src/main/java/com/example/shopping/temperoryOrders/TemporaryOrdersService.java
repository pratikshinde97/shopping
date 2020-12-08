package com.example.shopping.temperoryOrders;
import com.example.shopping.cart.CartRepository;
import com.example.shopping.common.IService;
import com.example.shopping.order.OrderStatus;
import com.example.shopping.order.Orders;
import com.example.shopping.order.OrdersRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TemporaryOrdersService implements IService<TemporaryOrders, String> {


    private final TemporaryOrdersRepository repository;

    @Autowired
    private final OrdersRepository ordersRepository;

    private final CartRepository cartRepository;


    public TemporaryOrdersService(TemporaryOrdersRepository repository,OrdersRepository ordersRepository,CartRepository cartRepository) {
        this.repository = repository;
        this.ordersRepository=ordersRepository;
        this.cartRepository=cartRepository;
    }

    public Page<TemporaryOrders> findAll(Pageable pageRequest) {
        return repository.findAll(pageRequest);
    }

    public TemporaryOrders findById(String id) {
       return  repository.findById(id).orElse(null);
    }

    public String create(TemporaryOrders resource) {
         return  repository.save(resource).getId();
    }
    public List<TemporaryOrders> saveOrders(List<TemporaryOrders> orders)
    {
        return repository.saveAll(orders);
    }

    public void update(TemporaryOrders resource) {
        repository.save(resource);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void findAllByCustomerId(String customerId) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        List<Orders> orders=new ArrayList<>();
        Orders newOrders=new Orders();
        List<TemporaryOrders> carts= repository.findAllByCustomerId(customerId);

//        for (int i=0;i<carts.size();i++)
//        {
//            newOrders.setCustomerId(customerId);
//            newOrders.setProductId(carts.get(i).getProductId());
//            newOrders.setCreatedDate(new Date(formatter.format(date)));
//            newOrders.setOrderStatus(OrderStatus.NEW);
//            newOrders.setQuantity(carts.get(i).getQuantity());
//            newOrders.setTotalPrice(carts.get(i).getTotalPrice());
//            newOrders.setGrandTotal(carts.get(i).getGrandTotal());
//            orders.add(newOrders);
//            System.out.println("temporaryOrders.setProductId(carts.get(i).getProductId());"+carts.get(i).getProductId());
//        }
        ordersRepository.saveAll(orders);
        cartRepository.deleteByCustomerId(customerId);
        repository.deleteByCustomerId(customerId);
    }
}
