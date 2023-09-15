package gip.sever.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String productName;
    private double price;
    private String photoUrl;
    private int likes;

    private String kind;
    // 카테고리 필드
    @Enumerated(EnumType.STRING)
    private Category category;

    // 장바구니 필드
    private boolean isInCart; // 제품이 장바구니에 있는지 여부
    private int quantity;     // 제품의 수량

    // 부가설명 필드 추가
    @Column(length = 100)
    private String additionalDescription;
}
