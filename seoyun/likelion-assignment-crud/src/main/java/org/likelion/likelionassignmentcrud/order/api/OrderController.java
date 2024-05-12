package org.likelion.likelionassignmentcrud.order.api;

import org.likelion.likelionassignmentcrud.order.api.dto.request.OrderSaveReqDto;
import org.likelion.likelionassignmentcrud.order.api.dto.response.OrderInfoResDto;
import org.likelion.likelionassignmentcrud.order.api.dto.response.OrderListResDto;
import org.likelion.likelionassignmentcrud.order.application.OrderService;
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
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> orderSave(@RequestBody OrderSaveReqDto orderSaveReqDto) {
        orderService.orderSave(orderSaveReqDto);
        return new ResponseEntity<>("주문 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<OrderListResDto> orderFindAll() {
        OrderListResDto orderListResDto = orderService.orderFindAll();
        return new ResponseEntity<>(orderListResDto, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderInfoResDto> orderFindOne(@PathVariable("orderId") Long orderId) {
        OrderInfoResDto orderInfoResDto = orderService.orderFindOne(orderId);
        return new ResponseEntity<>(orderInfoResDto, HttpStatus.OK);
    }
}
