package org.likelion.likelionassignmentcrud.rant.api.dto.response;

import lombok.Builder;
import org.likelion.likelionassignmentcrud.rant.domain.Rant;

@Builder
public record RantInfoResDto(Long rantId, String rantTime, String returnTime, String bookName) {
    public static RantInfoResDto from(Rant rant) {
        return RantInfoResDto.builder()
                .rantId(rant.getRantId())
                .rantTime(rant.getRantTime())
                .returnTime(rant.getReturnTime())
                .bookName(rant.getBookName())
                .build();
    }
}
