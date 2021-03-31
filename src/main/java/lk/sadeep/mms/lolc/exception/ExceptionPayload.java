package lk.sadeep.mms.lolc.exception;

import org.springframework.http.HttpStatus;

public class ExceptionPayload
{
    private final String message;
    private final HttpStatus httpStatus;
    private final String dateTime;

    public ExceptionPayload(String message, HttpStatus httpStatus, String dateTime)
    {
        this.message = message;
        this.httpStatus = httpStatus;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getDateTime() {
        return dateTime;
    }
}
