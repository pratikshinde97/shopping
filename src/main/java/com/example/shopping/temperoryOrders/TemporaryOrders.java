package com.example.shopping.temperoryOrders;
import com.example.shopping.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TEMPORARY_ORDERS")
@Getter
@Setter
public
class TemporaryOrders extends BaseEntity {

    @Column(name = "CUSTOMER_ID")
    private  String customerId;

    @Column(name = "ORDER_STATUS")
    private TemporaryOrderStatus temporaryOrderStatus;

    @Column(name = "CREATED_DATE")
    private  Date createdDate;

    @Column(name = "COMPLETED_DATE")
    private  Date completedDate;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "TOTAL_PRICE")
    private double totalPrice;

    @Column(name = "GRAND_TOTAL")
    private double grandTotal;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "TAX_TOTAL")
    private double taxTotal;

}
