package gip.sever.controller;

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
    public ResponseEntity<String> toggleHeart(
            @RequestParam Long memberId,
            @RequestParam Long productId) {
        boolean toggled = heartService.toggleHeart(memberId, productId);
        if (toggled) {
            return ResponseEntity.ok("좋아요 버튼이 활성화되었습니다.");
        } else {
            return ResponseEntity.ok("좋아요 버튼이 비활성화되었습니다.");
        }
    }
}

