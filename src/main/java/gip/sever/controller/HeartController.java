package gip.sever.controller;

import gip.sever.domain.Member;
import gip.sever.domain.Product;
import gip.sever.domain.SessionUser;
import gip.sever.dto.request.HeartRequest;
import gip.sever.repository.MemberRepository;
import gip.sever.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/heart")
public class HeartController {

    private final HeartService heartService;
    private final HttpSession httpSession;

    private final MemberRepository memberRepository;


    @PostMapping("/toggle/{productId}")
    public ResponseEntity<String> toggleHeart(@PathVariable Long productId) {

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        Member member = memberRepository.findByEmail(user.getEmail()).orElseThrow();
        Long memberId = member.getId();

        boolean toggled = heartService.toggleHeart(memberId, productId);
        if (toggled) {
            return ResponseEntity.ok("좋아요 버튼이 활성화되었습니다.");
        } else {
            return ResponseEntity.ok("좋아요 버튼이 비활성화되었습니다.");
        }
    }

}

