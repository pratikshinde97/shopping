package com.example.shopping.user;

import com.example.shopping.util.RestPreconditions;
import com.google.common.base.Preconditions;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userManageService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<UserDTO> create( @RequestBody UserDTO userDTO) {
        UserDTO res = new UserDTO();
        try {
            res = userManageService.create(userDTO);
        } catch (Exception e) {
            e.printStackTrace();
            String message = String.format("User Already Exist " + userDTO.getEmail());
            log.error(message);
            return new ResponseEntity<UserDTO>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<UserDTO>(res, HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.GET, value="/{email}/{password}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "email" , required = true) String email,
                                           @PathVariable(name = "password" , required = true) String password) {

        var res = new UserDTO();
        try {
            System.out.println("controler    calll");

           res= userManageService.getUserByEmailAndPassword(email, password);
            System.out.println("email"+email+"password"+password);
        } catch (Exception e) {
            log.error("A user not found with email" + email);
            return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<UserDTO>(res, HttpStatus.OK);

    }


    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") String id) {
        Preconditions.checkNotNull(id);
        return RestPreconditions.checkFound(userManageService.findById(id));
    }



    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) String id, @RequestBody User resource) {
        Preconditions.checkNotNull(id,resource);
        RestPreconditions.checkNotNull(userManageService.findById(resource.getId()));
        userManageService.update(id,resource);
    }



//    @DeleteMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void delete(@PathVariable("id") String id) {
//        userManageService.deleteById(id);
//   }

//    @DeleteMapping(value = "/{name}")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteByName(@PathVariable("id") String name) {
//        userManageService.deleteByName(name);
//    }


}
