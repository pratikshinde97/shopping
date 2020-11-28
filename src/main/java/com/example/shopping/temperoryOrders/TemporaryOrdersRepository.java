package com.example.shopping.temperoryOrders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TemporaryOrdersRepository extends JpaRepository<TemporaryOrders, String> {

    @Transactional
    void deleteByCustomerIdAndProductId(String customerId,String productId);
    @Transactional
    void removeByQuantity(int quantity);

    List<TemporaryOrders> findAllByCustomerId(String customerId);

    @Transactional
    void deleteByCustomerId(String customerId);
}


