package org.likelion.likelionassignmentcrud.user.application;

import org.likelion.likelionassignmentcrud.user.api.dto.request.StudentSaveReqDto;
import org.likelion.likelionassignmentcrud.user.api.dto.response.StudentInfoResDto;
import org.likelion.likelionassignmentcrud.user.api.dto.response.StudentListResDto;
import org.likelion.likelionassignmentcrud.user.domain.Student;
import org.likelion.likelionassignmentcrud.user.domain.respository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 실행 중 예외가 발생하면 해당 메서드를 실행하면서 수행한 쿼리들을 모두 롤백함
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // 새로 저장하기
    @Transactional
    public void studentSave(StudentSaveReqDto studentSaveReqDto) {
        Student student = Student.builder()
                .studentId(studentSaveReqDto.studentId())
                .name(studentSaveReqDto.name())
                .major(studentSaveReqDto.major()).build();

        studentRepository.save(student);
    }

    // 전부 불러오기
    public StudentListResDto studentFindAll() {
        List<Student> students = studentRepository.findAll();

        List<StudentInfoResDto> studentInfoResDtoList = students.stream()
                .map(StudentInfoResDto::from).toList();

        return StudentListResDto.from(studentInfoResDtoList);
    }

    // 하나만 불러오기
    public StudentInfoResDto studentFindOne(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(IllegalArgumentException::new);

        return StudentInfoResDto.from(student);
    }

}
