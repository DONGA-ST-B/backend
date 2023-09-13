package gip.sever.controller;

import gip.sever.domain.Member;
import gip.sever.domain.Product;
import gip.sever.dto.request.HeartRequest;
import gip.sever.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/heart")
public class HeartController {

    private final HeartService heartService;


    @PostMapping("/toggle")
    public ResponseEntity<String> toggleHeart(@RequestBody HeartRequest request) {
        Long memberId = request.getMemberId();
        Long productId= request.getProductId();

        boolean toggled = heartService.toggleHeart(memberId, productId);
        if (toggled) {
            return ResponseEntity.ok("좋아요 버튼이 활성화되었습니다.");
        } else {
            return ResponseEntity.ok("좋아요 버튼이 비활성화되었습니다.");
        }
    }

}

