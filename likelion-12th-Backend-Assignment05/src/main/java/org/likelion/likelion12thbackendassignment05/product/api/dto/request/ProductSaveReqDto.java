package org.likelion.likelion12thbackendassignment05.product.api.dto.request;

import org.likelion.likelion12thbackendassignment05.product.domain.Part;

public record ProductSaveReqDto(
        String name,
        Long price,
        Part part
) {
}
