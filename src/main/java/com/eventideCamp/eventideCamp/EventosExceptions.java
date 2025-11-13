package com.eventideCamp.eventideCamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class EventosExceptions {
//Cuando un punto de entrada es validado con @Validate y lanza un error por que un campo esta mal esta clase lanza el
// error correspondiente
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException error) {

        String errorMessage = error.getBindingResult()
                //Devuelve todos los errores en la validacion
                .getFieldErrors()
                //Cojemos solo el primer error de la lista (Iremos corrigiendo uno por uno)
                .get(0)
                //Aqui nos da el texto de error que hemos puesto en el modelo
                .getDefaultMessage();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR: " + HttpStatus.BAD_REQUEST.value() + " " + HttpStatus.BAD_REQUEST.getReasonPhrase() + "\nMotivo: " + errorMessage);
    }
}
