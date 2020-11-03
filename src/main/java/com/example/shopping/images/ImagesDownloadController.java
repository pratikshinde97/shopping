//package com.example.shopping.images;
//
//import com.google.common.base.Preconditions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//@RequestMapping("/api/uploadimages")
//@RestController
//public class ImagesDownloadController {
//    ImagesUpload images;
//    @Autowired
//    private ImagesService fileStorageService;
//
//    @RequestMapping(value = "/upload",method = RequestMethod.POST,consumes = { "multipart/form-data" })
//    public void upload(@Valid @RequestPart("imageFile") MultipartFile file) throws Exception {
//        Preconditions.checkNotNull(file.getBytes());
//        images.setFile1(file.getBytes());
//fileStorageService.save(images);
//    }
//
//}