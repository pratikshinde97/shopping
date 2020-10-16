package com.example.shopping.sliderImages;

import java.io.IOException;
import com.example.shopping.exception.FileNotFoundException;
import com.example.shopping.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class SliderImagesService {

    @Autowired
    private SliderImagesRepository sliderImagesRepository;

    public SliderImages storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            SliderImages dbFile = new SliderImages(fileName, file.getContentType(), file.getBytes());

            return sliderImagesRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public SliderImages getFile(String fileId) {
        return sliderImagesRepository.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }
}