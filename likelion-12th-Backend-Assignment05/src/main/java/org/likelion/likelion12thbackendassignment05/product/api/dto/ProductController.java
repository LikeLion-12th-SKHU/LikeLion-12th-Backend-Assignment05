package org.likelion.likelion12thbackendassignment05.product.api.dto;

import org.likelion.likelion12thbackendassignment05.product.api.dto.request.ProductSaveReqDto;
import org.likelion.likelion12thbackendassignment05.product.api.dto.response.ProductListResDto;
import org.likelion.likelion12thbackendassignment05.product.application.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/products")
    public ResponseEntity<ProductListResDto> productFindAll() {
        ProductListResDto productListResDto = productService.productFindAll();

        return new ResponseEntity<>(productListResDto, HttpStatus.OK);
    }
}
