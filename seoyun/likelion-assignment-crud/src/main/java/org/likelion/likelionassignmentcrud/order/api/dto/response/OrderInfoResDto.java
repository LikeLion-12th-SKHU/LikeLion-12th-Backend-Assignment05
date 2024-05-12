package org.likelion.likelionassignmentcrud.order.api.dto.response;
import lombok.Builder;
import org.likelion.likelionassignmentcrud.order.domain.Order;
import org.likelion.likelionassignmentcrud.order.domain.Part;

@Builder
public record OrderInfoResDto(
        Long orderId,
        String name,
        Part part
) {
    public static OrderInfoResDto from(Order order) {
        return OrderInfoResDto.builder()
                .orderId(order.getOrderId())
                .name(order.getName())
                .part(order.getPart())
                .build();
    }
}

