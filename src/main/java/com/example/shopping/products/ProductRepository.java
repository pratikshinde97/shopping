package com.example.shopping.products;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
//    Products findByName(String name);

  //  String deleteByName(String name);


}
