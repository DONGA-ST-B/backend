package gip.sever.controller;


import gip.sever.domain.Member;
import gip.sever.domain.SessionUser;
import gip.sever.dto.request.CartRequest;
//import gip.sever.dto.response.CartResponse;
import gip.sever.dto.response.CartResponseDto;
import gip.sever.global.response.SuccessResponse;
import gip.sever.repository.MemberRepository;
import gip.sever.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static gip.sever.ResponseMessage.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final MemberRepository memberRepository;

    @PostMapping("/add/{productId}")
    public ResponseEntity<SuccessResponse<String>> addToCart(HttpServletRequest request, @PathVariable(name = "productId") Long productId) throws Exception {
        SessionUser user = (SessionUser) request.getSession(true).getAttribute("user");

        Member member = memberRepository.findByEmail(user.getEmail()).orElseThrow();
        Long memberId = member.getId();

        boolean add = cartService.addToCart(memberId, productId);
        if (add) {
            return ResponseEntity.ok(SuccessResponse.create(POST_PRODUCT_SUCCESS.getMessage()));
        } else {
            return ResponseEntity.ok(SuccessResponse.creat(FALSE_PRODUCT.getMessage()));
        }
    }


    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<SuccessResponse<String>> removeFromCart(HttpServletRequest request, @PathVariable(name = "productId") Long productId) throws Exception {
        SessionUser user = (SessionUser) request.getSession(true).getAttribute("user");

        Member member = memberRepository.findByEmail(user.getEmail()).orElseThrow();
        Long memberId = member.getId();

        cartService.removeFromCart(memberId, productId);
        return ResponseEntity.ok(SuccessResponse.create(DELETE_PRODUCT_SUCCESS.getMessage()));
    }


    @GetMapping("")
    public CartResponseDto.CartResponse getCart(HttpServletRequest request) throws Exception {
        SessionUser user = (SessionUser) request.getSession(true).getAttribute("user");

        Member member = memberRepository.findByEmail(user.getEmail()).orElseThrow();
        Long memberId = member.getId();
        return cartService.getCart(memberId);


    }

}
