package com.example.shopping.common;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface IController<T, K> {

    public List<T> findAll(@RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size);

    public T findById(@PathVariable("id") K id);

    public K create(@RequestBody T resource);

    public void update(@PathVariable("id") K id, @RequestBody T resource);

    public void delete(@PathVariable("id") K id);
}
