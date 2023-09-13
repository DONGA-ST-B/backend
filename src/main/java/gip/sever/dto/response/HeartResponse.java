package gip.sever.dto.response;

import gip.sever.domain.Heart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeartResponse {
    private Long memberId;
    private Long productId;
    private boolean isLiked;

    public HeartResponse(Heart heart) {
        this.memberId = heart.getMember_id();
        this.productId = heart.getProduct_id();
        this.isLiked = heart.isLiked();
    }

    // Getter 및 Setter 메서드
}

