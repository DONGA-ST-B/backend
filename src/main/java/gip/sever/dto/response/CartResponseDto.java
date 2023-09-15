package gip.sever.dto.response;

import gip.sever.domain.Cart;
import gip.sever.domain.CartItem;
import gip.sever.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
public class CartResponseDto {

    @Getter
    @NoArgsConstructor
    public static class CartResponse {
        private Long id;
        private List<CartItemDto> cartItems = new ArrayList<>();


        public CartResponse(Cart cart) {

            this.cartItems = cart.getCartItems().stream()
                    .map(cartItem -> new CartItemDto(cartItem))
                    .collect(Collectors.toList());
            this.id = cart.getId();

        }
    }
    @Getter
    public static class CartItemDto{
        private Long id;
        private ProductDto product ;

        public CartItemDto(CartItem cartItem){
            this.id = cartItem.getId();
            this.product = new ProductDto(cartItem.getProduct());

        }
    }

   @Getter
    public static class ProductDto{
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
        public ProductDto(Product product) {
            this.id=product.getId();
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
}
