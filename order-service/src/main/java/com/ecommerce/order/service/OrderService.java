package com.ecommerce.order.service;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.repository.OrderRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> {
            log.error("Order with id {} not found", id);
            return new NoSuchElementException("Order not found with id: " + id);
        });
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public Order updateOrder(Long id, Order updatedOrder) {
        Order existingOrder = getOrderById(id);

        existingOrder.setUserId(updatedOrder.getUserId());
        existingOrder.setItemId(updatedOrder.getItemId());
        existingOrder.setCurrency(updatedOrder.getCurrency());
        existingOrder.setAmount(updatedOrder.getAmount());
        existingOrder.setUpdateDate(updatedOrder.getUpdateDate());

        return orderRepository.save(existingOrder);
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
