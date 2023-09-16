package gip.sever.global.exception;

import gip.sever.global.response.ErrorCode;
import org.springframework.http.HttpStatus;

public class AdditionalException extends AddException {

    public AdditionalException() {
        super(ErrorCode.ADDITIONAL_INFO_NEED, HttpStatus.BAD_GATEWAY);
    }
}
