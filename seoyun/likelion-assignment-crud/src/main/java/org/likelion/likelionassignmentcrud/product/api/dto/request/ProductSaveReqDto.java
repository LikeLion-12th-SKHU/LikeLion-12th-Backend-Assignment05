package org.likelion.likelionassignmentcrud.product.api.dto.request;

import org.likelion.likelionassignmentcrud.order.domain.Order;

public record ProductSaveReqDto(
        Long price,
        String name,
        Order order
){
}
