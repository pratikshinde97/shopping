package com.example.shopping.user;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String>{

//    Optional<List<User>> findByFirstName(final String username);


   Optional <User> findByEmail(String email);

//    Optional<User> findUserDetals(final String email, final String password);


//    Optional<List<User>> findByUserNameOrEmail(final String username, final String email);


    User findByEmailAndPassword(String email, String password);
}
