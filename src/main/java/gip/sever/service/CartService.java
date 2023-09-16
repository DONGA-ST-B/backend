package gip.sever.service;

import gip.sever.domain.Cart;
import gip.sever.domain.CartItem;
import gip.sever.domain.Member;
import gip.sever.domain.Product;
import gip.sever.dto.response.CartResponseDto;
import gip.sever.repository.CartItemRepository;
import gip.sever.repository.CartRepository;
import gip.sever.repository.MemberRepository;
import gip.sever.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final MemberRepository memberRepository;

   /* @Transactional
    public void addToCart(Long memberId, Long productId) throws Exception{
        Cart cart = cartRepository.findByMemberId(memberId)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));;
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found"));
//        cart.addProduct(product);
        cartRepository.save(cart);
    }*/
   @Transactional
   public boolean addToCart(Long memberId, Long productId) throws Exception {

       Member member = memberRepository.findById(memberId).orElseThrow();
       Cart cart = cartRepository.findByMember(member).orElseThrow();

//       Cart cart = cartRepository.findByMemberId(memberId)
//               .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));

       Product product = productRepository.findById(productId)
               .orElseThrow();


       boolean isAlreadyInCart = cart.getCartItems().stream()
               .anyMatch(cartItem -> cartItem.getProduct().equals(product));

       if (isAlreadyInCart) {
           return false;
       } else {
           CartItem cartItem = new CartItem(cart, product);
           cart.getCartItems().add(cartItem);
           cartRepository.save(cart);
           return true;
       }
   }
    @Transactional
    public boolean removeFromCart(Long memberId, Long productId) throws Exception{
        Cart cart = cartRepository.findByMemberId(memberId)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        // 장바구니에서 해당 상품을 찾아서 삭제
        cart.getCartItems().removeIf(cartItem -> cartItem.getProduct().equals(product));

        cartRepository.save(cart);
        return true;
    }

    public CartResponseDto.CartResponse getCart(Long memberId) throws Exception{

        Member member = memberRepository.findById(memberId).orElseThrow();
        Cart cart = cartRepository.findByMember(member).orElseThrow();

//        Cart cart = cartRepository.findByMemberId(memberId)
//                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));

      List<CartItem> cartItems = cartItemRepository.findByMemberIdAndCartId(memberId, cart.getId());

//
        return new CartResponseDto.CartResponse(cart);
    }

}
