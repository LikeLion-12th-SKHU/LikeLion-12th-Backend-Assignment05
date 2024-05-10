package org.likelion.likelionassignmentcrud.developer.api;

import org.likelion.likelionassignmentcrud.developer.api.dto.request.DeveloperSaveReqDto;
import org.likelion.likelionassignmentcrud.developer.api.dto.response.DeveloperListResDto;
import org.likelion.likelionassignmentcrud.developer.application.DeveloperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> developerSave(@RequestBody DeveloperSaveReqDto developerSaveReqDto) {
        developerService.developerSave(developerSaveReqDto);

        return new ResponseEntity<>("개발사 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/developers")
    public ResponseEntity<DeveloperListResDto> developerFindAll() {
        DeveloperListResDto developerListResDto = developerService.developerFindAll();

        return new ResponseEntity<>(developerListResDto, HttpStatus.OK);
    }
}
