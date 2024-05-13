package org.likelion.likelionassignmentcrud.consumer.api.dto;

import org.likelion.likelionassignmentcrud.consumer.api.application.ConsumerService;
import org.likelion.likelionassignmentcrud.consumer.api.domain.Consumer;
import org.likelion.likelionassignmentcrud.consumer.api.dto.request.ConsumerSaveReqDto;
import org.likelion.likelionassignmentcrud.consumer.api.dto.response.ConsumerInfoResDto;
import org.likelion.likelionassignmentcrud.consumer.api.dto.response.ConsumerListResDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService){
        this.consumerService = consumerService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> consumerSave(@RequestBody ConsumerSaveReqDto consumerSaveReqDto) {
        consumerService.consumerSave(consumerSaveReqDto);
        return new ResponseEntity<>("사용자 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/consumers")
    public ResponseEntity<ConsumerListResDto> consumerFindAll() {
        ConsumerListResDto consumerListResDto = consumerService.consumerFindAll();
        return new ResponseEntity<>(consumerListResDto, HttpStatus.OK);
    }

    @GetMapping("/{consumerId}")
    public ResponseEntity<ConsumerInfoResDto> consumerFindOne(@PathVariable("consumerId") Long consumerId) {
        ConsumerInfoResDto consumerInfoResDto = consumerService.consumerFindOne(consumerId);
        return new ResponseEntity<>(consumerInfoResDto, HttpStatus.OK);
    }
}
