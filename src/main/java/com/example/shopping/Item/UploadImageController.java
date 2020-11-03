package com.example.shopping.Item;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/uploadImage")
class UploadImageController{
    UploadImage images;
    @Autowired
            UploadImageService service;
    UploadImageController(UploadImageService service){this.service=service;}
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public void upload(@Valid @RequestParam byte[] uploadImage) throws Exception {

        System.out.println("uploadImagedsssssssssssssssss"+uploadImage);
        service.save(images,uploadImage);
    }
}
