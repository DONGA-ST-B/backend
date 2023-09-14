package gip.sever.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MailRequest {

    private String type;
    private String name;
    private String department;
    private String email;
    private String contact;

    @Override
    public String toString() {
        return "데모 신청 {" +
                "신청한 데모 ='" + type + '\'' +
                ", 신청자 이름 ='" + name + '\'' +
                ", 신청 부서 ='" + department + '\'' +
                ", 신청자 이메일 ='" + email + '\'' +
                ", 신청자 연락처 ='" + contact + '\'' +
                '}';
    }
}
