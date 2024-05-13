package org.likelion.likelionassignmentcrud.orders.api;


import org.likelion.likelionassignmentcrud.orders.api.dto.request.OrdersSaveReqDto;
import org.likelion.likelionassignmentcrud.orders.api.dto.response.OrdersListResDto;
import org.likelion.likelionassignmentcrud.orders.application.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> postSave(@RequestBody OrdersSaveReqDto ordersSaveReqDto) {
        ordersService.ordersSave(ordersSaveReqDto);
        return new ResponseEntity<>("주문 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/{usersId}")
    public ResponseEntity<OrdersListResDto> myPostFindAll(@PathVariable("usersId") Long usersId) {
        OrdersListResDto ordersListResDto = ordersService.ordersFindUsers(usersId);
        return new ResponseEntity<>(ordersListResDto, HttpStatus.OK);
    }
}