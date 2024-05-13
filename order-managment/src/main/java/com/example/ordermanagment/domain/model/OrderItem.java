package com.example.ordermanagment.domain.model;

import com.example.ordermanagment.domain.valueObject.RestorantId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Entity
@Table(name = "order_item")
public class OrderItem extends AbstractEntity<OrderItemId> {


    private Money itemPrice;


    @Column(name = "qty", nullable = false)
    private int quantity;

    @AttributeOverride(name = "id", column = @Column(name = "restorant_id",
            nullable = false))
    private RestorantId restorantId;

    public OrderItem(Object randomId) {
        super(randomId);
    }

    public OrderItem() {
        super("");
    }

    public Money subtotal() {
        return itemPrice.multiply(quantity);
    }


}