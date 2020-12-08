package com.example.shopping.products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO saveProduct(ProductDTO productdto, List<byte[]> file1) {
//        productdto.setFile1(file1);
//        productdto.setFile2(file2);
//        productdto.setFile3(file3);
//        productdto.setFile4(file4);

        System.out.println(file1.size());
        if (file1.size() == 1) {
            productdto.setFile1(file1.get(0));
        }
        if (file1.size() == 2) {
            productdto.setFile1(file1.get(0));
            productdto.setFile2(file1.get(1));

        }
        if (file1.size() == 3) {
            productdto.setFile1(file1.get(0));
            productdto.setFile2(file1.get(1));
            productdto.setFile3(file1.get(2));
        }
        if (file1.size() == 4) {
            productdto.setFile1(file1.get(0));
            productdto.setFile2(file1.get(1));
            productdto.setFile3(file1.get(2));
            productdto.setFile4(file1.get(3));

        }

        System.out.println(productdto.getCategoryId());
        return new ProductDTO(repository.save(productdto.getEntity(null)));
    }

    public List<ProductDTO> getAllProducts(Pageable pageRequest) {
        Page<Product> productsList = repository.findAll(pageRequest);
        List<ProductDTO> productsDTOList = new ArrayList<>();
        for (Product products : productsList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.getDTO(products);
            productsDTOList.add(productDTO);
        }
        return productsDTOList;
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public ProductDTO getProductById(String id) {
        List<byte[]>list=new ArrayList<>();

        ProductDTO productDTO = new ProductDTO();
        repository.findById(id).ifPresent(product -> {
//            list.add(product.getFile1());
//            list.add(product.getFile2());
//            list.add(product.getFile3());
//            list.add(product.getFile4());
//            productDTO.setList(list);
            productDTO.getDTO(product);
        });
        return productDTO;
    }
//
//    public ProductDTO getProductImagesById(String id) {
//        List<byte[]>list=new ArrayList<>();
//        ProductDTO productDTO = new ProductDTO();
//        repository.findById(id).ifPresent(product -> {
//            list.add(product.getFile1());
//            list.add(product.getFile2());
//            list.add(product.getFile3());
//            list.add(product.getFile4());
//            productDTO.setList(list);
//        });
//        return productDTO;
//    }

//    public Products getProductByName(String name){
//        return  repository.findByName(name);
//    }

    public String deleteProductById(String id) {
        String name = repository.findById(id).get().getProductName();
        repository.deleteById(id);
        return String.format("Product %s is deleted", name);
    }

//    public  String deleteByProductName(String name){
//        repository.deleteByName(name);
//        return  " Product Deleted!!";
//    }

    public String updateProductById(String id, ProductDTO product) {
        Product products = new Product();
        products = repository.findById(id).get();

        products.setSalePrice(product.getSalePrice() == 0.0 ? products.getSalePrice() : product.getSalePrice());
        products.setProductName(product.getProductName() == null || product.getProductName().isEmpty() ? products.getProductName() : product.getProductName());
        products.setActualPrice(product.getActualPrice() == 0.0 ? products.getActualPrice() : product.getActualPrice());
        products.setMrp(product.getMrp() == 0.0 ? products.getMrp() : product.getMrp());
        products.setFile1(products.getFile1());
        products.setFile2(products.getFile2());
        products.setFile3(products.getFile3());
        products.setFile4(products.getFile4());
        repository.save(products);
        return "Product Updated Successfully!";

    }

//    public String updateProductImageById(String id, byte[] file1, byte[] file2, byte[]file3, byte[]file4){
//        Product products=new Product();
//        products= repository.findById(id).get();
//
//        products.setSalePrice(products.getSalePrice());
//        products.setActualPrice(products.getActualPrice());
//        products.setMrp(products.getMrp());
//
//        products.setProductName(products.getProductName());
//
//        products.setFile1(file1.length==0.0?products.getFile1():file1);
//        products.setFile2(file2.length==0.0?products.getFile2():file2);
//        products.setFile3(file3.length==0.0?products.getFile3():file3);
//        products.setFile4(file4.length==0.0?products.getFile4():file4);
//         repository.save(products);
//        return "Product Images Successfully!";
//
//    }


    public String updateProductImageById(String id, List<byte[]> file1) {
        Product products = new Product();
        products = repository.findById(id).get();

        products.setSalePrice(products.getSalePrice());
        products.setActualPrice(products.getActualPrice());
        products.setMrp(products.getMrp());

        products.setProductName(products.getProductName());

        products.setFile1(file1.get(0));
        products.setFile2(file1.get(1));
        products.setFile3(file1.get(2));
        products.setFile4(file1.get(3));
        repository.save(products);
        return "Product Images Successfully!";

    }


    public List<ProductDTO> getProductByCategoryId(String id) {
        System.out.println(id);
        List<Product> productsList = repository.findAllProductsByCategoryId(id);
        List<ProductDTO> productsDTOList = new ArrayList<>();
        for (Product products : productsList) {
            System.out.println("products"+products.getProductName());
            ProductDTO productDTO = new ProductDTO();
            productDTO.getDTO(products);
            productsDTOList.add(productDTO);
            System.out.println("dto"+productDTO.getProductName());
        }
        return productsDTOList;

    }
}
