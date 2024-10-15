package com.ecommerce.order.controller;

import com.ecommerce.common.order.OrderCreateDto;
import com.ecommerce.common.order.OrderDto;
import com.ecommerce.common.order.OrderUpdateDto;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        OrderDto orderDto = new OrderDto(order.getId(), order.getUserId(), order.getItemId(), order.getCurrency(), order.getAmount());

        return ResponseEntity.ok(orderDto);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();

        List<OrderDto> dtos = orders.stream()
            .map(order -> new OrderDto(order.getId(), order.getUserId(), order.getItemId(), order.getCurrency(), order.getAmount()))
            .toList();

        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderCreateDto orderCreateDto) {
        Order order = new Order();
        order.setUserId(orderCreateDto.userId());
        order.setItemId(orderCreateDto.itemId());
        order.setCurrency(orderCreateDto.currency());
        order.setAmount(orderCreateDto.amount());
        order.setCreationDate(java.time.LocalDateTime.now());

        Order createdOrder = orderService.createOrder(order);
        OrderDto orderDto = new OrderDto(createdOrder.getId(), createdOrder.getUserId(), createdOrder.getItemId(), createdOrder.getCurrency(), createdOrder.getAmount());

        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @RequestBody OrderUpdateDto orderUpdateDto) {
        Order updatedOrder = new Order();
        updatedOrder.setUserId(orderUpdateDto.userId());
        updatedOrder.setItemId(orderUpdateDto.itemId());
        updatedOrder.setCurrency(orderUpdateDto.currency());
        updatedOrder.setAmount(orderUpdateDto.amount());
        updatedOrder.setUpdateDate(java.time.LocalDateTime.now());

        Order savedOrder = orderService.updateOrder(id, updatedOrder);
        OrderDto orderDto = new OrderDto(savedOrder.getId(), savedOrder.getUserId(), savedOrder.getItemId(), savedOrder.getCurrency(), savedOrder.getAmount());

        return ResponseEntity.ok(orderDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);

        return ResponseEntity.noContent().build();
    }
}
