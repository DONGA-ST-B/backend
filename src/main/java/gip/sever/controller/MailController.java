package gip.sever.controller;

import gip.sever.dto.request.MailRequest;
import gip.sever.global.response.SuccessResponse;
import gip.sever.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static gip.sever.ResponseMessage.FALSE_HEART;
import static gip.sever.ResponseMessage.MAIL_SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/demo")
public class MailController {

    private final MailService mailService;

    @PostMapping()
    public ResponseEntity<SuccessResponse<String>> submitDemo(@RequestBody MailRequest mailRequest) {
        mailService.sendEmail(mailRequest);
        return ResponseEntity.ok(SuccessResponse.create(MAIL_SUCCESS.getMessage()));

    }
}
