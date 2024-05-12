package org.likelion.likelionassignmentcrud.user.api.dto.request;

import org.likelion.likelionassignmentcrud.user.domain.Major;

public record StudentSaveReqDto(Long studentId, String name, Major major) {
}
