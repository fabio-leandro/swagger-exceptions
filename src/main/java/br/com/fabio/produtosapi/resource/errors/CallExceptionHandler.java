package br.com.fabio.produtosapi.resource.errors;

import br.com.fabio.produtosapi.exception.ObjectNotFoundException;
import br.com.fabio.produtosapi.exception.ValidationsExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CallExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<MsgError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {
        MsgError msgError = new MsgError();
        msgError.setStatus(HttpStatus.NOT_FOUND.value());
        msgError.setMessage(e.getMessage());
        msgError.setError("Object Not Found.");
        msgError.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msgError);
    }

    @ExceptionHandler(ValidationsExceptions.class)
    public ResponseEntity<MsgError> validations(ValidationsExceptions e, HttpServletRequest request){
        MsgError msgError = new MsgError();
        msgError.setStatus(HttpStatus.BAD_REQUEST.value());
        msgError.setMessage(e.getMessage());
        msgError.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msgError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MsgError> otherExceptions(Exception e, HttpServletRequest request){
        MsgError msgError = new MsgError();
        msgError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        msgError.setMessage(e.getMessage());
        msgError.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msgError);
    }


}
