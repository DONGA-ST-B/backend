package gip.sever.global.exception;

import gip.sever.global.response.ErrorCode;
import org.springframework.http.HttpStatus;

public abstract class AddException extends ApplicationException {


    protected AddException(ErrorCode errorCode, HttpStatus httpStatus) {
        super(errorCode, httpStatus);
    }
}
