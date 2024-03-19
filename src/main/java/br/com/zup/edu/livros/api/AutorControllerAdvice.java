package br.com.zup.edu.livros.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class AutorControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> MethodArgumentNotValidException(MethodArgumentNotValidException ex){
        BindingResult  bindingResult = ex.getBindingResult();
        List<FieldError> errorList = bindingResult.getFieldErrors();

        List<String> messages = new ArrayList<String>();

        for (FieldError fieldError : errorList) {
            messages.add(String.format("Campo %s: %s", fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return ResponseEntity.badRequest().body(messages);
    }

}
