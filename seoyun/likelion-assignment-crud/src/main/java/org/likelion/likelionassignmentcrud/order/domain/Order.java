package org.likelion.likelionassignmentcrud.order.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.likelion.likelionassignmentcrud.product.domain.Product;

@Entity
@Getter
@Table(name = "ORDERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId; //주문번호

    private String name; //구매자이름

    @Enumerated(EnumType.STRING)
    private Part part;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    @Builder
    private Order(Long orderId, String name, Part part) {
        this.orderId = orderId;
        this.name = name;
        this.part = part;
    }
}
