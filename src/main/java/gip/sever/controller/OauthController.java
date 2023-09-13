package gip.sever.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import gip.sever.domain.SessionUser;
import gip.sever.service.OauthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    public void callback(
            @PathVariable(name = "socialLoginType") String socialLoginType,
            @RequestParam(name = "code") String code) throws JsonProcessingException {
        oauthService.oauthLogin(socialLoginType, code);

    }

    @GetMapping("/check")
    public String check() {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return user.getName();
    }
}