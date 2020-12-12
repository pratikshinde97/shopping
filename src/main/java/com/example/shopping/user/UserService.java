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
        user.setPincode(userDTO.getPincode());
        user.setMobileNumber(userDTO.getMobileNumber());
        user.setAddressLine1(userDTO.getAddressLine1());
        user.setAddressLine2(userDTO.getAddressLine2());
        user.setArea(userDTO.getArea());
        user.setCity(userDTO.getCity());
        user.setPassword(userDTO.getPassword());
        user.setState(userDTO.getState());
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
        User users = userRepository.findByEmailAndPassword(email, password);
        UserDTO userDTO = new UserDTO();
        User user=new User();
        System.out.println(users.getEmail()+" "+users.getPassword());

        user.setEmail(users.getEmail());
        user.setPassword(users.getPassword());
        user.setId(users.getId());

        System.out.println(user.getEmail()+" "+user.getPassword());
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
         user=userRepository.findById(id).get();

        resource.setId(id);

        user.setFirstName(resource.getFirstName()==null||resource.getFirstName().isEmpty()?user.getFirstName():resource.getFirstName());
        user.setLastName(resource.getLastName()==null||resource.getLastName().isEmpty()?user.getLastName():resource.getLastName());
        user.setEmail(resource.getEmail()==null||resource.getEmail().isEmpty()?user.getEmail():resource.getEmail());
        user.setPassword(resource.getPassword()==null||resource.getPassword().isEmpty()?user.getPassword():resource.getPassword());
        user.setAddressLine1(resource.getAddressLine1()==null||resource.getAddressLine1().isEmpty()?user.getAddressLine1():resource.getAddressLine1());
        user.setAddressLine2(resource.getAddressLine2()==null||resource.getAddressLine2().isEmpty()?user.getAddressLine2():resource.getAddressLine2());
        user.setArea(resource.getArea()==null||resource.getArea().isEmpty()?user.getArea():resource.getArea());
        user.setCity(resource.getCity()==null||resource.getCity().isEmpty()?user.getCity():resource.getCity());
        user.setLandmark(resource.getLandmark()==null||resource.getLandmark().isEmpty()?user.getLandmark():resource.getLandmark());
        user.setPincode(resource.getPincode()==null||resource.getPincode().isEmpty()?user.getPincode():resource.getPincode());
        user.setMobileNumber(resource.getMobileNumber()==null||resource.getMobileNumber().isEmpty()?user.getMobileNumber():resource.getMobileNumber());
        user.setState(resource.getState()==null||resource.getState().isEmpty()?user.getState():resource.getState());

        userRepository.save(user);
    }

    public String updateEmail(String id,String email) {
        User user=new User();
         user=userRepository.findById(id).get();
         user.setEmail(email);
        userRepository.save(user);
        return  "Email Updated";
    }
    public String updatePassword(String email,String password) {
        User user=new User();
        user=userRepository.findByEmail(email).get();
        user.setPassword(password);
        userRepository.save(user);
        return  "Password Updated";
    }





}
