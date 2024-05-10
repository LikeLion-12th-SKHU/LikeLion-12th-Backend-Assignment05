package org.likelion.likelion12thbackendassignment05.order.application;

import org.likelion.likelion12thbackendassignment05.order.api.dto.request.OrderSaveReqDto;
import org.likelion.likelion12thbackendassignment05.order.api.dto.response.OrderInfoResDto;
import org.likelion.likelion12thbackendassignment05.order.api.dto.response.OrderListResDto;
import org.likelion.likelion12thbackendassignment05.order.domain.Order;
import org.likelion.likelion12thbackendassignment05.order.domain.repository.OrderRepository;
import org.likelion.likelion12thbackendassignment05.product.domain.Product;
import org.likelion.likelion12thbackendassignment05.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void orderSave(OrderSaveReqDto orderSaveReqDto) {
        Product product = productRepository.findById(orderSaveReqDto.productId())
                .orElseThrow(null);

        Order order = Order.builder()
                .costName(orderSaveReqDto.costName())
                .location(orderSaveReqDto.location())
                .product(product)
                .build();

        orderRepository.save(order);
    }

    public OrderListResDto orderFindProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(null);
        List<Order> orders = orderRepository.findByProduct(product);
        List<OrderInfoResDto> orderInfoResDtos =
        orders.stream()
                .map(OrderInfoResDto::from)
                .toList();

        return OrderListResDto.from(orderInfoResDtos);
    }
}
