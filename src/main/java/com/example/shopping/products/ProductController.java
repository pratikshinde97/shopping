package com.example.shopping.products;
import com.example.shopping.Item.Candidate;
import com.example.shopping.Item.FileUploadUtil;
import com.example.shopping.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/addProduct")
    public Products addProduct(@RequestBody Products product){
        return  service.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Products> addProducts(@RequestBody List<Products> products){
        return  service.saveProducts(products);
    }
//Products product;

    @RequestMapping(value = "/uploadProduct", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public String handleFormSubmit(@RequestParam("product")  Products product,
                                     @RequestParam("profilePictureFile") MultipartFile multipartFile1,
                                     @RequestParam("photoIdFile") MultipartFile multipartFile2,
                                     @RequestParam("documentFile") MultipartFile multipartFile3) throws IOException {

        String profilePictureFileName = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
        String photoIdFileName = StringUtils.cleanPath(multipartFile2.getOriginalFilename());
        String documentFileName = StringUtils.cleanPath(multipartFile3.getOriginalFilename());

        product.setProfilePicture(profilePictureFileName);
        product.setPhotoId(photoIdFileName);
        product.setDocument(documentFileName);
System.out.println(product.getProductName());
        Products savedCandidate = service.save(product);
        String uploadDir = "candidates/" + savedCandidate.getId();

        FileUploadUtil.saveFile(uploadDir, profilePictureFileName, multipartFile1);
        FileUploadUtil.saveFile(uploadDir, photoIdFileName, multipartFile2);
        FileUploadUtil.saveFile(uploadDir, documentFileName, multipartFile3);

        return "message";
    }


    @GetMapping("/products")
    public List<Products> findAll(@RequestParam("page") Optional<Integer> page,
                                       @RequestParam("size") Optional<Integer> size) {
        Page<Products> resultPage = service.getAllProducts(PageUtil.defaultPage(page,size));
        /*if (page.orElse(PageUtil.DEFAULT_CURRENT_PAGE_NO) > resultPage.getTotalPages()) {
            throw new ResourceNotFoundException();
        }*/
        return resultPage.getContent();
    }

    @GetMapping("/productById/{id}")
    public  Products getProductById(@PathVariable int id){
        return  service.getProductById(id);
    }
//    @GetMapping("/productByName/{name}")
//    public Products getProductByName(@PathVariable String name){
//        return  service.getProductByName(name);
//    }
    @PutMapping("/productById/{id}")
    public  Products updateProductById(@PathVariable int id, @RequestBody Products product){
        System.out.println("id"+id);
        return  service.updateProductById(id,product);
    }
//    @PutMapping("/productByNameAndPrice/{name}/{price}")
//    public  Products updateProductByNameAndPrice(@PathVariable int id,@PathVariable String name, @RequestBody Products product){
//        System.out.println("id"+id);
//        return  service.updateProductByNameAndPrice(id,name,product);
//    }

    @DeleteMapping("/deleteById/{id}")
    public  String deleteProductById(@PathVariable int id)
    {
         return  service.deleteProductById(id);
    }
//    @DeleteMapping("/deleteByName/{name}")
//    public  String deleteProductByName(@PathVariable String name)
//    {
//        return  service.deleteByProductName(name);
//    }


}
