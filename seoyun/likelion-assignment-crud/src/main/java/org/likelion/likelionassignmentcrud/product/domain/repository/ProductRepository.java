package org.likelion.likelionassignmentcrud.product.domain.repository;

import org.likelion.likelionassignmentcrud.order.domain.Order;
import org.likelion.likelionassignmentcrud.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByOrder(Order order);
}
