package org.likelion.likelionassignmentcrud.developer.api.dto.response;

import lombok.Builder;
import org.likelion.likelionassignmentcrud.developer.domain.Developer;
import org.likelion.likelionassignmentcrud.developer.domain.Status;

@Builder
public record DeveloperInfoResDto(
        String name,
        String country,
        Status status
) {
    public static DeveloperInfoResDto from(Developer developer) {
        return DeveloperInfoResDto.builder()
                .name(developer.getName())
                .country(developer.getCountry())
                .status(developer.getStatus())
                .build();
    }
}
