//package com.example.shopping.savedCartItem;
//
//import com.example.shopping.common.IController;
//import com.example.shopping.util.PageUtil;
//import com.example.shopping.util.RestPreconditions;
//import com.google.common.base.Preconditions;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/cartitem")
//public class CartItemController implements IController<CartItem, String> {
//
//    private final CartItemService service;
//
//    public CartItemController(CartItemService cartItemService) {
//        this.service = cartItemService;
//    }
//
//    @GetMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public List<CartItem> findAll(@RequestParam("page") Optional<Integer> page,
//                              @RequestParam("size") Optional<Integer> size) {
//        Page<CartItem> resultPage = service.findAll(PageUtil.defaultPage(page,size));
//        /*if (page.orElse(PageUtil.DEFAULT_CURRENT_PAGE_NO) > resultPage.getTotalPages()) {
//            throw new ResourceNotFoundException();
//        }*/
//        return resultPage.getContent();
//    }
//
//    @GetMapping(value = "/{id}")
//    public CartItem findById(@PathVariable("id") String id) {
//        return RestPreconditions.checkFound(service.findById(id));
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public String create(@RequestBody CartItem resource) {
//        Preconditions.checkNotNull(resource);
//        return service.create(resource);
//    }
//
//    @PutMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void update(@PathVariable( "id" ) String id, @RequestBody CartItem resource) {
//        Preconditions.checkNotNull(resource);
//        RestPreconditions.checkNotNull(service.findById(resource.getId()));
//        service.update(resource);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void delete(@PathVariable("id") String id) {
//        service.deleteById(id);
//    }
//
//}
