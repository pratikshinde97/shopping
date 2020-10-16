package com.example.shopping.categories;
import com.example.shopping.util.PageUtil;
import com.example.shopping.util.RestPreconditions;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.google.common.base.Preconditions;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController{

    private final CategoriesService service;
private final CategoriesRepository repository;
    public CategoriesController(CategoriesService categoriesService,CategoriesRepository repository) {
        this.service = categoriesService;
        this.repository=repository;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Categories> findAll(@RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size) {
        Page<Categories> resultPage = service.findAll(PageUtil.defaultPage(page,size));
        /*if (page.orElse(PageUtil.DEFAULT_CURRENT_PAGE_NO) > resultPage.getTotalPages()) {
            throw new ResourceNotFoundException();
        }*/
        return resultPage.getContent();
    }

    @GetMapping(value = "/{id}")
    public Categories findById(@PathVariable("id") String id) {
        return RestPreconditions.checkFound(service.findById(id));
    }


//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public String create(@RequestBody Categories resource) {
//        Preconditions.checkNotNull(resource);
//        return service.create(resource);
//    }
private byte[] bytes;
   private byte[] abc;

    @PostMapping("/upload")
public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
     this.bytes = file.getBytes();

}

    @PostMapping("/add")
    public void createBook(@RequestBody Categories categories) throws IOException {
        categories.setPicByte(this.bytes);
        repository.save(categories);
    }



    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) String id, @RequestBody Categories resource) {
        Preconditions.checkNotNull(resource);
        RestPreconditions.checkNotNull(service.findById(resource.getId()));
        service.update(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        service.deleteById(id);
    }
}
