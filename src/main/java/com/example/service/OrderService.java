package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.OrderRepository;

import jakarta.persistence.criteria.Order;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order newOrder) {
        // Add logic to handle creating a new order, saving it to the database, etc.
        return orderRepository.save(newOrder);
    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
    public Order updateOrder(Long orderId, Order updatedOrder) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            // Update order properties based on updatedOrder
            // For example:
            // order.setCustomer(updatedOrder.getCustomer());
            // order.setTotalAmount(updatedOrder.getTotalAmount());
            // Save the updated order
            return orderRepository.save(order);
        }
        return null;
    }
    public boolean cancelOrder(Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }

}
