package cn.thoughtworks.twMall.service;

import cn.thoughtworks.twMall.entity.Order;
import cn.thoughtworks.twMall.exception.OrderNotFoundException;
import cn.thoughtworks.twMall.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order get(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(OrderNotFoundException::new);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
