package com.example.shopping.categories;
import com.example.shopping.util.PageUtil;
import com.example.shopping.util.RestPreconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.base.Preconditions;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Slf4j
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
    public ResponseEntity<List<CategoriesDTO>> findAll(@RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size) {
        return new ResponseEntity<List<CategoriesDTO>>(service.findAll(PageUtil.defaultPage(page,size)), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public CategoriesDTO findById(@PathVariable("id") String id) {
        return RestPreconditions.checkFound(service.findByCategoryId(id));
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<CategoriesDTO> create(@RequestPart CategoriesDTO resource,@RequestPart("imageFile") MultipartFile file) throws IOException {
        Preconditions.checkNotNull(resource,file.getBytes());

        CategoriesDTO cat=new CategoriesDTO();
        try {
            cat=service.create(resource,file.getBytes());
        }catch (Exception e){
            String message = String.format("Category Already Exist " + resource.getCategoryName());
            log.error(message);
            return new ResponseEntity<CategoriesDTO>(HttpStatus.CONFLICT);

        }
        return new ResponseEntity<CategoriesDTO>(cat,HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.PUT, consumes = { "multipart/form-data" })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateCategory(@PathVariable( "id" ) String id,@RequestPart CategoriesDTO resource,@RequestPart ("imageFile") MultipartFile file ) throws Exception {
        resource.setData(file.getBytes());
        System.out.println(resource.getId()+" "+resource.getCategoryName());
        return new ResponseEntity<String>(service.updateCategory(resource),HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}",method = RequestMethod.PUT, consumes = { "multipart/form-data" })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> update(@PathVariable( "id" ) String id,@RequestPart ("imageFile") MultipartFile file ) throws Exception {
        return new ResponseEntity<String>(service.updateCategoryImage(id,file.getBytes()),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String>  delete(@PathVariable("id") String id) {
        return new ResponseEntity<String>(service.deleteById(id),HttpStatus.OK);
    }
}
