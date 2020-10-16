package com.example.shopping.sliderImages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController
public class SliderImagesDownloadController {

    @Autowired
    private SliderImagesService sliderImagesService;

    @GetMapping("/downloadSliderImages/{fileName:.+}")
    public ResponseEntity<Resource> sliderImages(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        SliderImages sliderImages = sliderImagesService.getFile(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(sliderImages.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + sliderImages.getFileName() + "\"")
                .body(new ByteArrayResource(sliderImages.getData()));
    }

}