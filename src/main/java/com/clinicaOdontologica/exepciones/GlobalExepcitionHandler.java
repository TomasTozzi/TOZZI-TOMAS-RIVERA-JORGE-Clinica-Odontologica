package com.clinicaOdontologica.exepciones;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExepcitionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> manejarResourceNotFound(ResourceNotFoundException exception){
        Map<String, String> mensaje = new HashMap<>();
        mensaje.put("Mensaje: ", "Recurso No encontrado: " + exception.getMessage());
        return mensaje;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> procesarValidacionExcepcion (MethodArgumentNotValidException exception){
        Map<String, String> mensajeExcepcion = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach((error -> {
            String campoError = ((FieldError) error).getField();
            String mensajeError = error.getDefaultMessage();
            mensajeExcepcion.put(campoError, mensajeError);
        } ));
        return mensajeExcepcion;
    }

}
