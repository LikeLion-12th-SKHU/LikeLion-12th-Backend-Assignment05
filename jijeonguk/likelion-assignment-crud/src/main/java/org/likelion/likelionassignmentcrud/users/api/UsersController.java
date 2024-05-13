package org.likelion.likelionassignmentcrud.users.api;

import org.likelion.likelionassignmentcrud.users.api.dto.request.UsersSaveReqDto;
import org.likelion.likelionassignmentcrud.users.api.dto.response.UsersListResDto;
import org.likelion.likelionassignmentcrud.users.application.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsersController {
    private  final UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> usersSave(@RequestBody UsersSaveReqDto usersSaveReqDto) {
        usersService.usersSave(usersSaveReqDto);
        return new ResponseEntity<>("유저 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<UsersListResDto> usersFindAll(){
        UsersListResDto usersListResDto = usersService.usersFindAll();

        return new ResponseEntity<>(usersListResDto, HttpStatus.OK);
    }
}
