package com.example.shopping.user;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO create(UserDTO userDTO) {

        var user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return userDTO;

    }

    public User getUserById(String id){
        return  userRepository.findById(id).orElse(null);
    }

//    public User getUserByEmailAndPassword(String email,String password){
//        return userRepository.findByEmailAndPassword(email,password).orElse(null);
//      //  return "Login Successful";
//    }

    public UserDTO getUserByEmailAndPassword(String email,String password){
        var users = userRepository.findByEmailAndPassword(email, password);
        UserDTO userDTO = new UserDTO();
        User user=new User();
        user.setFirstName(users.get().getFirstName());
        user.setLastName(users.get().getLastName());
        user.setEmail(users.get().getEmail());
        System.out.println(users.get().getFirstName()+" "+users.get().getLastName());
           return userDTO.getUserDTOObject(user);

    }


    public  String deleteUserById(String id){
        userRepository.deleteById(id);
        return  " User Deleted!!";
    }

    public User findById(String id) {
        return  userRepository.findById(id).orElse(null);
    }

    public void update(String id,User resource) {
        User user=new User();
        User present=userRepository.findById(resource.getId()).orElse(null);
        resource.setId(id);
        user.setFirstName(resource.getFirstName());
        user.setLastName(resource.getLastName());
        user.setEmail(resource.getEmail());
        user.setPassword(resource.getPassword());
        user.setAddressLine1(resource.getAddressLine1());
        user.setAddressLine2(resource.getAddressLine2());
        user.setArea(resource.getArea());
        user.setCity(resource.getCity());
        user.setLandmark(resource.getLandmark());
        user.setPincode(resource.getPincode());
        userRepository.save(resource);
    }




}
