package gip.sever.domain;

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
    private Long id;
    private String account;

    private String password;

    private String name;

    @OneToMany(mappedBy = "heart", cascade = CascadeType.ALL)
    private List<Heart> hearts;
}
