package cn.thoughtworks.twMall.controller;

import cn.thoughtworks.twMall.entity.Order;
import cn.thoughtworks.twMall.exception.OrderNotFoundException;
import cn.thoughtworks.twMall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> get(@PathVariable Long orderId) {
        Order order = orderService.get(orderId);
        return ResponseEntity.ok(order);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private void exceptionHandler(OrderNotFoundException ex) {}
}
