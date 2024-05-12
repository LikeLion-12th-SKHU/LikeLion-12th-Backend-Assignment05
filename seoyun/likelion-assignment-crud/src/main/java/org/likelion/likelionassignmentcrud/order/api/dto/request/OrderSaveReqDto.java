package org.likelion.likelionassignmentcrud.order.api.dto.request;

import org.likelion.likelionassignmentcrud.order.domain.Part;

public record OrderSaveReqDto(
        Long orderId,
        String name,
        Part part) {
}
