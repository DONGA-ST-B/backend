package gip.sever.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import gip.sever.domain.GoogleUser;
import gip.sever.domain.Member;
import gip.sever.domain.SessionUser;
import gip.sever.dto.request.AdditionalRequest;
import gip.sever.dto.request.GoogleOauthToken;
import gip.sever.repository.GoogleUserRepository;
import gip.sever.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class OauthService {

    private final GoogleOauth googleOauth;
    private final GoogleUserRepository googleUserRepository;
    private final MemberRepository memberRepository;

    private final HttpServletResponse response;


    public String request(String socialLoginType) throws IOException {
        String redirectURL = googleOauth.getOauthRedirectURL();
        response.sendRedirect(redirectURL);
        return redirectURL;
    }

    public int oauthLogin(HttpSession httpSession,String socialLoginType, String code) throws JsonProcessingException {

        ResponseEntity<String> accessTokenResponse = googleOauth.requestAccessToken(code);
        GoogleOauthToken OAuthToken = googleOauth.getAccessToken(accessTokenResponse);
        ResponseEntity<String> userInfoResponse = googleOauth.requestUserInfo(OAuthToken);
        GoogleUser googleUser = googleOauth.getUserInfo(userInfoResponse);
        googleUserRepository.save(googleUser);
        httpSession.setAttribute("user", new SessionUser(googleUser));


        if (memberRepository.findByEmail(googleUser.getEmail()).isEmpty()) { // 회원가입
            memberRepository.save(new Member(googleUser));
            return 1;
        }
        return 0;

    }

    public void additional(AdditionalRequest additionalRequest) {
        Member member = memberRepository.findByEmail("helloworldgcc@gmail.com").orElseThrow();
        member.updateInfo(additionalRequest);
        memberRepository.save(member);
    }


}
