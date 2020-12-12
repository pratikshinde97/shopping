package com.example.shopping.deliveryCharges;

import com.example.shopping.util.PageUtil;
import com.example.shopping.util.RestPreconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/api/deliveryCharges")
public class DeliveryChargesController{

    private final DeliveryChargesService service;
    public DeliveryChargesController(DeliveryChargesService deliveryChargesService) {
        this.service = deliveryChargesService;
    }


    @GetMapping(value = "/{page}/{size}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<DeliveryChargesDTO>> findAll(@RequestParam("page") Optional<Integer> page,
                                                       @RequestParam("size") Optional<Integer> size) {
        return new ResponseEntity<List<DeliveryChargesDTO>>(service.findAll(PageUtil.defaultPage(page,size)), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public DeliveryChargesDTO findById(@PathVariable("id") String id) {
        return RestPreconditions.checkFound(service.findByDeliveryChargesId(id));
    }




    @RequestMapping(value = "/create",method = RequestMethod.POST, consumes = { "application/json" })
    public ResponseEntity<DeliveryChargesDTO> create(@RequestBody DeliveryChargesDTO resource) throws Exception {

        DeliveryChargesDTO deli=new DeliveryChargesDTO();
        try {
            deli=service.create(resource);
        }catch (Exception e){
            return new ResponseEntity<DeliveryChargesDTO>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<DeliveryChargesDTO>(deli,HttpStatus.CREATED);
    }

    @PutMapping(value = "deliveryChargesById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateDelivery(@PathVariable( "id" ) String id,@RequestBody DeliveryChargesDTO resource) throws Exception {
        return new ResponseEntity<String>(service.updateDeliveryCharges(id,resource),HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String>  delete(@PathVariable("id") String id) {
        return new ResponseEntity<String>(service.deleteById(id),HttpStatus.OK);
    }
}
