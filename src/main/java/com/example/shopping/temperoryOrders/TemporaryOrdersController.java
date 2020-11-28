package com.example.shopping.temperoryOrders;


import com.example.shopping.common.IController;
import com.example.shopping.order.Orders;
import com.example.shopping.util.PageUtil;
import com.example.shopping.util.RestPreconditions;
import com.google.common.base.Preconditions;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/temporaryorders")
public class TemporaryOrdersController implements IController<TemporaryOrders, String> {

    private final TemporaryOrdersService service;

    public TemporaryOrdersController(TemporaryOrdersService userService) {
        this.service = userService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TemporaryOrders> findAll(@RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size) {
        Page<TemporaryOrders> resultPage = service.findAll(PageUtil.defaultPage(page,size));
        /*if (page.orElse(PageUtil.DEFAULT_CURRENT_PAGE_NO) > resultPage.getTotalPages()) {
            throw new ResourceNotFoundException();
        }*/
        return resultPage.getContent();
    }

    @GetMapping(value = "/{id}")
    public TemporaryOrders findById(@PathVariable("id") String id) {
        return RestPreconditions.checkFound(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody TemporaryOrders resource) {
        Preconditions.checkNotNull(resource);
        return service.create(resource);
    }
    @PostMapping("/addOrders")
    public List<TemporaryOrders> addProducts(@RequestBody List<TemporaryOrders> orders){
        return  service.saveOrders(orders);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) String id, @RequestBody TemporaryOrders resource) {
        Preconditions.checkNotNull(resource);
        RestPreconditions.checkNotNull(service.findById(resource.getId()));
        service.update(resource);
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        service.deleteById(id);
    }

    @GetMapping(value = "customerId/{customerId}")
    public void findAllByCustomerId(@PathVariable("customerId") String customerId) {
        service.findAllByCustomerId(customerId);
    }

}
