package org.likelion.likelionassignmentcrud.product.api;

import org.likelion.likelionassignmentcrud.product.api.dto.request.ProductSaveReqDto;
import org.likelion.likelionassignmentcrud.product.api.dto.response.ProductListResDto;
import org.likelion.likelionassignmentcrud.product.application.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> productSave(@RequestBody ProductSaveReqDto productSaveReqDto) {
        productService.productSave(productSaveReqDto);
        return new ResponseEntity<>("상품 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<ProductListResDto> myProductFindAll(@PathVariable("orderId") Long orderId) {
        ProductListResDto productListResDto = productService.productFindOrder(orderId);
        return new ResponseEntity<>(productListResDto, HttpStatus.OK);
    }
}
