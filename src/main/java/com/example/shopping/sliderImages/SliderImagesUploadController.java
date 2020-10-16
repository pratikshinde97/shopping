package com.example.shopping.sliderImages;
import com.example.shopping.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class SliderImagesUploadController {

    @Autowired
    private SliderImagesService sliderImagesService;

    @PostMapping("/uploadSliderImage")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
        SliderImages sliderImages = sliderImagesService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(sliderImages.getFileName())
                .toUriString();

        return new Response(sliderImages.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadSliderImages")
    public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }
}