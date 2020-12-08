package com.example.shopping.cart;

import com.example.shopping.categories.CategoriesRepository;
import com.example.shopping.common.IService;
import com.example.shopping.deliveryCharges.DeliveryCharges;
import com.example.shopping.deliveryCharges.DeliveryChargesRepository;
import com.example.shopping.products.Product;
import com.example.shopping.products.ProductRepository;
import com.example.shopping.temperoryOrders.TemporaryOrderStatus;
import com.example.shopping.temperoryOrders.TemporaryOrders;
import com.example.shopping.temperoryOrders.TemporaryOrdersRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartService  {

    private final CartRepository repository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private  final DeliveryChargesRepository deliveryChargesRepository;
    private  final TemporaryOrdersRepository temporaryOrdersRepository;
    private final CategoriesRepository categoriesRepository;
    public CartService(CartRepository repository,ProductRepository productRepository,DeliveryChargesRepository deliveryChargesRepository,TemporaryOrdersRepository temporaryOrdersRepository,CategoriesRepository categoriesRepository) {
        this.repository = repository;
        this.productRepository=productRepository;
        this.deliveryChargesRepository=deliveryChargesRepository;
        this.temporaryOrdersRepository=temporaryOrdersRepository;
        this.categoriesRepository=categoriesRepository;
    }



    public List<CartDTO> findAll(Pageable pageRequest) {
        Page<Cart> cartList= repository.findAll(pageRequest);
        List<CartDTO> cartDTOList=new ArrayList<>();
        for(Cart cart:cartList){
            CartDTO cartDTO=new CartDTO();
            cartDTO.getDTO(cart);
            cartDTOList.add(cartDTO);
        }
        return  cartDTOList;
    }

    public CartDTO findById(String id) {
        CartDTO cartDTO=new CartDTO();
        repository.findById(id).ifPresent(cart -> {cartDTO.getDTO(cart);});
        return  cartDTO;    }


    public CartDTO  create(CartDTO cartDTO) {
        return new CartDTO(repository.save(cartDTO.getEntity(null)));
    }

//    public String create(Cart resource) {
//        List<Cart> cartItems=repository.findAllByCustomerId(resource.getCustomerId());
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Date date = new Date();
//
//        int quantity=0;
//        double price=0.0;
//        double total=0.0;
//        double preTotal=0.0;
//        double grandTotal=0.0;
//        double deliveryCharges=0.0;
//        double cgst=0.0;
//        double sgst=0.0;
//        double taxTotal=0.0;
//
//        quantity=resource.getQuantity();
//
//        Product product=productRepository.findById(resource.getProductId()).get();
//        System.out.println(product.getProductName());
//
//        price= product.getSalePrice();
//        System.out.println("Price"+price);
//
//
//        cgst=price/100*categoriesRepository.findById(product.getCategoryId()).get().getCgst();
//        sgst=price/100*categoriesRepository.findById(product.getCategoryId()).get().getSgst();
//
//        total=quantity*price;
//        System.out.println("total"+total);
//        resource.setTotalPrice(total);
//
//        taxTotal=total+cgst+sgst;
//        System.out.println("taxTotal"+taxTotal);
//        resource.setTaxTotal(taxTotal);
//resource.setCreatedDate(new Date(formatter.format(date)));
//        try{
//    preTotal =repository.sumQuantities(resource.getCustomerId());
//}catch (Exception ex)
//{
//    preTotal=0.0;
//}
//
////try{
////    DeliveryCharges deliveryCharges1=new DeliveryCharges();
////
////    deliveryCharges1=deliveryChargesRepository.findAll().get(0);
////    deliveryCharges=deliveryCharges1.getDeliveryCharges();
////
////}
////catch (Exception e)
////{
////    System.out.println("please set delivery charges");
////    deliveryCharges=0;
////}
//
//
//    grandTotal=taxTotal+preTotal;
//
//        System.out.println("preTotal"+preTotal);
////        System.out.println("delivery"+deliveryCharges);
//        System.out.println("grandTotal"+grandTotal);
//        System.out.println("cgst"+cgst);
//        System.out.println("sgst"+sgst);
//
//        resource.setGrandTotal(grandTotal);
//        return repository.save(resource).getId();
//    }
//

    public void update(String id,CartDTO resource) {
        Cart cart=new Cart();
        cart=repository.findById(id).get();
        cart.setId(resource.getId());
        cart.setCustomerId(resource.getCustomerId()==null?cart.getCustomerId():resource.getCustomerId());
        cart.setProductId(resource.getProductId()==null?cart.getProductId():resource.getProductId());
        cart.setQuantity(resource.getQuantity()==0?cart.getQuantity():resource.getQuantity());
        resource.getEntity(null);
        repository.save(cart);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

//    public void deleteByCustomerIdAndProductId(String customerId,String productId) {
//        repository.deleteByCustomerIdAndProductId(customerId,productId);
//    }

//    public CartDTO findAllByCustomerId(String customerId) {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Date date = new Date();
//        List<TemporaryOrders> orders=new ArrayList<>();
//        TemporaryOrders temporaryOrders;
//        List<Cart> carts= repository.findAllByCustomerId(customerId);
//
//        List<DeliveryCharges> deliveryCharges=deliveryChargesRepository.findAll();
//
//        double total=0;
//        var sum=repository.sumQuantities(customerId);
//        if(sum<deliveryCharges.get(0).getUpto())
//        {
//            total=deliveryCharges.get(0).getDeliveryCharges();
//        }
//
//
//      for (int i=0;i<carts.size();i++)
//      {
//          temporaryOrders=new TemporaryOrders();
//          temporaryOrders.setCustomerId(customerId);
//          temporaryOrders.setProductId(carts.get(i).getProductId());
//          temporaryOrders.setCreatedDate(new Date(formatter.format(date)));
//          temporaryOrders.setTemporaryOrderStatus(TemporaryOrderStatus.NEW);
//          temporaryOrders.setQuantity();
//          temporaryOrders.setTotalPrice(carts.get(i).getTotalPrice());
//          temporaryOrders.setGrandTotal(sum+total);
//          temporaryOrders.setTaxTotal(carts.get(i).getTaxTotal());
//          orders.add(temporaryOrders);
//          System.out.println("temporaryOrders.setProductId(carts.get(i).getProductId());"+carts.get(i).getProductId());
//      }
//      temporaryOrdersRepository.saveAll(orders);
//    }


//    void  deleteByProductId(String productId)
//    {
//        repository.deleteByProductId(productId);
//    }

}
