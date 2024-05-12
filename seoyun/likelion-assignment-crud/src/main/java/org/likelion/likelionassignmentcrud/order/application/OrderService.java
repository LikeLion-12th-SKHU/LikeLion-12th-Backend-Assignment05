package org.likelion.likelionassignmentcrud.order.application;

import java.util.List;
import org.likelion.likelionassignmentcrud.order.api.dto.request.OrderSaveReqDto;
import org.likelion.likelionassignmentcrud.order.api.dto.response.OrderInfoResDto;
import org.likelion.likelionassignmentcrud.order.api.dto.response.OrderListResDto;
import org.likelion.likelionassignmentcrud.order.domain.Order;
import org.likelion.likelionassignmentcrud.order.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Create
    @Transactional
    public void orderSave(OrderSaveReqDto orderSaveReqDto) {
        Order order = Order.builder()
                .name(orderSaveReqDto.name())
                .part(orderSaveReqDto.part())
                .build();

        orderRepository.save(order);
    }

    // Read All
    public OrderListResDto orderFindAll() {
        List<Order> orders = orderRepository.findAll();

        List<OrderInfoResDto> orderInfoResDtoList = orders.stream()
                .map(OrderInfoResDto::from)
                .toList();

        return OrderListResDto.from(orderInfoResDtoList);
    }

    // Read One
    public OrderInfoResDto orderFindOne(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(IllegalArgumentException::new);

        return OrderInfoResDto.from(order);
    }

}