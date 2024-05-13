package org.likelion.likelionassignmentcrud.rent.api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record RentListResDto(List<RentInfoResDto> rents) {
    public static RentListResDto from(List<RentInfoResDto> rents) {
        return RentListResDto.builder()
                .rents(rents).build();
    }

}
