package com.quff.service.abs;

import com.quff.model.Order;

public interface OrderService {

    boolean createOrder(Order order);

    boolean deleteOrder(String id);

}
