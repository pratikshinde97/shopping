package com.example.shopping.sliderImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SliderImagesService {
    @Autowired
    private final SliderImagesRepository repository;


    public SliderImagesService(SliderImagesRepository repository) {
        this.repository = repository;
    }

    public List<SliderImagesDTO> findAll(Pageable pageRequest) {
        Page<SliderImages> sliderImagesList= repository.findAll(pageRequest);
        List<SliderImagesDTO> sliderImagesDTOList =new ArrayList<>();
for(SliderImages sliderImages :sliderImagesList){
    SliderImagesDTO sliderImagesDTO =new SliderImagesDTO();
    sliderImagesDTO.getDTO(sliderImages);
    sliderImagesDTOList.add(sliderImagesDTO);
}
return sliderImagesDTOList;
    }

    public SliderImagesDTO findBySliderId(String id) {
        SliderImagesDTO sliderImagesDTO =new SliderImagesDTO();
        repository.findById(id).ifPresent(sliderImages -> {
            sliderImagesDTO.getDTO(sliderImages);});
        return sliderImagesDTO;
    }
//a
//    public String create(Categories resource,byte[] abc) {
//        // Response image = imagesUploadController.uploadFile(file);
//        // resource.setImageId(image.getId());
//        resource.setPicByte(abc);
//        return repository.save(resource);
//    }

    public SliderImagesDTO create(SliderImagesDTO sliderImagesDTO) {
        return new SliderImagesDTO(repository.save(sliderImagesDTO.getEntity(null)));
    }

    public String updateCategory(String id, SliderImagesDTO resource) throws Exception {
        if (null == resource || resource.getId().isEmpty()) {
            throw new Exception("Category id is blank! it is required");
        }
        SliderImages sliderImages =new SliderImages();
        sliderImages =repository.findById(id).get();
        sliderImages.setData(sliderImages.getData());
        sliderImages.setName(resource.getName()==null||resource.getName().isEmpty()? sliderImages.getName():resource.getName());
        sliderImages.setId(sliderImages.getId());
        resource.getEntity(null);
        repository.save(sliderImages);

        return "Slider updated successfully!";
    }
    public String updateSliderImage(String id,byte[] file) throws Exception {
        SliderImages sliderImages =new SliderImages();
        sliderImages = repository.findById(id).get();
        sliderImages.setName(sliderImages.getName());
        sliderImages.setId(sliderImages.getId());
        sliderImages.setData(file);
          repository.save(sliderImages);
        return "Slider updated successfully!";
    }

    public String deleteById(String id) {
        String name=repository.findById(id).get().getName();
        repository.deleteById(id);
        return String.format("Image %s is deleted", name);

    }


}
