package gip.sever.controller;

import gip.sever.domain.Member;
import gip.sever.domain.Product;
import gip.sever.domain.SessionUser;
import gip.sever.dto.request.HeartRequest;
import gip.sever.global.response.SuccessResponse;
import gip.sever.repository.MemberRepository;
import gip.sever.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static gip.sever.ResponseMessage.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/heart")
public class HeartController {

    private final HeartService heartService;
    private final MemberRepository memberRepository;

    @PostMapping("/toggle/{productId}")
    public ResponseEntity<SuccessResponse<String>> toggleHeart(HttpServletRequest request, @PathVariable(name = "productId") Long productId) {

//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        SessionUser user = (SessionUser) request.getSession(true).getAttribute("user");

        Member member = memberRepository.findByEmail(user.getEmail()).orElseThrow();
        Long memberId = member.getId();

        boolean toggled = heartService.toggleHeart(memberId, productId);
        if (toggled) {
            return ResponseEntity.ok(SuccessResponse.create(TRUE_HEART.getMessage()));
        } else {
            return ResponseEntity.ok(SuccessResponse.create(FALSE_HEART.getMessage()));
        }


    }

}

