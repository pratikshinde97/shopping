package com.example.shopping.categories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Categories, String> {


//    List<Categories> findAllCategories(Pageable pageRequest);

}
