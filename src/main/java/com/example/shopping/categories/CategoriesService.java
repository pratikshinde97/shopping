package com.example.shopping.categories;
import com.example.shopping.model.Response;
import com.example.shopping.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService{
    @Autowired
    private final CategoriesRepository repository;
    @Autowired
    private final ProductRepository productRepository;


    public CategoriesService(CategoriesRepository repository,ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository=productRepository;
    }

    public List<CategoriesDTO> findAll(Pageable pageRequest) {
        Page<Categories> categoriesList= repository.findAll(pageRequest);
        List<CategoriesDTO> categoriesDTOList=new ArrayList<>();
for(Categories categories:categoriesList){
    CategoriesDTO categoriesDTO=new CategoriesDTO();
    categoriesDTO.getDTO(categories);
    categoriesDTOList.add(categoriesDTO);
}
return  categoriesDTOList;
    }

    public CategoriesDTO findByCategoryId(String id) {
        CategoriesDTO categoriesDTO=new CategoriesDTO();
        repository.findById(id).ifPresent(categories -> {categoriesDTO.getDTO(categories);});
        return  categoriesDTO;
    }
//a
//    public String create(Categories resource,byte[] abc) {
//        // Response image = imagesUploadController.uploadFile(file);
//        // resource.setImageId(image.getId());
//        resource.setPicByte(abc);
//        return repository.save(resource);
//    }

    public CategoriesDTO  create(CategoriesDTO categoriesDTO) {
        return new CategoriesDTO(repository.save(categoriesDTO.getEntity(null)));
    }

    public String updateCategory(String id,CategoriesDTO resource) throws Exception {
        if (null == resource || resource.getId().isEmpty()) {
            throw new Exception("Category id is blank! it is required");
        }
        Categories categories=new Categories();
        categories=repository.findById(id).get();
        categories.setData(categories.getData());
        categories.setCgst(categories.getCgst());
        categories.setSgst(categories.getSgst());
        categories.setCategoryName(resource.getCategoryName()==null||resource.getCategoryName().isEmpty()?categories.getCategoryName():resource.getCategoryName());
        categories.setId(categories.getId());
        resource.getEntity(null);
        repository.save(categories);

        return "Category updated successfully!";
    }
    public String updateCategoryImage(String id,byte[] file) throws Exception {
        Categories categories=new Categories();
        categories= repository.findById(id).get();
        categories.setCategoryName(categories.getCategoryName());
        categories.setId(categories.getId());
        categories.setCgst(categories.getCgst());
        categories.setSgst(categories.getSgst());
        categories.setData(file);
          repository.save(categories);
        return "Category updated successfully!";
    }

    public String deleteById(String id) {
        String name=repository.findById(id).get().getCategoryName();
        productRepository.deleteByCategoryId(id);
        repository.deleteById(id);
        return String.format("Category %s is deleted", name);

    }
}
