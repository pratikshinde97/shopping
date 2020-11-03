package com.example.shopping.cart;
import com.example.shopping.common.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CartItemService implements IService<CartItem, String> {

    private final CartItemRepository repository;

    public CartItemService(CartItemRepository repository) {
        this.repository = repository;
    }

    public Page<CartItem> findAll(Pageable pageRequest) {
        return repository.findAll(pageRequest);

    }

    public CartItem findById(String id) {
        return  repository.findById(id).orElse(null);
    }

    public String create(CartItem resource) {
        return repository.save(resource).getId();
    }

    public void update(CartItem resource) {
        repository.save(resource);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

}
