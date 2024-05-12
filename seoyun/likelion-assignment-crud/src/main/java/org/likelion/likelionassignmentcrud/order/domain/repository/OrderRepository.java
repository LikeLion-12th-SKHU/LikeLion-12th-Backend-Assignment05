package org.likelion.likelionassignmentcrud.order.domain.repository;

import org.likelion.likelionassignmentcrud.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
