package gip.sever;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseMessage {
    GET_ARTICLE_SUCCESS("기사 조회를 완료 했습니다."),
    GET_CART_SUCCESS("장바구니 조회를 완료 했습니다."),
    CREATE_CART_SUCCESS("장바구니 담기를 완료 했습니다."),
    TRUE_HEART("좋아요 버튼이 활성화 되었습니다."),
    FALSE_HEART("좋아요 버튼이 비활성화 되었습니다."),
    MAIL_SUCCESS("데모 신청이 완료되었습니다");
    private final String message;


    }
