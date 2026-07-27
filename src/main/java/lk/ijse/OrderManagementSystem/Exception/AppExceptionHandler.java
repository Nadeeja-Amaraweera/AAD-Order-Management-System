package lk.ijse.OrderManagementSystem.Exception;

import jakarta.servlet.http.HttpServletRequest;
import lk.ijse.OrderManagementSystem.Constant.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public CommonResponse handleServerException(RuntimeException ex, WebRequest request) {
        ex.printStackTrace();
        return new CommonResponse(500, "UNEXPECTED_ERROR");
    }

    @ExceptionHandler(value = {CustomeException.class})
    public ResponseEntity <CommonResponse> handleServerException(CustomeException ex, WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<>(new CommonResponse(ex.getStatus(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
