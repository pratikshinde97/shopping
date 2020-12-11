package com.example.shopping.order;


import com.example.shopping.common.IController;
import com.example.shopping.util.PageUtil;
import com.example.shopping.util.RestPreconditions;
import com.google.common.base.Preconditions;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrdersService service;

    public OrdersController(OrdersService userService) {
        this.service = userService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Orders> findAll(@RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size) {
        Page<Orders> resultPage = service.findAll(PageUtil.defaultPage(page,size));
        /*if (page.orElse(PageUtil.DEFAULT_CURRENT_PAGE_NO) > resultPage.getTotalPages()) {
            throw new ResourceNotFoundException();
        }*/
        return resultPage.getContent();
    }

    @GetMapping(value = "/{id}")
    public Orders findById( @PathVariable("id") String id) {
        return RestPreconditions.checkFound(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Orders resource) {
        Preconditions.checkNotNull(resource);
        return service.create(resource);
    }
    @PostMapping("/addOrders")
    public List<Orders> addProducts(@RequestBody List<Orders> orders){
        return  service.saveOrders(orders);
    }

    @PutMapping(value = "/{id}/{status}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) String id,OrderStatus status) {
        service.update(id,status);
    }

//    @PutMapping(value = "/{id}/{date}")
//    @ResponseStatus(HttpStatus.OK)
//    public void updateOrder(@PathVariable( "id" ) String id, @PathVariable( "date" ) Date date, @RequestBody List<Orders> resource) {
//        Preconditions.checkNotNull(resource);
//        service.updateOrder(resource);
//    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        service.deleteById(id);
    }



}
