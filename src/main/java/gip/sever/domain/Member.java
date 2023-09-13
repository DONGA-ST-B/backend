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
<<<<<<< HEAD
    @Column(name = "product_id")
=======
    @Column(name = "member_id")
>>>>>>> c4962aa068cee0fc9912c582232e2c4017d6f018
    private Long id;
    private String account;

    private String password;

    private String name;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Heart> hearts;
}
