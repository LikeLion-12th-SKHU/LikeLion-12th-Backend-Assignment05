package org.likelion.likelion12thbackendassignment05.order.api.dto;

import org.likelion.likelion12thbackendassignment05.order.api.dto.request.OrderSaveReqDto;
import org.likelion.likelion12thbackendassignment05.order.api.dto.response.OrderListResDto;
import org.likelion.likelion12thbackendassignment05.order.application.OrderService;
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
    public ResponseEntity<String> postSave(@RequestBody OrderSaveReqDto orderSaveReqDto) {
        orderService.orderSave(orderSaveReqDto);
        return new ResponseEntity<>("주문 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<OrderListResDto> myOrderFindAll(@PathVariable("product id") Long productId) {
        OrderListResDto orderListResDto = orderService.orderFindProduct(productId);
        return new ResponseEntity<>(orderListResDto, HttpStatus.OK);
    }
}
