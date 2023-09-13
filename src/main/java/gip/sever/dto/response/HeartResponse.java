package gip.sever.dto.response;

import gip.sever.domain.Heart;
import gip.sever.domain.Member;
import gip.sever.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeartResponse {
    private Member member;
    private Product product;
    private boolean isLiked;

    public HeartResponse(Heart heart) {
        this.member = heart.getMember();
        this.product = heart.getProduct();
        this.isLiked = heart.isLiked();
    }

    // Getter 및 Setter 메서드
}

