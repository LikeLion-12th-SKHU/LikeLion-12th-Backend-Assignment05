package org.likelion.likelion12thbackendassignment05.order.api.dto.response;

import lombok.Builder;
import org.likelion.likelion12thbackendassignment05.order.domain.Order;

@Builder
public record OrderInfoResDto(
        String costName,
        String location
) {
   public static OrderInfoResDto from(Order order) {
       return OrderInfoResDto.builder()
               .costName(order.getCostName())
               .location(order.getLocation())
               .build();
   }
}
