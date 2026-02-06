package org.likelion.likelionassignmentcrud.user.api.dto;

import org.likelion.likelionassignmentcrud.user.api.dto.request.StudentSaveReqDto;
import org.likelion.likelionassignmentcrud.user.api.dto.response.StudentInfoResDto;
import org.likelion.likelionassignmentcrud.user.api.dto.response.StudentListResDto;
import org.likelion.likelionassignmentcrud.user.application.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 저장하기
    @PostMapping("/save")
    public ResponseEntity<String> studentSave(@RequestBody StudentSaveReqDto studentSaveReqDto) {
        studentService.studentSave(studentSaveReqDto);
        return new ResponseEntity<>("이용자 저장됨", HttpStatus.CREATED);
    }

    //모두 불러오기
    @GetMapping("/students")
    public ResponseEntity<StudentListResDto> studentFindAll() {
        StudentListResDto studentListResDto = studentService.studentFindAll();
        return new ResponseEntity<>(studentListResDto, HttpStatus.OK);
    }

    //하나만 불러오기
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentInfoResDto> studentFindOne(@PathVariable ("studentId") Long studentId) {
        StudentInfoResDto studentInfoResDto = studentService.studentFindOne(studentId);
        return new ResponseEntity<>(studentInfoResDto, HttpStatus.OK);
    }
}

