package gip.sever.service;

import gip.sever.domain.Cart;
import gip.sever.domain.CartItem;
import gip.sever.domain.Product;
import gip.sever.dto.response.CartResponse;
import gip.sever.repository.CartItemRepository;
import gip.sever.repository.CartRepository;
import gip.sever.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    @Transactional
    public void addToCart(Long memberId, Long productId) throws Exception {
        Cart cart = cartRepository.findByMemberId(memberId)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        // CartItem을 생성하여 카트에 추가
        CartItem cartItem = new CartItem(cart, product);
        cart.getCartItems().add(cartItem);

        cartRepository.save(cart);
    }

    @Transactional
    public void removeFromCart(Long memberId, Long productId) throws Exception{
        Cart cart = cartRepository.findByMemberId(memberId)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));;
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found"));
//        cart.removeProduct(product);
        cartRepository.save(cart);
    }

    public CartResponse getCart(Long memberId) throws Exception{
        Cart cart = cartRepository.findByMemberId(memberId)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));

        List<CartItem> cartItems = cartItemRepository.findByMemberIdAndCartId(memberId, cart.getId());

        return new CartResponse(cart.getId(), cartItems);
    }

}
