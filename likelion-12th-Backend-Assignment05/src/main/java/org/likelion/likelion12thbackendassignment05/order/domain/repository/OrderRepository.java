package org.likelion.likelion12thbackendassignment05.order.domain.repository;

import org.likelion.likelion12thbackendassignment05.order.domain.Order;
import org.likelion.likelion12thbackendassignment05.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByProduct(Product product);
}
