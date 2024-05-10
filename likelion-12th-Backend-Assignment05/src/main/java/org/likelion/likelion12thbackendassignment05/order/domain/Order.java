package org.likelion.likelion12thbackendassignment05.order.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.likelion.likelion12thbackendassignment05.product.domain.Product;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order id")
    private Long orderId;

    private String costName; // 주문 고객 이름
    private String location; // 배송 지역

    @ManyToOne(fetch = FetchType.LAZY) // Product와 연결
    @JoinColumn(name = "product id") // product id로 조인 받음
    private Product product;

    @Builder
    public Order(String costName, String location, Product product) {
        this.costName = costName;
        this.location = location;
        this.product = product;
    }
}
