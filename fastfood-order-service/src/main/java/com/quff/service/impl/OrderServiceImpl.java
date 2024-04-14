package com.quff.service.impl;

import com.quff.model.Order;
import com.quff.repository.OrderRepository;
import com.quff.service.abs.OrderService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;

import java.util.Date;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Inject
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean createOrder(Order order) {
        System.out.println(order);
        if (order != null) {
            float totalPrice = (float) order.getDescription().stream()
                    .mapToDouble(mealInfo -> mealInfo.getMeal().getPrice() * mealInfo.getQuantity())
                            .sum();
            orderRepository.persist(
                    Order.builder()
                            .description(order.getDescription())
                            .totalPrice(totalPrice)
                            .createdAt(new Date())
                            .build()
            );
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteOrder(String id) {
        if (id != null && !id.isBlank()) {
            orderRepository.deleteById(new ObjectId(id));
            return true;
        }
        return false;
    }

}
