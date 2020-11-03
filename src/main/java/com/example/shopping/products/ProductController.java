package com.example.shopping.products;
import com.example.shopping.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")

public class ProductController {
    @Autowired
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping(value = "/create",consumes = { "multipart/form-data" })
    public ResponseEntity<ProductDTO> addProduct(@RequestPart("product") ProductDTO productdto,
                                                    @RequestPart("file1") MultipartFile file1,
                                                    @RequestPart("file2") MultipartFile file2,
                                                    @RequestPart("file3") MultipartFile file3,
                                                    @RequestPart("file4") MultipartFile file4) throws IOException {
        ProductDTO productDTO=new ProductDTO();
        System.out.println(productdto.getCategoryId());
        productDTO= service.saveProduct(productdto,file1.getBytes(),file2.getBytes(),file3.getBytes(),file4.getBytes());
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.CREATED);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return  service.saveProducts(products);
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductDTO>> findAll(@RequestParam("page") Optional<Integer> page,
                                                       @RequestParam("size") Optional<Integer> size) {
        return new ResponseEntity<List<ProductDTO>>(service.getAllProducts(PageUtil.defaultPage(page,size)), HttpStatus.OK);
    }



    @GetMapping("/productById/{id}")
    public ProductDTO getProductById(@PathVariable String id){
        return  service.getProductById(id);
    }
//    @GetMapping("/productByName/{name}")
//    public Products getProductByName(@PathVariable String name){
//        return  service.getProductByName(name);
//    }
    @PutMapping(value = "/productById/{id}",consumes = { "multipart/form-data" })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateProductById(@PathVariable String id, @RequestPart ProductDTO productdto){
        return new ResponseEntity<String>(service.updateProductById(id,productdto),HttpStatus.OK);
    }

    @PutMapping("/productImageById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateProductImageById(@PathVariable String id,
                                          @RequestPart("file1") MultipartFile left, @RequestPart("file2") MultipartFile right,
                                          @RequestPart("file3") MultipartFile top, @RequestPart("file4") MultipartFile bottom) throws IOException {
        return  new ResponseEntity<String>(service.updateProductImageById(id,left.getBytes(),right.getBytes(),top.getBytes(),bottom.getBytes()),HttpStatus.OK);
    }

//    @PutMapping("/productByNameAndPrice/{name}/{price}")
//    public  Products updateProductByNameAndPrice(@PathVariable int id,@PathVariable String name, @RequestBody Products product){
//        System.out.println("id"+id);
//        return  service.updateProductByNameAndPrice(id,name,product);
//    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteProductById(@PathVariable String id)
    {
        return new ResponseEntity<String>(service.deleteProductById(id),HttpStatus.OK);
    }

    //    @DeleteMapping("/deleteByName/{name}")
//    public  String deleteProductByName(@PathVariable String name)
//    {
//        return  service.deleteByProductName(name);
//    }





}
