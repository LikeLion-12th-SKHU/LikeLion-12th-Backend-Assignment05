package org.likelion.likelionassignmentcrud.order.api.dto;

import org.likelion.likelionassignmentcrud.order.api.dto.request.OrderSaveReqDto;
import org.likelion.likelionassignmentcrud.order.api.dto.response.OrderListResDto;
import org.likelion.likelionassignmentcrud.order.application.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> orderSave(@RequestBody OrderSaveReqDto orderSaveReqDto) {
        orderService.orderSave(orderSaveReqDto);

        return new ResponseEntity<>("발주 내역 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<OrderListResDto> myOrderFindAll(@PathVariable("memberId") Long memberId) {
        OrderListResDto orderListResDto = orderService.orderFindMember(memberId);

        return new ResponseEntity<>(orderListResDto, HttpStatus.OK);
    }
}
