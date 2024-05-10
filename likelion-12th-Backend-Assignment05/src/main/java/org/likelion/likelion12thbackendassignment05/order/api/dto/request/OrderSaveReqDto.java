package org.likelion.likelion12thbackendassignment05.order.api.dto.request;

public record OrderSaveReqDto(
        Long productId,
        String costName,
        String location
) {
}
