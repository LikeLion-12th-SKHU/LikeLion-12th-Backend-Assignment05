package org.likelion.likelionassignmentcrud.orders;

import org.likelion.likelionassignmentcrud.orders.api.dto.request.OrdersSaveReqDto;
import org.likelion.likelionassignmentcrud.orders.api.dto.response.OrdersListResDto;
import org.likelion.likelionassignmentcrud.orders.application.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {

        this.ordersService = ordersService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> ordersSave(@RequestBody OrdersSaveReqDto ordersSaveReqDto) {
        ordersService.ordersSave(ordersSaveReqDto);
        return new ResponseEntity<>("주문 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<OrdersListResDto> myOrdersFindAll(@PathVariable("food id") Long foodId) {
        OrdersListResDto ordersListResDto = ordersService.ordersFindFood(foodId);
        return new ResponseEntity<>(ordersListResDto, HttpStatus.OK);
    }

}
