package gip.sever.dto.request;

import gip.sever.domain.Member;
import gip.sever.domain.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeartRequest {
    private Member member;
    private Product product;

    // getters and setters
}
