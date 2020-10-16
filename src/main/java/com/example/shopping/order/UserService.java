//package com.example.shopping.order;
//
//import com.whizit.eagle.controller.IService;
//import com.whizit.eagle.vehicle.VehicleRepository;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService implements IService<User, String> {
//
//    private final UserRepository repository;
//    private final VehicleRepository vehicleRepository;
//
//    public UserService(UserRepository repository, VehicleRepository vehicleRepository) {
//        this.repository = repository;
//        this.vehicleRepository = vehicleRepository;
//    }
//
//    public Page<User> findAll(Pageable pageRequest) {
//        return repository.findAll(pageRequest);
//
//    }
//
//    public User findById(String id) {
//       return  repository.findById(id).orElse(null);
//    }
//
//    public String create(User resource) {
//        return repository.save(resource).getId();
//    }
//
//    public void update(User resource) {
//        repository.save(resource);
//    }
//
//    public void deleteById(String id) {
//        repository.deleteById(id);
//    }
//}
