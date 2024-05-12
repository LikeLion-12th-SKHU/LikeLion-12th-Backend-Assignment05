package org.likelion.likelionassignmentcrud.rant.api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record RantListResDto(List<RantInfoResDto> rants) {
    public static RantListResDto from(List<RantInfoResDto> rants) {
        return RantListResDto.builder()
                .rants(rants).build();
    }

}
