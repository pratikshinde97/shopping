package com.example.shopping.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public  interface CartRepository extends JpaRepository<Cart, String> {


    @Query(value = "select sum(tax_total) from cart where customer_id=:customerId",nativeQuery = true)
    public double sumQuantities(@Param("customerId") String customerId);

    @Transactional
    void deleteByCustomerIdAndProductId(String customerId,String productId);
    @Transactional
    void removeByQuantity(int quantity);

    List<Cart> findAllByCustomerId(String customerId);

    @Transactional
    void deleteByCustomerId(String customerId);

    @Transactional
    void deleteByProductId(String productId);
}
