package com.example.shopping.cart;

import com.example.shopping.common.IController;
import com.example.shopping.util.PageUtil;
import com.example.shopping.util.RestPreconditions;
import com.google.common.base.Preconditions;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService service;
    private final CartRepository cartRepository;


    public CartController(CartService cartService,CartRepository cartRepository) {
        this.service = cartService;this.cartRepository=cartRepository;
    }

    @GetMapping("/{page}/{size}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CartDTO>>findAll(@PathVariable("page") Optional<Integer> page,
                              @PathVariable("size") Optional<Integer> size) {
        return new ResponseEntity<List<CartDTO>>(service.findAll(PageUtil.defaultPage(page,size)), HttpStatus.OK);
        /*if (page.orElse(PageUtil.DEFAULT_CURRENT_PAGE_NO) > resultPage.getTotalPages()) {
            throw new ResourceNotFoundException();
        }*/
    }

    @GetMapping(value = "/{id}")
    public CartDTO findById(@PathVariable("id") String id) {
        return RestPreconditions.checkFound(service.findById(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CartDTO>  create(@RequestBody CartDTO resource) {
        Preconditions.checkNotNull(resource);
        service.create(resource);
        return new ResponseEntity<CartDTO>(resource,HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) String id, @RequestBody CartDTO resource) {
        Preconditions.checkNotNull(resource);
        RestPreconditions.checkNotNull(service.findById(resource.getId()));
        service.update(id,resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        service.deleteById(id);
    }

//    @DeleteMapping("/deleteFromCart")
//    public ResponseEntity<?> deleteProduct(@Valid @RequestBody Map<String,Object> userMap){
//        List<String> idList=(List<String>) userMap.get("id_list");
//        List<Cart> productList=(List<Cart>) cartRepository.findAllById(idList);
//        cartRepository.deleteAll(productList);
//        return ResponseEntity.status(HttpStatus.OK).body("Deleted item : "+idList);
//
//    }

//    @RequestMapping(value = "customerId/{customerId}/productId/{productId}",method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteByCustomerIdAndProductId(@PathVariable("customerId") String customerId,@PathVariable("productId") String productId) {
//        service.deleteByCustomerIdAndProductId(customerId,productId);
//    }
//    @RequestMapping(value = "/quantity/{quantity}",method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteByQuantity(@PathVariable("quantity") int quantity) {
//        service.deleteByQuantity(quantity);
//    }
//
//    @GetMapping(value = "customerId/{customerId}")
//    public void findAllByCustomerId(@PathVariable("customerId") String customerId) {
//         service.findAllByCustomerId(customerId);
//    }

}
