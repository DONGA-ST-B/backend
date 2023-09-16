package gip.sever.controller;


import gip.sever.dto.request.CartRequest;
//import gip.sever.dto.response.CartResponse;
import gip.sever.dto.response.CartResponseDto;
import gip.sever.global.response.SuccessResponse;
import gip.sever.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static gip.sever.ResponseMessage.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<SuccessResponse<String>> addToCart(@RequestBody CartRequest cartRequest) throws Exception {
        boolean add =cartService.addToCart(cartRequest.getMemberId(), cartRequest.getProductId());
        if (add) {
            return ResponseEntity.ok(SuccessResponse.create(POST_PRODUCT_SUCCESS.getMessage()));
        } else {
            return ResponseEntity.ok(SuccessResponse.creat(FALSE_PRODUCT.getMessage()));
        }
    }


    @DeleteMapping("/remove")
    public ResponseEntity<SuccessResponse<String>> removeFromCart(@RequestBody CartRequest cartRequest) throws Exception {
        cartService.removeFromCart(cartRequest.getMemberId(), cartRequest.getProductId());
        return ResponseEntity.ok(SuccessResponse.create(DELETE_PRODUCT_SUCCESS.getMessage()));
    }


    @GetMapping("/{memberId}")
    public CartResponseDto.CartResponse getCart(@PathVariable Long memberId) throws Exception {
        return cartService.getCart(memberId);

    }

}
