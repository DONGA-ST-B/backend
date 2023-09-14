package gip.sever.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class CartRequest {
    private Long productId;
    private Long memberId;


}
