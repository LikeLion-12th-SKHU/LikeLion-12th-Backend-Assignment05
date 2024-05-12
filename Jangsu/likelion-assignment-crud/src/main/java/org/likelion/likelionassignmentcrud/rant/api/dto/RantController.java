package org.likelion.likelionassignmentcrud.rant.api.dto;

import org.likelion.likelionassignmentcrud.rant.api.dto.request.RantSaveReqDto;
import org.likelion.likelionassignmentcrud.rant.api.dto.response.RantListResDto;
import org.likelion.likelionassignmentcrud.rant.application.RantService;
import org.likelion.likelionassignmentcrud.user.api.dto.response.StudentListResDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 컨트롤러를 JSON으로 반환하는 컨트롤러로 만듦
@RequestMapping("/rant") // URL을 맵핑하는데 사용하는 어노테이션
public class RantController {
    private final RantService rantService;

    //초기화
    public RantController(RantService rantService) {
        this.rantService = rantService;
    }

    // 대출 현황 저장하기
    @PostMapping("/save")
    public ResponseEntity<String> rantSave(@RequestBody RantSaveReqDto rantSaveReqDto) {
        rantService.rantSave(rantSaveReqDto);
        return new ResponseEntity<>("대출 현황 저장됨", HttpStatus.CREATED);
    }

    // 대출 보기
    @GetMapping("/{studentId}")
    public ResponseEntity<RantListResDto> rantStatus(@PathVariable("studentId") Long studentId) {
        RantListResDto rantListResdto = rantService.rantStatusFind(studentId);

        return new ResponseEntity<>(rantListResdto, HttpStatus.OK);
    }
}
