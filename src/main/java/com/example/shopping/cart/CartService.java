package com.example.shopping.cart;
import com.example.shopping.common.IService;
import com.example.shopping.deliveryCharges.DeliveryCharges;
import com.example.shopping.deliveryCharges.DeliveryChargesRepository;
import com.example.shopping.products.Product;
import com.example.shopping.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CartService implements IService<Cart, String> {

    private final CartRepository repository;
    @Autowired
    private final ProductRepository productRepository;
    private  final DeliveryChargesRepository deliveryChargesRepository;

    public CartService(CartRepository repository,ProductRepository productRepository,DeliveryChargesRepository deliveryChargesRepository) {
        this.repository = repository;
        this.productRepository=productRepository;
        this.deliveryChargesRepository=deliveryChargesRepository;
    }

    public Page<Cart> findAll(Pageable pageRequest) {
        return repository.findAll(pageRequest);

    }

    public Cart findById(String id) {
        return  repository.findById(id).orElse(null);
    }

    public String create(Cart resource) {
        int quantity=0;
        double price=0.0;
        double total=0.0;
        double preTotal=0.0;
        double grandTotal=0.0;
        double deliveryCharges=0.0;

        quantity=resource.getQuantity();
Product product=productRepository.findById(resource.getProductId()).get();
        System.out.println(product.getProductName());

       price= product.getProductPrice();
       System.out.println("Price"+price);

       total=quantity*price;
        System.out.println("total"+total);

        resource.setTotalPrice(total);
try{
    preTotal =repository.sumQuantities(resource.getCustomerId());
}catch (Exception ex)
{
    preTotal=0.0;
}

DeliveryCharges deliveryCharges1=new DeliveryCharges();
deliveryCharges1=deliveryChargesRepository.findAll().get(0);
deliveryCharges=deliveryCharges1.getDeliveryCharges();

    grandTotal=total+preTotal+deliveryCharges;

        System.out.println("preTotal"+preTotal);
        System.out.println("delivery"+deliveryCharges);
        System.out.println("grandTotal"+grandTotal);

        resource.setGrandTotal(grandTotal);
        return repository.save(resource).getId();
    }


    public void update(Cart resource) {
        repository.save(resource);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void deleteByCustomerIdAndProductId(String customerId,String productId) {
        repository.deleteByCustomerIdAndProductId(customerId,productId);
    }
    public void deleteByQuantity(int quantity) {
        repository.removeByQuantity(quantity);
    }

}
