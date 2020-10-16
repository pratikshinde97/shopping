package com.example.shopping.products;


import com.example.shopping.Item.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
public  ProductService(ProductRepository repository){this.repository=repository;}

    public Products saveProduct(Products product){
        return  repository.save(product);
    }
    public Page<Products> getAllProducts(Pageable pageRequest) {
        return repository.findAll(pageRequest);
    }
    public List<Products> saveProducts(List<Products> products)
    {
        return repository.saveAll(products);
    }

    public Products getProductById(int id){
        return  repository.findById(id).orElse(null);
    }

//    public Products getProductByName(String name){
//        return  repository.findByName(name);
//    }

    public  String deleteProductById(int id){
        repository.deleteById(id);
        return  " Product Deleted!!";
    }

//    public  String deleteByProductName(String name){
//        repository.deleteByName(name);
//        return  " Product Deleted!!";
//    }

    public  Products updateProductById(int id,Products product){
        Products existingProduct=repository.findById(id).orElse(null);
        existingProduct.setProductPrice(product.getProductPrice());
        return  repository.save(existingProduct);
    }

    public Products save(Products product)
        {System.out.println(product.getProductPrice());
            return  repository.save(product);
        }


//    public Products updateProductByNameAndPrice(int id, String name, Products product) {
//        Products existingProduct=repository.findById(id).orElse(null);
//        existingProduct.setPrice(product.getPrice());
//        return  repository.save(existingProduct);
//    }
}
