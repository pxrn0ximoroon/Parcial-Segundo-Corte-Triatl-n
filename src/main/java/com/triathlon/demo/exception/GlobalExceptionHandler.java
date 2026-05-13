package com.triathlon.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase para manejar los errores que puedan pasar en el sistema.
 * En vez de que el backend explote , retorna un mensaje de error al frontend.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Captura los errores de tipo RuntimeException.
     * Por ejemplo cuando no se encuentra un atleta en la bd.
     * retorna un mapa con el mensaje de error y estado 404.
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFound(RuntimeException ex) {
        return Map.of("error", ex.getMessage());
    }

    /**
     * Captura los errores de validacion cuando los datos del frontend estan mal.
     * Por ejemplo si el email no tiene formato valido o la edad es menor a 7.
     * retorna un mapa con todos los campos que fallaron y su mensaje de error.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errores.put(error.getField(), error.getDefaultMessage())
        );
        return errores;
    }
}