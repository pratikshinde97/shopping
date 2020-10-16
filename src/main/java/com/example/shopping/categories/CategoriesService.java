package com.example.shopping.categories;
import com.example.shopping.images.ImagesUploadController;
import com.example.shopping.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService{

    private final CategoriesRepository repository;

    @Autowired
    private ImagesUploadController imagesUploadController;

    public CategoriesService(CategoriesRepository repository) {
        this.repository = repository;
    }

    public Page<Categories> findAll(Pageable pageRequest) {
        return repository.findAll(pageRequest);

    }

    public Categories findById(String id) {
        return  repository.findById(id).orElse(null);
    }
//
//    public String create(Categories resource,byte[] abc) {
//        // Response image = imagesUploadController.uploadFile(file);
//        // resource.setImageId(image.getId());
//        resource.setPicByte(abc);
//        return repository.save(resource);
//    }

//    public CategoriesDTO create(CategoriesDTO categoriesDTO) {
//        return new CategoriesDTO(repository.save(categoriesDTO.getEntity(null)));
//    }

    public void update(Categories resource) {
        repository.save(resource);
    }

    public String updateCategories(CategoriesDTO categoriesDTO) throws Exception {
        if (null == categoriesDTO || null!=categoriesDTO.getId() && categoriesDTO.getId().isEmpty()) {
            throw new Exception("categories id is blank! it is required");
        }
        repository.findById(categoriesDTO.getId()).ifPresent((supplier) -> {
            supplier.getCategoryName();
            supplier = categoriesDTO.getEntity(supplier);
            repository.save(supplier);
        });
        return String.format("categories %s updated successfully!!", categoriesDTO.getId());
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

}
