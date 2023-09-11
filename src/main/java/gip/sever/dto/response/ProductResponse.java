package gip.sever.dto.response;

import gip.sever.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;

    private String productName;
    private double price;
    private String photoUrl;
    private int likes;

    // 장바구니 필드
    private boolean isInCart; // 제품이 장바구니에 있는지 여부
    private int quantity;     // 제품의 수량
    public ProductResponse(Product product) {
        this.productName = productName;
        this.price = price;
        this.photoUrl = photoUrl;
        this.likes = likes;
        this.isInCart = isInCart;
        this.quantity = quantity;
    }
}
