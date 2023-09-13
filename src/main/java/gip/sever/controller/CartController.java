package gip.sever.controller;


import gip.sever.dto.request.CartRequest;
import gip.sever.dto.response.CartResponse;
import gip.sever.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public void addToCart(@RequestBody CartRequest cartRequest) throws Exception {
        cartService.addToCart(cartRequest.getMemberId(), cartRequest.getProductId());
    }


    @DeleteMapping("/remove")
    public void removeFromCart(@RequestBody CartRequest cartRequest) throws Exception {
        cartService.removeFromCart(cartRequest.getMemberId(), cartRequest.getProductId());
    }


    @GetMapping("/{memberId}")
    public ResponseEntity<CartResponse> getCart(@RequestParam Long memberId) throws Exception {
        return new ResponseEntity<>( cartService.getCart(memberId), HttpStatus.OK);
    }
}