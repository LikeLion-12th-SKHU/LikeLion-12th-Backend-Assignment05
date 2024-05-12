package org.likelion.likelionassignmentcrud.lecture.api;

import org.likelion.likelionassignmentcrud.lecture.api.dto.request.LectureSaveReqDto;
import org.likelion.likelionassignmentcrud.lecture.api.dto.response.LectureListResDto;
import org.likelion.likelionassignmentcrud.lecture.application.LectureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lecture")
public class LectureController {
    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> lectureSave(@RequestBody LectureSaveReqDto lectureSaveReqDto) {
        lectureService.lectureSave(lectureSaveReqDto);
        return new ResponseEntity<>("강의 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/{professorId}")
    public ResponseEntity<LectureListResDto> myLectureFindAll(@PathVariable("professorId") Long professorId) {
        LectureListResDto lectureListResDto = lectureService.lectureFindProfessor(professorId);
        return new ResponseEntity<>(lectureListResDto, HttpStatus.OK);
    }
}
