package gip.sever.domain;

import gip.sever.dto.request.AdditionalRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String presidentName;
    private String businessName;
    private String businessNumber;
    private String type;

    @OneToOne
    private GoogleUser googleUser;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Heart> hearts;

    public Member(GoogleUser googleUser) {
        this.googleUser = googleUser;
        this.email = googleUser.getEmail();
    }

    public void updateInfo(AdditionalRequest additionalRequest) {
        this.presidentName = additionalRequest.getPresident();
        this.businessName = additionalRequest.getBusinessName();
        this.businessNumber = additionalRequest.getBusinessNumber();
        this.type = additionalRequest.getType();
    }
}
