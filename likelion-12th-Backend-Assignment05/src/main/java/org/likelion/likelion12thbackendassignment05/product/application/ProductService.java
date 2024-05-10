package org.likelion.likelion12thbackendassignment05.product.application;

import org.likelion.likelion12thbackendassignment05.product.api.dto.request.ProductSaveReqDto;
import org.likelion.likelion12thbackendassignment05.product.api.dto.response.ProductInfoResDto;
import org.likelion.likelion12thbackendassignment05.product.api.dto.response.ProductListResDto;
import org.likelion.likelion12thbackendassignment05.product.domain.Product;
import org.likelion.likelion12thbackendassignment05.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Transactional
    public void productSave(ProductSaveReqDto productSaveReqDto) {

        Product product = Product.builder()
                .name(productSaveReqDto.name())
                .price(productSaveReqDto.price())
                .part(productSaveReqDto.part())
                .build();

        productRepository.save(product);
    }

    public ProductListResDto productFindAll() {
        List<Product> products = productRepository.findAll();

        List<ProductInfoResDto> productInfoResDtos = products.stream()
                .map(ProductInfoResDto::from)
                .toList();

        return ProductListResDto.from(productInfoResDtos);
    }
}
