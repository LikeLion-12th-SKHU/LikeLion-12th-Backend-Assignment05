package org.likelion.likelionassignmentcrud.order.api.dto.response;

import java.util.List;
import lombok.Builder;

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
