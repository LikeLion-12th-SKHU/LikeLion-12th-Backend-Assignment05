package org.likelion.likelionassignmentcrud.product.application;

import java.util.List;
import org.likelion.likelionassignmentcrud.order.domain.Order;
import org.likelion.likelionassignmentcrud.order.domain.repository.OrderRepository;
import org.likelion.likelionassignmentcrud.product.api.dto.request.ProductSaveReqDto;
import org.likelion.likelionassignmentcrud.product.api.dto.response.ProductInfoResDto;
import org.likelion.likelionassignmentcrud.product.api.dto.response.ProductListResDto;
import org.likelion.likelionassignmentcrud.product.domain.Product;
import org.likelion.likelionassignmentcrud.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(readOnly = true)
public class ProductService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public ProductService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    // Create
    @Transactional
    public void productSave(ProductSaveReqDto productSaveReqDto) {
        Order order = orderRepository.findById(productSaveReqDto.order().getOrderId()).orElseThrow(IllegalArgumentException::new);

        Product product = Product.builder()
                .price(productSaveReqDto.price())
                .name(productSaveReqDto.name())
                .order(order)
                .build();

        productRepository.save(product);
    }

    // Read (주문에 따른 물건 리스트)
    public ProductListResDto productFindOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(IllegalArgumentException::new);

        List<Product> products = productRepository.findByOrder(order);
        List<ProductInfoResDto> productInfoResDtoList = products.stream()
                .map(ProductInfoResDto::from)
                .toList();

        return ProductListResDto.from(productInfoResDtoList);
    }


}
