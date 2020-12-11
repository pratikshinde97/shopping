package com.example.shopping.deliveryCharges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryChargesService{
    @Autowired
    private final DeliveryChargesRepository repository;


    public DeliveryChargesService(DeliveryChargesRepository repository) {
        this.repository = repository;
    }

    public List<DeliveryChargesDTO> findAll(Pageable pageRequest) {
        Page<DeliveryCharges> deliveryChargesList= repository.findAll(pageRequest);
        List<DeliveryChargesDTO> deliveryChargesDTOS=new ArrayList<>();
        for(DeliveryCharges deliveryCharges:deliveryChargesList){
            DeliveryChargesDTO deliveryChargesDTO=new DeliveryChargesDTO();
            deliveryChargesDTO.getDTO(deliveryCharges);
            deliveryChargesDTOS.add(deliveryChargesDTO);
        }
        return  deliveryChargesDTOS;
    }


    public DeliveryChargesDTO findByDeliveryChargesId(String id) {
        DeliveryChargesDTO deliveryChargesDTO=new DeliveryChargesDTO();
        repository.findById(id).ifPresent(deliveries -> {deliveryChargesDTO.getDTO(deliveries);});
        return  deliveryChargesDTO;
    }
//
//    public String create(DeliveryCharges resource,byte[] abc) {
//        // Response image = imagesUploadController.uploadFile(file);
//        // resource.setImageId(image.getId());
//        resource.setPicByte(abc);
//        return repository.save(resource);
//    }

    public DeliveryChargesDTO  create(DeliveryChargesDTO deliveryChargesDTO) {
        return new DeliveryChargesDTO(repository.save(deliveryChargesDTO.getEntity(null)));
    }

    public String updateDeliveryCharges(String id,DeliveryChargesDTO resource) throws Exception {

        DeliveryCharges  del=new DeliveryCharges();
        del=repository.findById(id).get();
        del.setDeliveryCharges(resource.getDeliveryCharges()==0.0?del.getDeliveryCharges():resource.getDeliveryCharges());
        del.setUpto(resource.getUpto()==0.0?del.getUpto():resource.getUpto());
        resource.getEntity(null);
        repository.save(del);
        return "DeliveryCharges updated successfully!";
    }


    public String deleteById(String id) {
        double deliveryCharges=repository.findById(id).get().getDeliveryCharges();
        repository.deleteById(id);
        return String.format("DeliveryCharges %s is deleted", deliveryCharges);

    }


}
