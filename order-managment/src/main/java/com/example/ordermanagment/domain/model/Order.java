package com.example.ordermanagment.domain.model;

import jakarta.persistence.*;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.time.Instant;
import java.util.Set;

import static com.example.ordermanagment.domain.model.OrderId.*;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity<OrderId> {
    private Instant datum;

    private Money total;

    @Column(name="order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList;

    public Order(Object randomId) {
        super(randomId);
    }

    public Order() {
        super("");
    }


    public Money total() {
        return orderItemList.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0), Money::add);
    }


}
