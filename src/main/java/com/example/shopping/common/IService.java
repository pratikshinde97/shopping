package com.example.shopping.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService<R,K> {
	
	public Page<R> findAll(Pageable pageRequest) ;
    public R findById(K id) ;
    public K create(R resource) ;
    public void update(R resource) ;
    public void deleteById(K id) ;

}
