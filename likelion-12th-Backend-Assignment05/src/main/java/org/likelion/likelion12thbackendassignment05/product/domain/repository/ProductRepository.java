package org.likelion.likelion12thbackendassignment05.product.domain.repository;

import org.likelion.likelion12thbackendassignment05.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
