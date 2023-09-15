package gip.sever.dto.response;

import gip.sever.domain.Cart;
import gip.sever.domain.CartItem;
import gip.sever.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {

    private Long id;
    private List<CartItem> cartItems = new ArrayList<>();


    public CartResponse(Cart cart) {

      this.cartItems=cart.getCartItems();
        this.id=cart.getId();

    }
}
