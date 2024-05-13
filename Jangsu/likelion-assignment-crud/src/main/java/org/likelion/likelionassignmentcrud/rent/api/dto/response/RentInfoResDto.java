package org.likelion.likelionassignmentcrud.rent.api.dto.response;

import lombok.Builder;
import org.likelion.likelionassignmentcrud.rent.domain.Rent;

@Builder
public record RentInfoResDto(Long rentId, String rentTime, String returnTime, String bookName) {
    public static RentInfoResDto from(Rent rent) {
        return RentInfoResDto.builder()
                .rentId(rent.getRentId())
                .rentTime(rent.getRentTime())
                .returnTime(rent.getReturnTime())
                .bookName(rent.getBookName())
                .build();
    }
}
