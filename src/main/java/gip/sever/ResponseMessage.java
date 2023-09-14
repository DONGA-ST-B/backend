package gip.sever;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseMessage {
    GET_CART_SUCCESS("장바구니 조회를 완료 했습니다."),
    CREATE_CART_SUCCESS("장바구니 담기를 완료 했습니다."),
    TRUE_HEART("좋아요 버튼이 활성화 되었습니다."),
    FALSE_HEART("좋아요 버튼이 비활성화 되었습니다."),
    MAIL_SUCCESS("데모 신청이 완료되었습니다"),
    ADDITIONAL_INFO_NEED("추가정보 기입이 필요합니다"),
    LOGIN_SUCCESS("로그인 성공"),
    ADDITIONAL_INFO_SUCCESS("추가 정보 기입이 완료되었습니다");
    private final String message;


    }
