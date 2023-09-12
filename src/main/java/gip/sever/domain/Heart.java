package gip.sever.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Long member_id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Long product_id;

    private boolean isLiked;


    public Heart(Long member_id, Long product_id, boolean isLiked) {
        this.member_id = member_id;
        this.product_id = product_id;
        this.isLiked = isLiked;
    }


}
