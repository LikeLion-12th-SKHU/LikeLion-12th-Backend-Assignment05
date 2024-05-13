package org.likelion.likelionassignmentcrud.user.api.dto.response;

import lombok.Builder;
import org.likelion.likelionassignmentcrud.user.domain.Major;
import org.likelion.likelionassignmentcrud.user.domain.Student;

@Builder
public record StudentInfoResDto(Long studentId, String name, Major major) {
    public static StudentInfoResDto from(Student student) {
        return StudentInfoResDto.builder()
                .studentId(student.getStudentId())
                .name(student.getName())
                .major(student.getMajor())
                .build();
    }
}
