package gip.sever.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import gip.sever.domain.SessionUser;
import gip.sever.dto.request.AdditionalRequest;
import gip.sever.global.response.SuccessResponse;
import gip.sever.service.OauthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static gip.sever.ResponseMessage.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class OauthController {

    private final OauthService oauthService;
    private final HttpSession httpSession;

    @GetMapping(value = "/{socialLoginType}")
    public void socialLoginType(@PathVariable(name = "socialLoginType") String socialLoginType) throws IOException {

        oauthService.request(socialLoginType);
    }

    @GetMapping(value = "/{socialLoginType}/callback")
    public ResponseEntity<SuccessResponse<String>> callback(
            @PathVariable(name = "socialLoginType") String socialLoginType,
            @RequestParam(name = "code") String code) throws JsonProcessingException {
        if(oauthService.oauthLogin(socialLoginType, code)==1){
            return ResponseEntity.ok(SuccessResponse.create(ADDITIONAL_INFO_NEED.getMessage()));
        }else{
            return ResponseEntity.ok(SuccessResponse.create(LOGIN_SUCCESS.getMessage()));
        }


    }

    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        SessionUser user1 = (SessionUser) request.getSession(true).getAttribute("user");
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return user1.getName();
    }
    @PostMapping("/additional")
    public ResponseEntity<SuccessResponse<String>> additionalInfo(AdditionalRequest additionalRequest) {
        oauthService.additional(additionalRequest);
        return ResponseEntity.ok(SuccessResponse.create(ADDITIONAL_INFO_SUCCESS.getMessage()));
    }
}