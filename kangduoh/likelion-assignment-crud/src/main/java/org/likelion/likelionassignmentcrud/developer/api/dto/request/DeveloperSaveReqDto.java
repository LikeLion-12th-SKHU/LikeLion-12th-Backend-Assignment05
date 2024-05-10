package org.likelion.likelionassignmentcrud.developer.api.dto.request;

import org.likelion.likelionassignmentcrud.developer.domain.Status;

public record DeveloperSaveReqDto(
        // 이름, 국가, 상태
        String name,
        String country,
        Status status
) {
}
