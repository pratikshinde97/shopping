//package com.example.shopping.order;
//
//
//import com.google.common.base.Preconditions;
//import com.whizit.eagle.controller.IController;
//import com.whizit.eagle.util.PageUtil;
//import com.whizit.eagle.util.RestPreconditions;
//import io.swagger.annotations.*;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/user")
//@Api(description = "User Endpoint : Creating, Retrieving, Updating and Deleting of User.")
//public class UserController implements IController<User, String>{
//
//    private final UserService service;
//
//    public UserController(UserService userService) {
//        this.service = userService;
//    }
//
//    @GetMapping()
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation("Returns list of all User.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    }
//    )
//    public List<User> findAll(@ApiParam("Index of the Page.") @RequestParam("page") Optional<Integer> page,
//                              @ApiParam("Page size: number of item per page.") @RequestParam("size") Optional<Integer> size) {
//        Page<User> resultPage = service.findAll(PageUtil.defaultPage(page,size));
//        /*if (page.orElse(PageUtil.DEFAULT_CURRENT_PAGE_NO) > resultPage.getTotalPages()) {
//            throw new ResourceNotFoundException();
//        }*/
//        return resultPage.getContent();
//    }
//
//    @GetMapping(value = "/{id}")
//    @ApiOperation("Returns a specific User by their identifier. 404 if does not exist.")
//    public User findById(@ApiParam("Returns a specific User by their identifier. 404 if does not exist.") @PathVariable("id") String id) {
//        return RestPreconditions.checkFound(service.findById(id));
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    @ApiOperation("Creates a new User.")
//    public String create(@ApiParam("User information for a new User to be created.") @RequestBody User resource) {
//        Preconditions.checkNotNull(resource);
//        return service.create(resource);
//    }
//
//    @PutMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void update(@ApiParam("Update a specific User by their identifier. 404 if does not exist.")@PathVariable( "id" ) String id, @RequestBody User resource) {
//        Preconditions.checkNotNull(resource);
//        RestPreconditions.checkNotNull(service.findById(resource.getId()));
//        service.update(resource);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation("Deletes a User from the system. 404 if the User's identifier is not found.")
//    public void delete(@ApiParam("Id of the User to be deleted. Cannot be empty.") @PathVariable("id") String id) {
//        service.deleteById(id);
//    }
//}
