package org.likelion.likelion12thbackendassignment05.product.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.likelion.likelion12thbackendassignment05.order.domain.Order;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product id")
    private Long productId;

    private String name;
    private Long price;

    @Enumerated(EnumType.STRING)
    private Part part;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Product(String name, Long price, Part part) {
        this.name = name;
        this.price = price;
        this.part = part;
    }

}
