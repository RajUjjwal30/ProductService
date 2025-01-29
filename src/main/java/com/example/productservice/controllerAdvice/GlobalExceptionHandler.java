package com.example.productservice.controllerAdvice;

import com.example.productservice.dtos.ExceptionDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){

        ExceptionDto exceptiondto = new ExceptionDto();
        exceptiondto.setMessage("Arithmetic exception has happened !");
        exceptiondto.setSolution("I don't know what to do with this exception");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptiondto,
                HttpStatus.NOT_FOUND
        );
        return response;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayIndexOutOfBoundsException(){

        ResponseEntity<String> response = new ResponseEntity<>(
                "ArrayIndexOutOfBoundsException has happened !",
                HttpStatus.NOT_FOUND
        );
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(){
        ExceptionDto exceptiondto = new ExceptionDto();

        //TODO : pass id from the controller(what id user is passing)

        exceptiondto.setMessage("Product not found !");
        exceptiondto.setSolution("Please try with a valid product id !");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptiondto,
                HttpStatus.NOT_FOUND
        );
        return response;
    }
}
