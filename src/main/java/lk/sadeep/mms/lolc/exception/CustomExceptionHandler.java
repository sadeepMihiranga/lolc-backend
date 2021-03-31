package lk.sadeep.mms.lolc.exception;

import lk.sadeep.mms.lolc.util.AppConstants;
import lk.sadeep.mms.lolc.util.CommonUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler
{
    @ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException exception)
    {
        HttpStatus badRequest = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(createExceptionPayloadBy(exception.getMessage(), badRequest), badRequest);
    }

    @ExceptionHandler(value = {DuplicateEntryException.class})
    public ResponseEntity<Object> handleDuplicateEntryException(DuplicateEntryException exception)
    {
        HttpStatus badRequest = HttpStatus.UNPROCESSABLE_ENTITY;

        return new ResponseEntity<>(createExceptionPayloadBy(exception.getMessage(), badRequest), badRequest);
    }

    private static ExceptionPayload createExceptionPayloadBy(String message, HttpStatus badRequest)
    {
        return new ExceptionPayload(
                message,
                badRequest,
                CommonUtil.convertDateTime(LocalDateTime.now(), AppConstants.DATE_FORMAT_BASIC)
        );
    }
}
