package es.upm.miw.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.upm.miw.resources.exceptions.ErrorMessage;
import es.upm.miw.resources.exceptions.FileException;
import es.upm.miw.resources.exceptions.ForbiddenException;
import es.upm.miw.resources.exceptions.UserIdNotFoundException;
import es.upm.miw.resources.exceptions.UserFieldAlreadyExistException;
import es.upm.miw.resources.exceptions.FieldInvalidException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
        FileException.class,
        UserIdNotFoundException.class,
    })
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception) {
        return new ErrorMessage(exception, request.getRequestURI());
    }

    // Exception
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
        MethodArgumentNotValidException.class,
        HttpMessageNotReadableException.class,
        FieldInvalidException.class,
        UserFieldAlreadyExistException.class,
    })
    @ResponseBody
    public ErrorMessage badRequest(Exception exception) {
        return new ErrorMessage(exception, exception.getStackTrace().toString());
    }


    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({
        AccessDeniedException.class,
        ForbiddenException.class,
    })
    @ResponseBody
    public ErrorMessage forbiddenRequest(Exception exception) {
        System.out.println(exception.toString());
        return new ErrorMessage(exception, "");
    }
    
    // Exception
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
        Exception.class,
    })
    @ResponseBody
    public ErrorMessage exception(Exception exception) {
        exception.printStackTrace();
        return new ErrorMessage(exception, exception.getStackTrace().toString());
    }
   
    
}
