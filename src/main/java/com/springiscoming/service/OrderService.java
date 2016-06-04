package com.springiscoming.service;

import com.springiscoming.model.Order;
import com.springiscoming.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Service
public class OrderService {

    @Inject
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
