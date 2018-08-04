package cn.thoughtworks.twMall.service;

import cn.thoughtworks.twMall.entity.Order;
import cn.thoughtworks.twMall.exception.OrderNotFoundException;
import cn.thoughtworks.twMall.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order get(Long id) throws OrderNotFoundException {
        return orderRepository.findById(id)
                .orElseThrow(OrderNotFoundException::new);
    }
}
