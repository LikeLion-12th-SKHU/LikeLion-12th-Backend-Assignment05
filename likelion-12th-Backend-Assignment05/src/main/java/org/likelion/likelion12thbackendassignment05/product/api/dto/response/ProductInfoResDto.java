package org.likelion.likelion12thbackendassignment05.product.api.dto.response;

import lombok.Builder;
import org.likelion.likelion12thbackendassignment05.product.domain.Part;
import org.likelion.likelion12thbackendassignment05.product.domain.Product;

@Builder
public record ProductInfoResDto(
        String name,
        Long price,
        Part part
) {

    public static ProductInfoResDto from(Product product) {
        return ProductInfoResDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .part(product.getPart())
                .build();
    }
}
