package gip.sever.service;

import gip.sever.domain.Cart;
import gip.sever.domain.Product;
import gip.sever.dto.response.CartResponse;
import gip.sever.repository.CartRepository;
import gip.sever.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;


    @Transactional
    public void addToCart(Long memberId, Long productId) throws Exception{
        Cart cart = cartRepository.findByMemberId(memberId)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));;
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        cart.addProduct(product);
        cartRepository.save(cart);
    }

    @Transactional
    public void removeFromCart(Long memberId, Long productId) throws Exception{
        Cart cart = cartRepository.findByMemberId(memberId)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));;
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        cart.removeProduct(product);
        cartRepository.save(cart);
    }

    public CartResponse getCart(Long memberId) throws Exception{
        Cart cart = cartRepository.findByMemberId(memberId)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return new CartResponse(cart);
    }

}
