package org.likelion.likelionassignmentcrud.orders.api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record OrdersListResDto(
        List<OrdersInfoResDto>  orderss
) {
    public static OrdersListResDto from(List<OrdersInfoResDto> orderss) {
        return OrdersListResDto.builder()
                .orderss(orderss)
                .build();
    }
}
