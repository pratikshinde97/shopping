//package com.example.shopping.images;
//import com.example.shopping.model.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/imagesupload")
//
//public class ImagesUploadController {
//
//    @Autowired
//    private ImagesService imagesService;
//
//
////    @PostMapping("/uploadFile")
////    public com.example.shopping.model.Response uploadFile(@RequestParam("file") MultipartFile file) {
////        Images fileName = imagesService.storeFile(file);
////
////        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
////                .path("/downloadFile/")
////                .path(fileName.getFileName())
////                .toUriString();
////
////        return new Response(fileName.getId(),fileName.getFileName(), fileDownloadUri,
////                file.getContentType(), file.getSize());
////    }
////
////    @PostMapping("/uploadMultipleFiles")
////    public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
////        return Arrays.asList(files)
////                .stream()
////                .map(file -> uploadFile(file))
////                .collect(Collectors.toList());
////    }
//
//    @PostMapping("/add")
//    public void createBook(@RequestBody Images imges,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2) throws IOException {
//        imges.setFile1(file1.getBytes());
//        imges.setFile2(file2.getBytes());
//        imagesService.save(imges);
//    }
//
//
//
//}