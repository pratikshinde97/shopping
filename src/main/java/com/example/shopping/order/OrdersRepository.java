package com.example.shopping.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, String> {

    @Query(value = "select * from orders where order_status=:status",nativeQuery = true)
    public List<Orders> getOrdersByStatus(@Param("status") String status);

    List<OrdersDTO> findAllByOrderStatus(OrderStatus status);
}
