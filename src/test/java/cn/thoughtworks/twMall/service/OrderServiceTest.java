package cn.thoughtworks.twMall.service;

import cn.thoughtworks.twMall.entity.Order;
import cn.thoughtworks.twMall.exception.OrderNotFoundException;
import cn.thoughtworks.twMall.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    private OrderService orderService;

    @Before
    public void setUp() throws Exception {
        orderService = new OrderService(orderRepository);
    }

    @Test
    public void should_get_one_order_given_id() {
        // given
        Order order = Order.builder()
                .id(10L)
                .userId(50L)
                .build();
        Optional<Order> optOrder = Optional.of(order);

        given(orderRepository.findById(anyLong()))
                .willReturn(optOrder);

        // when
        Order actual = orderService.get(1L);

        // then
        assertThat(actual.getId()).isEqualTo(10L);
        assertThat(actual.getUserId()).isEqualTo(50L);
    }

    @Test(expected = OrderNotFoundException.class)
    public void should_throw_exception_given_not_exist_id() {
        // given
        Optional<Order> optOrder = Optional.empty();

        given(orderRepository.findById(anyLong()))
                .willReturn(optOrder);

        // when
        Order actual = orderService.get(1L);
    }
}
