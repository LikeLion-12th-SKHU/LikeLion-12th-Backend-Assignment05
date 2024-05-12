package org.likelion.likelionassignmentcrud.member.api.dto;

import org.likelion.likelionassignmentcrud.member.api.dto.request.MemberSaveReqDto;
import org.likelion.likelionassignmentcrud.member.api.dto.response.MemberInfoResDto;
import org.likelion.likelionassignmentcrud.member.api.dto.response.MemberListResDto;
import org.likelion.likelionassignmentcrud.member.application.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> memberSave(@RequestBody MemberSaveReqDto memberSaveReqDto) {
        memberService.memberSave(memberSaveReqDto);

        return new ResponseEntity<>("사업자 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/members")
    public ResponseEntity<MemberListResDto> memberFindAll() {
        MemberListResDto memberListResDto = memberService.memberFindAll();

        return new ResponseEntity<>(memberListResDto, HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberInfoResDto> memberFindOne(@PathVariable("memberId") Long memberId) {
        MemberInfoResDto memberInfoResDto = memberService.memberFindOne(memberId);

        return new ResponseEntity<>(memberInfoResDto, HttpStatus.OK);
    }
}
