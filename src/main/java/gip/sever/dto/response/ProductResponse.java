package gip.sever.dto.response;

import gip.sever.domain.Product;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProductResponse {
    private Long id;

    private String productName;
    private double price;
    private String photoUrl;
    private int likes;
    private String kind;
    // 부가설명 필드 추가
    private String additionalDescription;

    // 장바구니 필드
    private boolean isInCart; // 제품이 장바구니에 있는지 여부
    private int quantity;     // 제품의 수량
    public ProductResponse(Product product) {
        this.id =product.getId();
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.photoUrl = product.getPhotoUrl();
        this.likes = product.getLikes();
        this.isInCart = product.isInCart();
        this.quantity = product.getQuantity();
        this.kind = product.getKind();
        this.additionalDescription =product.getAdditionalDescription();
    }
}
