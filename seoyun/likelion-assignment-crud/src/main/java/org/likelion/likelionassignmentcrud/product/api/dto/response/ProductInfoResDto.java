package org.likelion.likelionassignmentcrud.product.api.dto.response;

import org.likelion.likelionassignmentcrud.order.domain.Order;
import org.likelion.likelionassignmentcrud.product.domain.Product;

import lombok.Builder;
@Builder
public record ProductInfoResDto(
        Long price, //가격
        String name, // 물건 이름
        String seller //판매자
) {
    public static ProductInfoResDto from(Product product) {
        return ProductInfoResDto.builder()
                .price(product.getPrice())
                .name(product.getName())
                .seller(product.getOrder().getName())
                .build();
    }
}
