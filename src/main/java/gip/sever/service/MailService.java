package gip.sever.service;

import gip.sever.dto.request.MailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendEmail(MailRequest mailRequest) {


        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("dongast28th@gmail.com");

        message.setSubject(mailRequest.getDepartment() + "데모 신청 건");
        message.setText(mailRequest.toString());
        javaMailSender.send(message);

        return "Success";
    }
}
