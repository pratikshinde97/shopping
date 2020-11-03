package com.example.shopping.cart;

import org.springframework.data.jpa.repository.JpaRepository;

public  interface CartItemRepository extends JpaRepository<CartItem, String> {
}
