package com.example.shopping.cart;

import com.example.shopping.common.IController;
import com.example.shopping.util.PageUtil;
import com.example.shopping.util.RestPreconditions;
import com.google.common.base.Preconditions;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartController implements IController<Cart, String> {

    private final CartService service;

    public CartController(CartService cartService) {
        this.service = cartService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Cart> findAll(@RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size) {
        Page<Cart> resultPage = service.findAll(PageUtil.defaultPage(page,size));
        /*if (page.orElse(PageUtil.DEFAULT_CURRENT_PAGE_NO) > resultPage.getTotalPages()) {
            throw new ResourceNotFoundException();
        }*/
        return resultPage.getContent();
    }

    @GetMapping(value = "/{id}")
    public Cart findById(@PathVariable("id") String id) {
        return RestPreconditions.checkFound(service.findById(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Cart resource) {
        Preconditions.checkNotNull(resource);
        return service.create(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) String id, @RequestBody Cart resource) {
        Preconditions.checkNotNull(resource);
        RestPreconditions.checkNotNull(service.findById(resource.getId()));
        service.update(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        service.deleteById(id);
    }

    @RequestMapping(value = "customerId/{customerId}/productId/{productId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteByCustomerIdAndProductId(@PathVariable("customerId") String customerId,@PathVariable("productId") String productId) {
        service.deleteByCustomerIdAndProductId(customerId,productId);
    }
    @RequestMapping(value = "/quantity/{quantity}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteByQuantity(@PathVariable("quantity") int quantity) {
        service.deleteByQuantity(quantity);
    }

}
