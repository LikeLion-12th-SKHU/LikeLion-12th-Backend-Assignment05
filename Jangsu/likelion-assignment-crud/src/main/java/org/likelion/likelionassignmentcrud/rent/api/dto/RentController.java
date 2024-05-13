package org.likelion.likelionassignmentcrud.rent.api.dto;

import org.likelion.likelionassignmentcrud.rent.api.dto.request.RentSaveReqDto;
import org.likelion.likelionassignmentcrud.rent.api.dto.response.RentListResDto;
import org.likelion.likelionassignmentcrud.rent.application.RentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 컨트롤러를 JSON으로 반환하는 컨트롤러로 만듦
@RequestMapping("/rent") // URL을 맵핑하는데 사용하는 어노테이션
public class RentController {
    private final RentService rentService;

    //초기화
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    // 대출 현황 저장하기
    @PostMapping("/save")
    public ResponseEntity<String> rentSave(@RequestBody RentSaveReqDto rentSaveReqDto) {
        rentService.rentSave(rentSaveReqDto);
        return new ResponseEntity<>("대출 현황 저장됨", HttpStatus.CREATED);
    }

    // 대출 보기
    @GetMapping("/{studentId}")
    public ResponseEntity<RentListResDto> rentStatus(@PathVariable("studentId") Long studentId) {
        RentListResDto rantListResdto = rentService.rentStatusFind(studentId);

        return new ResponseEntity<>(rantListResdto, HttpStatus.OK);
    }
}
