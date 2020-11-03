package com.example.shopping.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UploadImageService {

    @Autowired
    private UploadImageRepository imagesRepository;

    public void save(UploadImage image,byte[] file) {
        image.setData(file);
        System.out.println("datata"+image.getData());
        imagesRepository.save(image);
    }
}