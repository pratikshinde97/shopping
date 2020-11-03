package com.example.shopping.dailysales;

import com.example.shopping.common.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DailySalesService implements IService<DailySales,String> {

    @Override
    public Page<DailySales> findAll(Pageable pageRequest) {
        return null;
    }

    @Override
    public DailySales findById(String id) {
        return null;
    }

    @Override
    public String create(DailySales resource) {
        return null;
    }

    @Override
    public void update(DailySales resource) {

    }

    @Override
    public void deleteById(String id) {

    }
}
