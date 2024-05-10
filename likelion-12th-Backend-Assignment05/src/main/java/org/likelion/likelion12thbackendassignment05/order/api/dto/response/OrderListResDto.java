package org.likelion.likelion12thbackendassignment05.order.api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderListResDto(
        List<OrderInfoResDto> orders
) {
    public static OrderListResDto from(List<OrderInfoResDto> orders) {
        return OrderListResDto.builder()
                .orders(orders)
                .build();
    }
}
