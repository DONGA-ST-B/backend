package gip.sever.dto.request;

import gip.sever.domain.Member;
import gip.sever.domain.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeartRequest {
    private Long memberId;
    private Long productId;

}
