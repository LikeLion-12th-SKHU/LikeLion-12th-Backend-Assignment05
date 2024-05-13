package org.likelion.likelionassignmentcrud.rent.api.dto.request;


public record RentSaveReqDto(Long rentId, String rentTime, String returnTime, String bookName) {

}
