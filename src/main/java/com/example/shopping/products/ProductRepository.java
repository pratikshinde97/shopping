package com.example.shopping.products;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    @Transactional
    void deleteByCategoryId(String id);
//    Products findByName(String name);

  //  String deleteByName(String name);


}
