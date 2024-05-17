package org.likelion.likelionassignmentcrud.major.api;

import org.likelion.likelionassignmentcrud.major.api.dto.request.MajorSaveReqDto;
import org.likelion.likelionassignmentcrud.major.api.dto.response.MajorListResDto;
import org.likelion.likelionassignmentcrud.major.application.MajorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/major")
public class MajorController {

    private final MajorService majorService;

    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> majorSave(@RequestBody MajorSaveReqDto majorSaveReqDto) {
        majorService.MajorSave(majorSaveReqDto);
        return new ResponseEntity<>("전공 저장", HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<MajorListResDto> myMajorFindAll(@PathVariable("studentId") Long studentId) {
        MajorListResDto majorListResDto = majorService.majorFindStudent(studentId);
        return new ResponseEntity<>(majorListResDto, HttpStatus.OK);
    }
}
